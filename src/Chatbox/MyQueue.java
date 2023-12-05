package Chatbox;

public class MyQueue<T> {
    private Object[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyQueue() {
        capacity = 20;
        queue = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.capacity = capacity;
        queue = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean offer(T item) {
        if (size == capacity) {
            return false;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T item = (T) queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) queue[front];
    }

    public int size() {
        return size;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        for (int i = 0; i < capacity; i++) {
            queue[i] = null;
        }
    }
}