/*
 * There're 3 possibilities to satisfy one edit distance apart: 
 * 
 * 1) Replace 1 char:
 	  s: a B c
 	  t: a D c
 * 2) Delete 1 char from s: 
	  s: a D  b c
	  t: a    b c
 * 3) Delete 1 char from t
	  s: a   b c
	  t: a D b c
 */
 
 
 class Solution {
    public boolean isOneEditDistance(String s, String t) {

        int sLen = s.length(), tLen = t.length();
        for(int i=0;i<Math.min(sLen, tLen);i++){
            if(s.charAt(i)!=t.charAt(i)){
            
                // replace
                if(sLen==tLen)
                    return s.substring(i+1).equals(t.substring(i+1));
                // delete from t
                else if(sLen<tLen)
                    return s.substring(i).equals(t.substring(i+1));
                // delete from s
                else
                    return s.substring(i+1).equals(t.substring(i));
            }
        }
        return Math.abs(sLen-tLen)==1;
        
    }
}
