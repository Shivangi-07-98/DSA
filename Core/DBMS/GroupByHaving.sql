-- Question: Find customers whose total number of orders is more than 3.
--
-- WHERE filters individual order rows BEFORE we make groups.
-- Here it keeps only completed orders.
-- GROUP BY puts all remaining orders of one customer into one group.
-- HAVING filters those final groups, so COUNT(*) can be used here.

SELECT customer_id,
       COUNT(*) AS completed_order_count,
       SUM(amount) AS completed_order_amount
FROM orders
WHERE status = 'COMPLETED'
GROUP BY customer_id
HAVING COUNT(*) > 3
ORDER BY completed_order_count DESC;
