/*

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

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
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        if(intervals.size()<2)
            return intervals;
        
        
        //sort ArrayList 的时候用的Collections，不是Arrays
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });
        
        //不能简单的取出第一个Interval作为基准，需要精确到每次的start和end
        //因为会出现以下情况等
        //[[1,4],[1,4]]
        //[[1,4],[2,3]]
        //[[0,4],[1,4]]
        //[[1,4],[2,5]]

        int start = intervals.get(0).start;
        int end   = intervals.get(0).end;
        
        List<Interval> result = new ArrayList<Interval>();
        
        for (Interval interval : intervals) {
            if(interval.start<=end)
                end = Math.max(end, interval.end);
            else{
                result.add(new Interval(start, end));
                start = interval.start;
                end   = interval.end;
            }
        }
        //加入最后一个Interval
        result.add(new Interval(start, end));
        return result;
    }

}
