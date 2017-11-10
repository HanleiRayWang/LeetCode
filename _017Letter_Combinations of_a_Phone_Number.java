/*

Given a digit string, return all possible letter combinations that the number could represent.
The Digit-to-Letter map is same as regular phone.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

*/

class Solution {
    public List<String> letterCombinations(String digits) {
        
        String[] dic = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> result = new LinkedList<String>();
        if(digits.length()==0)
            return new ArrayList(result);
        //这一步很关键，在result中加入""，从而可以开始计算
        result.add("");
        for(int i=0;i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(result.peek().length()==i){
                String t = result.poll();
                for(char s : dic[x].toCharArray())
                    result.add(t+s);
            }
        }
        return new ArrayList(result);
    }
}
