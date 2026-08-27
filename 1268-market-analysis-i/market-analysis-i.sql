-- Write your PostgreSQL query statement below
SELECT
u.user_id AS buyer_id,
u.join_date AS join_date,
COUNT(o.buyer_id) AS orders_in_2019
FROM
Users u LEFT JOIN Orders o
ON u.user_id = o.buyer_id AND EXTRACT(YEAR FROM o.order_date) = 2019
GROUP BY o.buyer_id,u.user_id,u.join_date;