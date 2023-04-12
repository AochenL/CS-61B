package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    // private int first;            // index for the next dequeue or peek
    public int first;
    /* Index for the next enqueue. */
    //private int last;
    public int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
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
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (!super.isFull()) {
            rb[last] = x;
            last = update(last);
            fillCount += 1; 
        }else {
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
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update 
        if (!super.isEmpty()) {
            T firstItem = rb[first];
            first = update(first);
            fillCount -= 1;
            return firstItem;
        }else {
            throw new RuntimeException("Ring buffer underflow");
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
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
            curNum ++;
            return returnItem;
       }
    }
    

    /**
     * Update first or last
     */
    public int update (int x) {
        x += 1;
        if (x == capacity) {
            x = 0;
        }
        return x;
    }


    
}
