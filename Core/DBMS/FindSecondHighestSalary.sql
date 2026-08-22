-- Question: Find the second highest DISTINCT salary from the employees table.
--
-- We want the second different salary, not simply the salary in row number 2.
-- Example: 100000, 90000, 90000, 80000 -> answer is 90000.
-- DENSE_RANK gives equal salaries the same rank, so rank 2 is the answer.

SELECT salary AS second_highest_salary
FROM (
    SELECT salary,
           DENSE_RANK() OVER (ORDER BY salary DESC) AS salary_rank
    FROM employees
    WHERE salary IS NOT NULL
) ranked_salaries
WHERE salary_rank = 2;

-- Simple alternative when window functions are not expected:
-- First find the highest salary. Then find the largest salary below it.
SELECT MAX(salary) AS second_highest_salary
FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);
