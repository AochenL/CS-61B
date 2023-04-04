/** Palindrome.java: A class for palindrome operations.
 OffByOne.java: A class for off-by-1 comparators.
 OffByN.java: A class for off-by-N comparators. */

public class Palindrome {
    /** covert a word to deque */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> dQ = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            dQ.addLast(ch);
        }
        return dQ;
    }

    /** Return true if the word is a palindrome */
    public boolean isPalindrome(String word) {
        Deque dQ = wordToDeque(word);
        return isPalindromeHelper(dQ);
    }

    private boolean isPalindromeHelper(Deque dQ) {
        if (dQ.size() <= 1) {
            return true;
        }
        if (dQ.removeFirst() == dQ.removeLast()) {
            return isPalindromeHelper(dQ);
        } else {
            return false;
        }
    }

    /** Returns true if the word is a palindrome
     *  according to the character comparison test
     *  provided by the CharacterComparator */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque dQ = wordToDeque(word);
        return isPalindromeHelper(dQ, cc);
    }

    private boolean isPalindromeHelper(Deque dQ, CharacterComparator cc) {
        if (dQ.size() <= 1) {
            return true;
        }
        if (cc.equalChars((char) dQ.removeFirst(), (char) dQ.removeLast())) {
            return isPalindromeHelper(dQ, cc);
        } else {
            return false;
        }
    }

}
