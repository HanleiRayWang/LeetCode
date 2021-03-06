/*

The Employee table holds all employees including their managers. 
Every employee has an Id, and there is also a column for the manager Id.

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
Given the Employee table, write a SQL query that finds out employees who earn more than their managers. 
For the above table, Joe is the only employee who earns more than his manager.

+----------+
| Employee |
+----------+
| Joe      |
+----------+

*/


#方法一  --> sub-select
select name as Employee
from employee e1
where managerId is not null and salary > (select salary from employee e2 where e1.managerId=e2.id)

#方法二  --> self-join
select e1.name as Employee
from employee e1, employee e2
where e1.managerId=e2.id and e1.salary>e2.salary
