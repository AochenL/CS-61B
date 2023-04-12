package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;


/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        //ArrayRingBuffer arb = new ArrayRingBuffer(10);
    }

    @Test
    public void testDequeue() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer> (3);
        arb.enqueue(1);
        arb.enqueue(2);
        assertTrue(arb.dequeue() == 1);
        // System.out.println(arb.dequeue());
        arb.enqueue(3);
        assertFalse(arb.dequeue() == 3);
        // System.out.println(arb.dequeue());
    }

   

    @Test
    public void testDequeue100() {
        ArrayRingBuffer<Double> buffer = new ArrayRingBuffer<> (100);
        int capacity = buffer.capacity();
        for (int i = 0 ; i < capacity; i++) {
            buffer.enqueue((double) 0);
        } 
        
    }

    @Test
    public void testPeek() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer> (3);
        arb.enqueue(1);
        arb.enqueue(2);
        assertTrue(arb.peek() == 1);
        arb.enqueue(3);
        assertFalse(arb.peek() == 3);
    }

    @Test
    public void testIterator() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer> (3);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);

        Iterator<Integer> seer = arb.iterator();
        while(seer.hasNext()) {
            System.out.println(seer.next());
        }

    }

    @Test
    public void testEnhancedForLoop() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer> (3);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);

        for (int i : arb) {
            System.out.println(i);
        }

    }


    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
