# Write your MySQL query statement below
SELECT c.name AS Customers
FROM 
Customers c
LEFT Join orders o ON c.id = o.customerId
WHERE 
o.customerid  IS NULL; 
