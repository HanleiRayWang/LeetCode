/*

A U.S graduate school has students from Asia, Europe and America. 
The students' location information are stored in table student as below.
| name   | continent |
|--------|-----------|
| Jack   | America   |
| Pascal | Europe    |
| Xi     | Asia      |
| Jane   | America   |

Pivot the continent column in this table so that each name is sorted alphabetically 
and displayed underneath its corresponding continent. 
The output headers should be America, Asia and Europe respectively. 

It is guaranteed that the student number from America is no less than either Asia or Europe.

For the sample input, the output is:
| America | Asia | Europe |
|---------|------|--------|
| Jack    | Xi   | Pascal |
| Jane    |      |        |

Follow-up: If it is unknown which continent has the most students, can you write a query to generate the student report?

*/

#此解法只试用于“已知America中人数最多”的情况
#It is guaranteed that the student number from America is no less than either Asia or Europe.
set @a=0;
set @b=0;
set @c=0;
select America.name as America, Asia.name as Asia, Europe.name as Europe
from
(select name, @a:=@a+1 as id from student where continent='America' order by name) as America
LEFT JOIN
(select name, @b:=@b+1 as id from student where continent='Asia' order by name) as Asia on America.id=Asia.id
LEFT JOIN
(select name, @c:=@c+1 as id from student where continent='Europe' order by name) as Europe on America.id=Europe.id;
