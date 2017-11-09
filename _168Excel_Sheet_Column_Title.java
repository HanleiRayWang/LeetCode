/*

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    
*/

class Solution {
    public String convertToTitle(int n) {
        char[] dic = 
            new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        StringBuilder sb = new StringBuilder();

        while(n>0){
            //每次都要n--
            //因为如n是26的倍数，那么一取余数就成0了得不到正确结果
            //n--就可以保证    26-1=25-->映射至Z
            n--;
            sb.append(dic[n%26]);
            n=n/26;
        }

        //注意要反转一下
        return sb.reverse().toString();
    }
}
