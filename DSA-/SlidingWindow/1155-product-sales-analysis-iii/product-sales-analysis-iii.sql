# Write your MySQL query statement below
SELECT 
product_id,
first_year,
quantity,
price
FROM
(
    SELECT
    year,
    product_id,
    year  AS first_year,
    quantity,
    price,
    RANK() OVER(
    PARTITION BY product_id
    ORDER BY year 
    ) AS rn
    FROM
    Sales
) AS t
WHERE rn = 1;