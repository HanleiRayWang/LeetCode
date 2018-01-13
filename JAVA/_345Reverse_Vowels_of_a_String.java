/*

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".

*/

class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<Character>();
        set.add('a');set.add('A');
        set.add('i');set.add('I');
        set.add('o');set.add('O');
        set.add('e');set.add('E');
        set.add('u');set.add('U');
        
        char[] alpha = s.toCharArray();
        int left=0, right=alpha.length-1;
        while(left<right){
            while(!set.contains(alpha[left]) && left<right)
                left++;
            while(!set.contains(alpha[right]) && left<right) 
                right--;
            char temp = alpha[right];
            alpha[right]=alpha[left];
            alpha[left]=temp;
            left++;
            right--;
            
        }
        return String.valueOf(alpha);
    }
}
