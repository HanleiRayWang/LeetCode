
/*

Given two binary strings, return their sum (also a binary string).
For example,
a = "11"
b = "1"
Return "100"
*/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i=a.length()-1, j=b.length()-1, carry=0;
        while(i>=0 || j>=0){
            int sum=0;
            
            //一定不要忘记i--和j--这种对i/j的操作
            if(i>=0) sum+=a.charAt(i--)-'0';
            if(j>=0) sum+=b.charAt(j--)-'0';
            sum+=carry;
            sb.append(sum%2);
            carry=sum/2;
        }
        
        if(carry!=0) sb.append('1');
        
        //最后reverse一下
        return sb.reverse().toString();
    }
}
