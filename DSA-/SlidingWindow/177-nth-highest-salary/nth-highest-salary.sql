CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN 
  (
    # Write your MySQL query statement below.
    SELECT
    t.salary
    FROM
    (
        SELECT
        salary,
        DENSE_RANK() OVER (
            ORDER BY salary DESC
        ) as highSal
    FROM
    Employee
  ) AS t
  WHERE highSal = N
  LIMIT 1
  );
END