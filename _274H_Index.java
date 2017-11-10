/*

Given an array of citations (each citation is a non-negative integer) of a researcher, 
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: 
"A scientist has index h if h of his/her N papers have at least h citations each, 
and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], 
which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. 
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, 
his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.


The idea behind it is some bucket sort mechanisms. 
First, you may ask why bucket sort. 
Well, the h-index is defined as the number of papers with reference greater than the number. 
So assume n is the total number of papers, if we have n+1 buckets, number from 0 to n, 
then for any paper with reference corresponding to the index of the bucket, 
we increment the count for that bucket. 
The only exception is that for any paper with larger number of reference than n, we put in the n-th bucket.

Then we iterate from the back to the front of the buckets, 
whenever the total count exceeds the index of the bucket, 
meaning that we have the index number of papers that have reference greater than or equal to the index. 
Which will be our h-index result. 
The reason to scan from the end of the array is that we are looking for the greatest h-index. 
For example, given array [3,0,6,5,1], we have 6 buckets to contain how many papers have the corresponding index. 
Buckets [1,1,0,1,0, 2]
         0,1,2,3,4,>=5

*/

//bucket sorting
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        //根据题设，最终结果只可能在0~len之间，因此可以bucket sort
        int[] buckets = new int[len+1];
        for(int c : citations){
            if(c>=len)
                buckets[len]++;
            else
                buckets[c]++;
        }
        int count=0;
        for(int i=len;i>=0;i--){
            count+=buckets[i];
            if(count>=i)
                return i;
        }
        return 0;
    }
}
