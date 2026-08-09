# Write your MySQL query statement below
WITH DailyTotals AS (
    SELECT 
        visited_on, 
        SUM(amount) AS daily_amount 
    FROM Customer              
    GROUP BY visited_on
)
SELECT 
    visited_on,
    amount,
    ROUND(amount / 7.0, 2) AS average_amount 
FROM (
    SELECT 
        visited_on,
        DENSE_RANK() OVER (ORDER BY visited_on) AS rnk,
        SUM(daily_amount) OVER (ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) AS amount
    FROM DailyTotals
) t
WHERE rnk >= 7;