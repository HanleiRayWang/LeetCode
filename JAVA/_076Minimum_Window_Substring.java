/*

Given a string S and a string T, 
find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, 
return the empty string "".

If there are multiple such windows, 
you are guaranteed that there will always be only one unique minimum window in S.

*/


public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0)
            return "";

        //根据t构建一个map，map就相当于是t字符串
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : t.toCharArray()){
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }
        
        
        int left = 0;
        //要把minLen设成一个比s.length()大的数值
        //substring(minLeft, minLeft+minLen)就是最终的结果
        int minLeft = 0, minLen=s.length()+1;
        //count就是为了看当前的substring(left, right)是不是包含了全部的t中的字符
        int count = 0;
        
        //根据substring的右边界字符对 String s 做iterate
        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
            
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) >= 0)
                    count ++;
                
                //count==t.length()就说明substring(left, right)包含了全部的t中的字符
                while(count == t.length()){
                    //right-left+1就是当前字符串的长度
                    if(right-left+1 < minLen){//更新子串
                        minLeft = left;
                        minLen = right-left+1;
                    }
                    
                    //下面这个判断必须存在，因为iterate是根据右边界字符做的
                    //不能保证while_loop中left字符一定在t中
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left),map.get(s.charAt(left))+1);
                        if(map.get(s.charAt(left)) > 0){
                            count --;
                        }
                    }
                    left ++ ;
                }
            }
        }
        
        
        
        if(minLen>s.length())  
            return "";  

        return s.substring(minLeft,minLeft+minLen);
    }
}
