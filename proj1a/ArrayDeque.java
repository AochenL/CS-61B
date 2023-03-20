public class ArrayDeque<T> {
    /** array to save data.*/
    private T[] array;
    /** size of the deque. */
    private int size;

    /** size of the array. */
    private int length;

    /** front index. */
    private int front;

    /** last index. */
    private int last;

    /** constructor for ArrayDeque. */
    public ArrayDeque() {
        array = (T []) new Object[8];
        size = 0;
        length = 8;
        front = 4;
        last = 5;
    }

    /** Get the empty cube before the front item of the circular deque*/
    private int minusOne(int index) {
        if (index > 0) {
            return index - 1;
        }
        return length - 1;
    }

    /**  Get the empty cube after the last item of the circular deque*/
    private int plusOne(int index, int len) {
        if (index < len - 1) {
            return index + 1;
        }
        return 0;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T x) {
        if (size == length - 1) {
           resize();
        }
        array[front] = x;
        front = minusOne(front);
        size += 1;
    
    }

    /** Resize the deque (double the length) */
    private void resize() {
        T[] new_array = (T []) new Object[length * 2];
        /** copy the items from front to last */
        int p1 = front;
        int p2 = front;
        int cnt = 0;
        /** p1 is the front of array */
        /** p2 is the front of new_array*/ 
        while (cnt <= size) {
            new_array[p2] = array[p1];
            p1 = plusOne(p1, length);
            p2 = plusOne(p2, length * 2);
            //print_array(new_array);
            cnt++;
        }
        /** after copy is finished, p2 is the last of the new_array */
        array = new_array;
        length = length * 2;
        last = p2;
        //System.out.println(p2);
    }
     
    /** Adds an item of type T to the back of the deque. */
    public void addLast(T x) {
        if (size == length - 1) {
            resize();
         }
        array[last] = x;
        last = plusOne(last, length);
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, 
     * separated by a space. */
    public void printDeque() {
        int j = 0;
        while (j < length) {
            System.out.print(array[j]);
            System.out.print(" ");
            j++;
        }
        System.out.println(" ");
    }

    /** Removes and returns the item at the front of the deque. 
     * If no such item exists, returns null.*/
    public T removeFirst() {
        if (isEmpty() == true) { 
            return null; 
        } 
        size--;
        front = plusOne(front, length);
        T front_item = array[front];
        array[front] = null;
        if (size * 1.0 / length  <= 0.25) {
            shrink();
        }
        return front_item;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null. */
    public T removeLast() {
        if (isEmpty() == true) { 
            return null; 
        } 
        size--;
        last = minusOne(last);
        T last_item = array[last];
        array[last] = null;
        if (size * 1.0 / length <= 0.25) {
            shrink();
        }
        return last_item;
    }

    /** Gets the item at the given index, where 0 is the front, 
     * 1 is the next item, and so forth. 
     * If no such item exists, returns null. 
     * Must not alter the deque! */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int p = front;
        int cnt = 0;
        p = plusOne(p, length);
        while (cnt < index) {
            p = plusOne(p, length);
            cnt++;
        }
        return array[p];
    }

    /** Resizes down after removals */
    private void shrink() {
        if (length <= 8) {
            return;
        }
        int p = 0;
        T[] new_array = (T []) new Object[length / 2]; 
        while (p < size) {
            front = plusOne(front, length);
            new_array[p] = array[front];        
            p++;
        }
        length = length / 2;
        last = size;
        front = length - 1;
        array = new_array;
    }
}
