# Write your MySQL query statement below
SELECT
user_id,
email
FROM
Users
WHERE email REGEXP '^[A-za-z0-9_]+@[a-zA-Z]+[.]com$'
ORDER BY user_id;