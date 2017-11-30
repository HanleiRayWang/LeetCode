/*

The Employee table holds all employees. The employee table has three columns: Employee Id, Company Name, and Salary.

+-----+------------+--------+
|Id   | Company    | Salary |
+-----+------------+--------+
|1    | A          | 2341   |
|2    | A          | 341    |
|3    | A          | 15     |
|4    | A          | 15314  |
|5    | A          | 451    |
|6    | A          | 513    |
|7    | B          | 15     |
|8    | B          | 13     |
|9    | B          | 1154   |
|10   | B          | 1345   |
|11   | B          | 1221   |
|12   | B          | 234    |
|13   | C          | 2345   |
|14   | C          | 2645   |
|15   | C          | 2645   |
|16   | C          | 2652   |
|17   | C          | 65     |
+-----+------------+--------+
Write a SQL query to find the median salary of each company. Bonus points if you can solve it without using any built-in SQL functions.

+-----+------------+--------+
|Id   | Company    | Salary |
+-----+------------+--------+
|5    | A          | 451    |
|6    | A          | 513    |
|12   | B          | 234    |
|9    | B          | 1154   |
|14   | C          | 2645   |
+-----+------------+--------+

*/

#注意：如果不在groupby中但是一定要选一个，用any_value函数

#So in general, the median's frequency should be equal or grater than 
#the absolute difference of its bigger elements and small ones in an array 
#no matter whether it has odd or even amount of numbers and whether they are distinct.

select any_value(a.id) as id, a.company, a.salary
from employee a, employee b
where a.company=b.company
group by a.company, a.salary
having sum(case when a.salary=b.salary then 1 else 0 end)
        >=
       abs(sum(sign(a.salary-b.salary)))
order by a.company, a.id;
