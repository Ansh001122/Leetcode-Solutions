# Write your MySQL query statement below
WITH DailyTotals AS (
    -- Step 1: Group by visited_on to aggregate daily total amounts
    SELECT 
        visited_on, 
        SUM(amount) AS daily_amount
    FROM Customer
    GROUP BY visited_on
),
MovingWindow AS (
    -- Step 2: Calculate 7-day moving sum and average using window functions
    SELECT 
        visited_on,
        SUM(daily_amount) OVER (
            ORDER BY visited_on 
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) AS amount,
        ROUND(AVG(daily_amount) OVER (
            ORDER BY visited_on 
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ), 2) AS average_amount,
        DENSE_RANK() OVER (ORDER BY visited_on) AS rnk
    FROM DailyTotals
)
-- Step 3: Filter out the first 6 days since they don't have a full 7-day history
SELECT 
    visited_on, 
    amount, 
    average_amount
FROM MovingWindow
WHERE rnk >= 7
ORDER BY visited_on ASC;