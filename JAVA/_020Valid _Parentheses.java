/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

*/


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if(c=='(' || c=='[' || c=='{')
                stack.push(c);
            else if(stack.isEmpty())
                return false;
            else if(c==')'){
                if(stack.pop()!='(')
                    return false;
            }else if(c==']'){
                if(stack.pop()!='[')
                    return false;
            }else if(c=='}'){
                if(stack.pop()!='{')
                    return false;
            }   
        }
        return stack.isEmpty();
    }
}

//直接在stack里面存贮对应的后半边括号，更方便比较
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if(c=='(')
                stack.push(')');
            else if(c=='[')
                stack.push(']');
            else if(c=='{')
                stack.push('}');
            //方便比较
            else if(stack.isEmpty() || stack.pop()!=c)
                return false;
        }
        return stack.isEmpty();
    }
}
