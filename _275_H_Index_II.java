/*

Based on 274.H-Index.java
What if the citations array is sorted in ascending order? Could you optimize your algorithm?

*/



//The basic idea of this solution is to use binary search to find the minimum index such that
//citations[index] >= length(citations) - index

class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int med = lo + (hi - lo) / 2;
            if (citations[med] == len - med) {
                return len - med;
            } else if (citations[med] < len - med) {
                lo = med + 1;
            } else { 
                //(citations[med] > len-med), med qualified as a hIndex,
                // but we have to continue to search for a higher one.
                hi = med - 1;
            }
        }
        return len - lo;
    }
}
