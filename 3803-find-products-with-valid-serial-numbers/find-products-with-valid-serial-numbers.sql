# Write your MySQL query statement below
SELECT 
product_id,
product_name,
description
FROM products
WHERE description COLLATE utf8mb3_bin 
REGEXP '(^|[^a-zA-Z0-9])SN([0-9]{4}){1}[-]([0-9]{4}){1}([^0-9A-Z]|$)'
ORDER BY product_id;