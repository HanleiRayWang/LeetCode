/*

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.

*/

class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count=0;
        StringBuilder sb = new StringBuilder();
        while(sb.length()<B.length()){
            sb.append(A);
            count++;
        }
        //先保证sb的长度大于B
        
        if(sb.indexOf(B)>=0)
            return count;
        //如果sb中没有，那么唯一的可能就是B恰好是sb的最末端+最前端，这样只需要检查sb.append(A)即可
        if(sb.append(A).indexOf(B)>=0)
            return count+1;
        return -1;
    }
}
