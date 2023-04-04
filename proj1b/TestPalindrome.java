import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    Uncomment this class once you've created your Palindrome class. */
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        /** For example “a”, “racecar”, and “noon” are all palindromes.
         * “horse”, “rancor”, and “aaaaab” are not palindromes.
         * Any word of length 1 or 0 is a palindrome.*/
        OffByOne obo = new OffByOne();

        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("rancor"));
        assertFalse(palindrome.isPalindrome("aaaaab"));

        assertTrue(palindrome.isPalindrome("flake", obo));

    }
}
