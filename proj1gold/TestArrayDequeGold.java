import static org.junit.Assert.*;

import java.util.ArrayDeque;

import org.junit.Test;

/**  Test and find an error using only 
 * the addFirst, addLast, removeFirst, and removeLast methods, */
//@source StudentArrayDequeLauncher.java
public class TestArrayDequeGold {
    @Test
    public void testAddRemove() {
        Integer testRound = 8;
        String operations = "";
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

        for (int i = 0; i < testRound; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad.addLast(i);
                ads.addLast(i);
                operations += "addLast(" + i + ")\n";
        
            } else {
                sad.addFirst(i);
                ads.addFirst(i);
                operations += "addFirst(" + i + ")\n";
            }
            
        }

        for (int i = 0; i < testRound; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                if (sad.size() > 0 && ads.size() > 0) {
                    Integer expected = sad.removeLast();
                    Integer actual = ads.removeLast();
                    operations += "removeLast(" + i + ")\n";
                    assertEquals("Oh noooo!\nThis is bad:\nAfter " + operations, 
                     expected, actual);
                }
            } else {
                if (sad.size() > 0 && ads.size() > 0) {
                    Integer expected = sad.removeFirst();
                    Integer actual = ads.removeFirst();
                    operations += "removeFirst(" + i + ")\n";
                    assertEquals("Oh noooo!\nThis is bad:\n   The deque should return " + expected
                    + " but student deque returns " + actual + "!", 
                    expected, actual);
                }
               
            }
            
        }

    }
} 
