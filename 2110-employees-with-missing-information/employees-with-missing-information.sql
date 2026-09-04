-- Write your PostgreSQL query statement below
SELECT
*
FROM
(SELECT 
(CASE WHEN e.name IS NULL AND s.salary IS NOT NULL THEN s.employee_id END) AS employee_id
FROM Employees e RIGHT JOIN Salaries s
ON e.employee_id = s.employee_id

UNION 

SELECT
(CASE WHEN  s.salary IS NULL AND e.name IS NOT NULL THEN e.employee_id END) AS employee_id
FROM Employees e LEFT JOIN Salaries s
ON e.employee_id = s.employee_id)
WHERE employee_id IS NOT NULL
ORDER BY employee_id;