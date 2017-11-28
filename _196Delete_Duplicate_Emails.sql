/*


Write a SQL query to delete all duplicate email entries in a table named Person, 
keeping only unique emails based on its smallest Id.

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+

Id is the primary key column for this table.
For example, after running your query, the above Person table should have the following rows:

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+


*/


#这个方法需要好好学习
#使用MIN函数过滤除去重复的行
delete from person
where id not in (select temp.id
                 from (select MIN(id) as id
                       from person
                       group by email) as temp)
                       
                       
