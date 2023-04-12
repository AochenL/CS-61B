package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek

    /* Index for the next enqueue. */
    private int last;

    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (!super.isFull()) {
            rb[last] = x;
            last = (last + 1) % capacity;
            fillCount += 1; 
        } else {
            throw new RuntimeException("Ring buffer overflow");
        }
        
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (!super.isEmpty()) {
            T firstItem = rb[first];
            first = (first + 1) % capacity;
            fillCount -= 1;
            return firstItem;
        } else {
            throw new RuntimeException("Ring buffer underflow");
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (!super.isEmpty()) {
            return rb[first];
        } else {
            throw new RuntimeException("no item in the buffer");
        }
    }

    public Iterator<T> iterator() {
        return new BufferIterator();
    }

    private class BufferIterator implements Iterator<T> {
        private int position;
        private int curNum;

        public BufferIterator() {
            position = first;
            curNum = 0;
        }

        public boolean hasNext() {
            return curNum < capacity;
        }

        public T next() {
            T returnItem = rb[position];
            position = (position + 1) % capacity;
            curNum++;
            return returnItem;
        }
    }
    
    
}
