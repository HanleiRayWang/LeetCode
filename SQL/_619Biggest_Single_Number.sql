/*

Table number contains many numbers in column num including duplicated ones.
Can you write a SQL query to find the biggest number, which only appears once.
+---+
|num|
+---+
| 8 |
| 8 |
| 3 |
| 3 |
| 1 |
| 4 |
| 5 |
| 6 | 

For the sample data above, your query should return the following result:
+---+
|num|
+---+
| 6 |
Note:
If there is no such number, just output null.

*/

select (select num
from number
group by num
having count(*)=1
order by num desc
limit 1) as num

#注意： 这里要求如果没有结果输出null，因此需要在sql代码外再套一层select X as num
#这样就可以达到输出null的效果
