/*


Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.


*/


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 




//正常的解法, 使用PriorityQueue/Min_Heap
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.end - b.end; }
        });

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after 
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // don't forget to put the meeting room back
            heap.offer(interval);
        }

        return heap.size();
    }
}







 /*
 
 we acknowledge three facts:
1.  The numbers of the intervals give chronological orders
2.  When an ending event occurs, there must be a starting event has happened before that, 
    where “happen before” is defined by the chronological orders given by the intervals
3.  Meetings that started which haven’t ended yet have to be put into different meeting rooms, 
    and the number of rooms needed is the number of such meetings
    
for example, we have meetings that span along time as follows:

|_____|
      |______|
|________|
        |_______|
Then, the start time array and end time array after sorting appear like follows:

||    ||
     |   |   |  |
     
Initially, endsItr points to the first end event, and we move i which is the start event pointer. 
As we examine the start events, we’ll find the first two start events happen before the end event that endsItr points to, 
so we need two rooms (we magically created two rooms), as shown by the variable rooms. 
Then, as i points to the third start event, we’ll find that this event happens after the end event pointed by endsItr, 
then we increment endsItr so that it points to the next end event. 
What happens here can be thought of as one of the two previous meetings ended, 
and we moved the newly started meeting into that vacant room, thus we don’t need to increment rooms at this time 
and move both of the pointers forward.
Next, because endsItr moves to the next end event, we’ll find that the start event pointed 
by i happens before the end event pointed by endsItr. 
Thus, now we have 4 meetings started but only one ended, so we need one more room. And it goes on as this.
 
 */


//fancy的解法
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for(int i=0; i<len; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int room=0;
        int endItr=0;
        for(int i=0;i<len;i++){
            if(starts[i]<ends[endItr])
                room++;
            else
                endItr++;
        }
        return room;
    }
}
