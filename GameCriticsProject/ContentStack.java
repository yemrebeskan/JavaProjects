import java.util.EmptyStackException;

public class ContentStack<T> {			//This class is the class that defines our abstract stack type in which we will take the data from our csv file 
	private T[] stack;					//and put the games or movies to give as assignments to the critics.
	private int topIndex;
	private boolean initialized = false;				//-->Instance variables.
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public ContentStack() {				//Default constructor method(creates the stack with default capacity)
		this(DEFAULT_CAPACITY);
	}
	public ContentStack(int initialCapacity) {				//Constructor method that creates the stack with wanted capacity and changes the instance
		T[] tempStack = (T[])new Object[initialCapacity];	//variables values.
		stack = tempStack;
		topIndex = -1;
		initialized = true;
	}
	public void push(T newEntry) {					//This method used to add new data into the stack.
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}
	public T peek() {								//This method returns the data at the top of the stack (i.e. the most recently added)
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stack[topIndex];
	}
	public T pop() {								//This method used to take tha data at the top of the stack and remove it from the stack.
		if(isEmpty()){								//Additionally, it returns the data taken from the stack.
			throw new EmptyStackException();
		}
		else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	}
	public boolean isEmpty() {						//This boolean method used to check if the stack is empty or not.
		return topIndex == -1;
	}
	public int size() {							//This method returns the number of elements in the stack.
		return topIndex + 1;
	}
}
