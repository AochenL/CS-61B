public class OffByN implements CharacterComparator {
    private int N;
    /** constructor: creates an OffByN Object */
    public OffByN (int n) {
        N = n;
    };

    /** Returns true if characters are equal by the rules of the implementing class. */
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == N || diff == -N) {
            return true;
        }
        return false;
    }
}