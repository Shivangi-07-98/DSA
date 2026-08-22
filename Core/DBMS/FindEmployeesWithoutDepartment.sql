-- Question: Find employees who are not assigned to any valid department.
--
-- LEFT JOIN first keeps every employee.
-- When no department matches, the right-side department_id becomes NULL.
-- Filtering that NULL gives the employees without a matching department.

SELECT e.employee_id,
       e.employee_name,
       e.department_id
FROM employees AS e
LEFT JOIN departments AS d
    ON e.department_id = d.department_id
WHERE d.department_id IS NULL;
