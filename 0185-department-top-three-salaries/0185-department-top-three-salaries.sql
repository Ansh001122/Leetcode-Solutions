# Write your MySQL query statement below
/*select d.name as Department ,e.name  as Employee, e.salary as Salary
from (
    select *, dense_rank() over (partition by departmentid order by salary desc)as rnk
    from employee
)e
join Department d
on departmentid = d.id
where rnk <= 3;*/
   
SELECT 
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM (
    SELECT 
        id,
        name,
        salary,
        departmentId,
        DENSE_RANK() OVER (
            PARTITION BY departmentId 
            ORDER BY salary DESC
        ) AS rnk
    FROM Employee
) e
JOIN Department d
ON e.departmentId = d.id
WHERE e.rnk <= 3;
