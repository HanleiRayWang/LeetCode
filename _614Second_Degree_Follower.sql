/*

In facebook, there is a follow table with two columns: followee, follower.

Please write a sql query to get the amount of each follower’s follower if he/she has one.

For example:

+-------------+------------+
| followee    | follower   |
+-------------+------------+
|     A       |     B      |
|     B       |     C      |
|     B       |     D      |
|     D       |     E      |
+-------------+------------+
should output:
+-------------+------------+
| follower    | num        |
+-------------+------------+
|     B       |  2         |
|     D       |  1         |
+-------------+------------+
Explaination:
Both B and D exist in the follower list, when as a followee, B's follower is C and D, and D's follower is E. A does not exist in follower list.
Note:
Followee would not follow himself/herself in all cases.
Please display the result in follower's alphabet order.

*/

#理论上正确但是没有通过，因为有大小写问题
select followee as follower, count(distinct follower) as num
from follow
where followee in (select follower from follow)
group by followee
order by followee

#下面这种方法更好，用self-join
select f1.follower, count(distinct f2.follower) as num
from follow f1, follow f2
where f1.follower = f2.followee
group by f1.follower
