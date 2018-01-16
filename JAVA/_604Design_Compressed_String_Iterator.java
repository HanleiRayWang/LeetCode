/*

Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Note:
Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

Example:

StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '

*/







//正确但超时
class StringIterator {
    
    private Queue<Character> queue;

    public StringIterator(String compressedString) {
        queue = new LinkedList<Character>();
        int i=0;
        while(i<compressedString.length()){
            char c = compressedString.charAt(i);
            i++;
            StringBuilder sb = new StringBuilder();
            while(i<compressedString.length() && compressedString.charAt(i)<='9' && compressedString.charAt(i)>='0')
                sb.append(compressedString.charAt(i++));
                
            int count = Integer.parseInt(sb.toString());
            while(count-->0)
                queue.offer(c);
        }
    }
    
    public char next() {
        if(!queue.isEmpty())
            return queue.poll();
        return ' ';
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

//稍稍修改即可
 class StringIterator {
    
    
    class Pair{
        Character c;
        int count;
        Pair(char c, int count){
            this.c=c;
            this.count=count;
        }
    }
    
    
    private Queue<Pair> queue;

    public StringIterator(String compressedString) {
        queue = new LinkedList<Pair>();
        int i=0;
        while(i<compressedString.length()){
            char c = compressedString.charAt(i);
            i++;
            StringBuilder sb = new StringBuilder();
            while(i<compressedString.length() && Character.isDigit(compressedString.charAt(i)))
                sb.append(compressedString.charAt(i++));
                
            int count = Integer.parseInt(sb.toString());
            queue.offer(new Pair(c,count));
        }
    }
    
    public char next() {
        if(!queue.isEmpty()){
            Pair pair = queue.peek();
            pair.count--;
            if(pair.count==0)
                queue.poll();
            return pair.c;
        }
            
        return ' ';
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
