# Write your MySQL query statement below
SELECT 
email AS Email
FROM Person
GROUP by email
HAVING COUNT(email) > 1;