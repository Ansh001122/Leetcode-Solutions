# Write your MySQL query statement below
WITH RankedEmployee AS (
    SELECT 
        employee_id,
        department_id,
        primary_flag,
        COUNT(department_id) OVER(PARTITION BY employee_id) AS dept_count
    FROM 
        Employee
)
SELECT 
    employee_id,
    department_id
FROM 
    RankedEmployee
WHERE 
    primary_flag = 'Y' 
    OR dept_count = 1;