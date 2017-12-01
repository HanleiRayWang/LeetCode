/*

Table point_2d holds the coordinates (x,y) of some unique points (more than two) in a plane.

Write a query to find the shortest distance between these points rounded to 2 decimals.
| x  | y  |
|----|----|
| -1 | -1 |
| 0  | 0  |
| -1 | -2 |
The shortest distance is 1.00 from point (-1,-1) to (-1,2). So the output should be:
| shortest |
|----------|
| 1.00     |
Note: The longest distance among all the points are less than 10000.

*/


#这题很有意思，用selfjoin实现了N*N的配对
select round(
            min(
                sqrt(
                    (point1.x-point2.x)*(point1.x-point2.x)+(point1.y-point2.y)*(point1.y-point2.y)
                )
            )
        ,2) as shortest
from point_2d point1, point_2d point2
where not (point1.x=point2.x and point1.y=point2.y)
