/*

Several friends at a cinema ticket office would like to reserve consecutive available seats.
Can you help to query all the consecutive available seats order by the seat_id using the following cinema table?

| seat_id | free |
|---------|------|
| 1       | 1    |
| 2       | 0    |
| 3       | 1    |
| 4       | 1    |
| 5       | 1    |
Your query should return the following result for the sample case above.
| seat_id |
|---------|
| 3       |
| 4       |
| 5       |

Note:
The seat_id is an auto increment int, and free is bool ('1' means free, and '0' means occupied.).
Consecutive available seats are more than 2(inclusive) seats consecutively available.

*/


select distinct a.seat_id
from cinema a, cinema b
where a.free=1 and b.free=1 and (a.seat_id+1=b.seat_id or a.seat_id-1=b.seat_id)
order by a.seat_id

#注意： 为了保证1号座位和n号座位都能包括，需要使用(a.seat_id+1=b.seat_id or a.seat_id-1=b.seat_id)并且在select时使用distinct
