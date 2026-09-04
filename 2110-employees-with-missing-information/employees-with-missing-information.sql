# Write your MySQL query statement below
SELECT
t.employee_id
FROM
(SELECT 
(CASE WHEN e.name IS NULL AND s.salary IS NOT NULL THEN s.employee_id END) AS employee_id
FROM Employees e RIGHT JOIN Salaries s
ON e.employee_id = s.employee_id

UNION 

SELECT
(CASE WHEN  s.salary IS NULL AND e.name IS NOT NULL THEN e.employee_id END) AS employee_id
FROM Employees e LEFT JOIN Salaries s
ON e.employee_id = s.employee_id) AS t
WHERE t.employee_id IS NOT NULL
ORDER BY t.employee_id;