package Chatbox;
import java.util.EmptyStackException;

public class MyStack<T> {
    private Object[] stack;
    private int top;
    private int capacity;

    public MyStack() {
        capacity = 20;
        stack = new Object[capacity];
        top = -1;
    }

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.capacity = capacity;
        stack = new Object[capacity];
        top = -1;
    }

    public T push(T item) {
        if (top == capacity - 1) {
            return null;
        }
        top++;
        stack[top] = item;
        return item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = (T) stack[top];
        stack[top] = null;
        top--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void clear() {
        for (int i = 0; i <= top; i++) {
            stack[i] = null;
        }
        top = -1;
    }
}
