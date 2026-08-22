-- Question: Write an INNER JOIN and a LEFT JOIN to combine customers and orders.
--
-- Assumption:
-- customers(customer_id, customer_name)
-- orders(order_id, customer_id, order_date, amount)

-- INNER JOIN: returns only customers who have at least one matching order.
SELECT c.customer_id,
       c.customer_name,
       o.order_id,
       o.order_date,
       o.amount
FROM customers AS c
INNER JOIN orders AS o
    ON c.customer_id = o.customer_id;

-- LEFT JOIN: keeps EVERY customer.
-- If a customer has no order, order_id/order_date/amount are NULL.
SELECT c.customer_id,
       c.customer_name,
       o.order_id,
       o.order_date,
       o.amount
FROM customers AS c
LEFT JOIN orders AS o
    ON c.customer_id = o.customer_id;
