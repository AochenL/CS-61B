public class LinkedListDeque<T> {
    public class TNode {
        public T item;
        public TNode prev;
        public TNode next;
        public TNode(TNode p, T i, TNode n) {
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

    public LinkedListDeque(T x) {
        sentinel = new TNode(sentinel, x, sentinel);
        sentinel.next = new TNode(sentinel, x, sentinel);
        size = 1;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item){
        sentinel.next = new TNode(sentinel, item, sentinel.next);
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item){
        TNode tn = new TNode(sentinel.prev, item, sentinel.next);
        sentinel.prev = tn;
        size += 1;
    }
    
    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size(){
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque(){
        TNode p = sentinel;
        while (p.next != sentinel){
            //System.out.print(p.next.item, " ");
            p = p.next;
        }
    }

    /**  Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst(){
        if (sentinel.next == sentinel){
            return null;
        }
        size -= 1;
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return item;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast(){
        if (sentinel.next == sentinel){
            return null;
        }
        size -= 1;
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return item;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque! */
    public T get(int index){
        if (index > size - 1){
            return null;
        }
        TNode p = sentinel;
        while (index != 0){
            p = p.next;
            index -= 1;
        }
        return p.next.item;
    }

    /** Same as get, but uses recursion */
    public T getRecursive(int index){
        if (index > size - 1){
            return null;
        }
        return getRecursiveHelper(sentinel, index);
    }

    public T getRecursiveHelper(TNode p, int index){
        if (index == 0){
            return p.next.item;
        }
        return getRecursiveHelper(p.next, index - 1); 
    }



}