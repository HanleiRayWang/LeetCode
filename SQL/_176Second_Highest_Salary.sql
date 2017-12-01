/*

Write a SQL query to get the second highest salary from the Employee table.
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+

For example, given the above Employee table, the query should return 200 as the second highest salary. 
If there is no second highest salary, then the query should return null.
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

*/

#方法一
select salary as secondhighestsalary
from employee e1
where 1 = (select count(salary) from employee e2 where e2.salary>e1.salary)

#方法二
SELECT MAX(Salary) as SecondHighestSalary 
FROM Employee
WHERE Salary NOT IN (SELECT MAX(Salary) FROM Employee)
