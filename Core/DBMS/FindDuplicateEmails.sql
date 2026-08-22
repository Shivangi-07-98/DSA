-- Question: Find email values that appear more than once in the users table.
--
-- GROUP BY makes one group for each email.
-- COUNT(*) counts rows inside that email group.
-- HAVING is used because the count exists only after grouping.

SELECT email,
       COUNT(*) AS times_used
FROM users
WHERE email IS NOT NULL
GROUP BY email
HAVING COUNT(*) > 1;
