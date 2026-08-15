# Write your MySQL query statement below
# Case 1: Explicitly marked primary department
SELECT employee_id, department_id
FROM Employee
WHERE primary_flag = 'Y'
UNION
# Case 2: Employee belongs to only 1 department
SELECT  employee_id,  department_id
FROM Employee
GROUP BY employee_id
HAVING COUNT(department_id) = 1;