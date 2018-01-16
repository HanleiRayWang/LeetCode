/*

Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.

*/


class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int index=0;
        for(int i=0;i<abbr.length();i++){
            char c = abbr.charAt(i);
            if(Character.isDigit(c)){
                int count =0;
                while(i<abbr.length() && Character.isDigit(abbr.charAt(i))){
                    count=count*10+abbr.charAt(i)-'0';
                    if(count==0)
                        return false;
                    i++;
                }
                index+=count;
                i--;//为了平衡for循环里面那个i++
            }
            else if(index>=word.length() || c!=word.charAt(index))
                return false;
            else 
                index++;
        }
        return index==word.length();
    }
}
