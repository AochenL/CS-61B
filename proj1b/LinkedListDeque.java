public class LinkedListDeque<Item> implements Deque<Item> {
    private class TNode {
        private Item item;
        private TNode prev;
        private TNode next;
        private TNode(TNode p, Item i, TNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private TNode sentinel; 
    private int size;

    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Adds an item of type Item to the front of the deque. */
    @Override
    public void addFirst(Item item) {
        TNode tn = new TNode(sentinel, item, sentinel.next);
        sentinel.next.prev = tn;
        sentinel.next = tn;
        size += 1;
    }

    /** Adds an item of type Item to the back of the deque. */
    @Override
    public void addLast(Item item) {
        TNode tn = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = tn;
        sentinel.prev = tn;
        size += 1;
    }
    
    /** Returns true if deque is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque.*/
    @Override
    public int size() {
        return size;
    }


    /** Prints the items in the deque from first to last, separated by a space. */
    @Override
    public void printDeque() {
        TNode p = sentinel;
        while (p.next != sentinel) {
            //System.out.print(p.next.item, " ");
            p = p.next;
        }
    }

    /**  Removes and returns the item at the front of the deque. 
    If no such item exists, returns null. */
    @Override
    public Item removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        size -= 1;
        Item item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return item;
    }

    /** Removes and returns the item at the back of the deque. 
    If no such item exists, returns null. */
    @Override
    public Item removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        size -= 1;
        Item item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return item;
    }

    /** Gets the item at the given index, where 0 is the front, 
    1 is the next item, and so forth. If no such item exists, returns null. 
    Must not alter the deque! */
    @Override
    public Item get(int index) {
        if (index > size - 1) {
            return null;
        }
        TNode p = sentinel;
        while (index != 0) {
            p = p.next;
            index -= 1;
        }
        return p.next.item;
    }

    /** Same as get, but uses recursion */
    public Item getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }
        return getRecursiveHelper(sentinel, index);
    }

    private Item getRecursiveHelper(TNode p, int index) {
        if (index == 0) {
            return p.next.item;
        }
        return getRecursiveHelper(p.next, index - 1); 
    }
}
