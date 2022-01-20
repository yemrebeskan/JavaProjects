
public class CriticQueue<T>{    // This queue data abstract type is the data type that game and movie critics will wait and receive their tasks.

    private T[] queue;			
    private int frontIndex;		// Instance variables
    private int backIndex;
    
    private static final int DEFAULT_CAPACITY = 8;

    public CriticQueue() {
        this(DEFAULT_CAPACITY);				//Default constructor method(Creates the queue with the default capacity)
    }

    public CriticQueue(int defaultCapacity) {			//Constructor method that creates queue by the wanted or indicated length(size or capacity).
    	T[] tempQueue = (T[])new Object[defaultCapacity]; //Type casting(from object to generic type)...
    	queue = tempQueue;
    	frontIndex = 1;
    	backIndex = 0;
    }

    public void enqueue(T newEntry) {            //Method used to add new data to the queue
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

    public T getFront() {        //The method that returns the next data(which is in the front) in the queue.
        if (isEmpty()) {
            return null;
        } else {
            return queue[frontIndex];
        }
    }

    public T dequeue() {    //The method used to removing the first element from the queue
        if (isEmpty()) {
            return null;
        } else {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return front;
        }
    }

    public boolean isEmpty() {   //Boolean method to check if the queue is empty or not.
        return frontIndex == ((backIndex + 1) % queue.length);
    }

}