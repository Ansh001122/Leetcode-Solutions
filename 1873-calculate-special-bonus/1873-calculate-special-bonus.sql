# Write your MySQL query statement below
select
    employee_id,
    coalesce(
        case
            when 
                employee_id % 2 != 0
                and left(name, 1) != 'M'
            then salary
        end,
        0
    ) as bonus
from Employees
order by employee_id