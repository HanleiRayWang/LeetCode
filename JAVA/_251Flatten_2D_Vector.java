/*

Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

*/


public class Vector2D implements Iterator<Integer> {
    
    List<List<Integer>> vec2d;
    int index;
    Queue<Integer> queue;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        index=0;
        queue = new LinkedList<Integer>();
    }

    @Override
    public Integer next() {
        if(!queue.isEmpty())
            return queue.poll();
        List<Integer> list = vec2d.get(index++);
        while(list.size()==0 && index<vec2d.size())
            list=vec2d.get(index++);
        for(int i=0;i<list.size();i++)
            queue.offer(list.get(i));
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
    
        //注意为了要处理vec2d中某一个list是空的情况，需要加入这个while
        while(index<vec2d.size() && vec2d.get(index).size()==0)
            index++;
        if(queue.size()==0 && index==vec2d.size())
            return false;
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
