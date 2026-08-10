# Write your MySQL query statement below
WITH TopUser AS (
    SELECT 
        u.name AS results,
        DENSE_RANK() OVER (ORDER BY COUNT(mr.movie_id) DESC, u.name ASC) as rnk
    FROM MovieRating mr
    JOIN Users u ON mr.user_id = u.user_id
    GROUP BY mr.user_id, u.name
),
TopMovie AS (
    SELECT 
        m.title AS results,
        DENSE_RANK() OVER (ORDER BY AVG(mr.rating) DESC, m.title ASC) as rnk
    FROM MovieRating mr
    JOIN Movies m ON mr.movie_id = m.movie_id
    WHERE mr.created_at >= '2020-02-01' AND mr.created_at < '2020-03-01'
    GROUP BY mr.movie_id, m.title
)
SELECT results FROM TopUser WHERE rnk = 1
UNION ALL
SELECT results FROM TopMovie WHERE rnk = 1;