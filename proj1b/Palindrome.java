public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> newList = new LinkedListDeque<> ();
        for (int i = 0; i < word.length(); i++) {
            char tem = word.charAt(i);
            newList.addLast(tem);
        }
        return newList;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> input = wordToDeque(word);
        return isPalindromeHelper(input);
    }

    private boolean isPalindromeHelper(Deque<Character> word) {
        if (word.size() < 2) {
            return true;
        }
        char first = word.removeFirst();
        char last = word.removeLast();
        return (first == last && isPalindromeHelper(word));
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> input = wordToDeque(word);
        return isPalindromeHelper(input, cc);
    }

    private boolean isPalindromeHelper(Deque<Character> word, CharacterComparator cc) {
        if (word.size() < 2) {
            return true;
        }
        char first = word.removeFirst();
        char last = word.removeLast();
        return (cc.equalChars(first, last) && isPalindromeHelper(word, cc));
    }
}
