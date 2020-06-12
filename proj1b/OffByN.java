public class OffByN implements CharacterComparator {
    private int diff;

    //constructor
    OffByN(int N) {
        diff = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == diff;
    }
}
