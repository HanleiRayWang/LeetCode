/*


Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Note: All emails are in lowercase.


*/



#方法一
select temp.email
from (select email, count(distinct id) as num
      from person
      group by email) as temp
where temp.num>1
order by temp.email

#方法二
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(*)>1;
