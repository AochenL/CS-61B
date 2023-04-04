public class ArrayDeque<Item> implements Deque<Item>{
    /** array to save data.*/
    private Item[] array;
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
        array = (Item []) new Object[8];
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

    /** Adds an item of type Item to the front of the deque. */
    @Override
    public void addFirst(Item x) {
        if (size == length - 1) {
            resize();
        }
        array[front] = x;
        front = minusOne(front);
        size += 1;
    
    }

    /** Resize the deque (double the length) */
    private void resize() {
        Item[] newArray = (Item []) new Object[length * 2];
        /** copy the items from front to last */
        int p1 = front;
        int p2 = front;
        int cnt = 0;
        /** p1 is the front of array */
        /** p2 is the front of newArray*/ 
        while (cnt <= size) {
            newArray[p2] = array[p1];
            p1 = plusOne(p1, length);
            p2 = plusOne(p2, length * 2);
            //print_array(newArray);
            cnt++;
        }
        /** after copy is finished, p2 is the last of the newArray */
        array = newArray;
        length = length * 2;
        last = p2;
        //System.out.println(p2);
    }
     
    /** Adds an item of type T to the back of the deque. */
    @Override
    public void addLast(Item x) {
        if (size == length - 1) {
            resize();
        }
        array[last] = x;
        last = plusOne(last, length);
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }

    /** Prints the items in the deque from first to last, 
     * separated by a space. */
    @Override
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
    @Override
    public Item removeFirst() {
        if (isEmpty()) { 
            return null; 
        } 
        size--;
        front = plusOne(front, length);
        Item frontItem = array[front];
        array[front] = null;
        if (size * 1.0 / length  <= 0.25) {
            shrink();
        }
        return frontItem;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null. */
    @Override
    public Item removeLast() {
        if (isEmpty()) { 
            return null; 
        }
        size--;
        last = minusOne(last);
        Item lastItem = array[last];
        array[last] = null;
        if (size * 1.0 / length <= 0.25) {
            shrink();
        }
        return lastItem;
    }

    /** Gets the item at the given index, where 0 is the front, 
     * 1 is the next item, and so forth. 
     * If no such item exists, returns null. 
     * Must not alter the deque! */
    @Override
    public Item get(int index) {
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
        Item[] newArray = (Item []) new Object[length / 2];
        while (p < size) {
            front = plusOne(front, length);
            newArray[p] = array[front];        
            p++;
        }
        length = length / 2;
        last = size;
        front = length - 1;
        array = newArray;
    }
}
