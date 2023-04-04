/** Palindrome.java: A class for palindrome operations.
 OffByOne.java: A class for off-by-1 comparators.
 OffByN.java: A class for off-by-N comparators. */

public class Palindrome {
    /** covert a word to deque */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> Dq= new ArrayDeque<>();
        for (int i = 0 ; i < word.length(); i++) {
            Character ch = word.charAt(i);
            Dq.addLast(ch);
        }
        return Dq;
    }

    /** Return true if the word is a palindrome */
    public boolean isPalindrome(String word) {
        Deque Dq = wordToDeque(word);
        return isPalindromeHelper(Dq);
    }

    public boolean isPalindromeHelper(Deque Dq) {
        if (Dq.size() <= 1) {
            return true;
        }
        if (Dq.removeFirst() == Dq.removeLast()) {
            return isPalindromeHelper(Dq);
        }else {
            return false;
        }
    }

    /** Returns true if the word is a palindrome
     *  according to the character comparison test
     *  provided by the CharacterComparator */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque Dq = wordToDeque(word);
        return isPalindromeHelper(Dq, cc);
    }

    public boolean isPalindromeHelper(Deque Dq, CharacterComparator cc) {
        if (Dq.size() <= 1) {
            return true;
        }
        if (cc.equalChars((char) Dq.removeFirst(), (char) Dq.removeLast())) {
            return isPalindromeHelper(Dq, cc);
        }else {
            return false;
        }
    }


}