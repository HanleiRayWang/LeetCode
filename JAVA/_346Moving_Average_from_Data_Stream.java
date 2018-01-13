/*

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

*/

class MovingAverage {
    
    int size;
    Queue<Integer> queue;
    double average;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size=size;
        queue = new LinkedList<Integer>();
        average=0.0;
    }
    
    public double next(int val) {
        if(queue.size()<size){
            average = (average*queue.size()+val)/(queue.size()+1);
            queue.offer(val);
        }else{
            average = (average*size-queue.poll()+val)/size;
            queue.offer(val);
        }
        return average;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
