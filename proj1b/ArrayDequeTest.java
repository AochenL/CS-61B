/** Performs some basic linked list tests. */
public class ArrayDequeTest {
	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		ArrayDeque<Integer> a = new ArrayDeque<Integer> ();
        int i = 0;
        while (i < 20) {
            a.addLast(i);
            a.printDeque();
            i++;
        }

        System.out.println(a.size());
    
	}
} 
