# Write your MySQL query statement below
select emp.name as Employee
From Employee as emp
JOIN 
    Employee AS mgr 
    ON emp.managerId = mgr.id
WHERE 
    emp.salary > mgr.salary;