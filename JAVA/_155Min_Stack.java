/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

*/

class MinStack {

    int min;
    Stack<Integer> stack;
    
    //题目只是要求能够O(1)得到最小值，并没有要求所有stack中的元素sorted，还是FILO的顺序
    //因此只需要设一个int min作为记录即可
    
    
    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        //如果x<=min,就先把min放进stack，更新min，之后再把x放进stack，等到pop的时候就需要pop两次
        if(x<=min){
            stack.push(min);
            min=x;
        }
        //无论如何都是要把x放进stack里面的
        stack.push(x);
    }
    
    public void pop() {
        //如果pop出来的数字就是最小值，说明需要再pop一次，因为push的时候就push了两次
        int temp = stack.pop();
        if(temp==min)
            min=stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
