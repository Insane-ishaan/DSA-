# Write your MySQL query statement below
SELECT
a.player_id,
(
    SELECT
    MIN(event_date)
    FROM
    Activity
    WHERE player_id = a.player_id 
) AS first_login
FROM
Activity a
GROUP BY player_id;