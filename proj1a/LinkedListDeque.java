public class LinkedListDeque<T> {

    //node class
    private class ListNode {
        private T item;
        private ListNode prev;
        private ListNode next;
        public ListNode(T i, ListNode p, ListNode n) {
            item = i;
            prev = p;
            next = n;
        }
        public ListNode(T i) {
            item = i;
        }
    }

    //parameters
    private int size;
    private ListNode sentinel;

    //Constructor
    public LinkedListDeque() {
        sentinel = new ListNode(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    //Methods
    public void addFirst(T item) {
        ListNode first = new ListNode(item);
        first.next = sentinel.next;
        first.prev = sentinel;
        first.next.prev = first;
        sentinel.next = first;
        size = size + 1;
    }

    public void addLast(T item) {
        ListNode last = new ListNode(item);
        last.next = sentinel;
        last.prev = sentinel.prev;
        sentinel.prev = last;
        last.prev.next = last;
        size = size + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ListNode show = sentinel.next;
        while (show != sentinel) {
            System.out.print(show.item + " ");
            show = show.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        ListNode result = sentinel.next;
        result.next.prev = sentinel;
        sentinel.next = result.next;
        size = size - 1;
        return result.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        ListNode result = sentinel.prev;
        result.prev.next = sentinel;
        sentinel.prev = result.prev;
        size = size - 1;
        return result.item;
    }

    public T get(int index) {
        if (index < 0 || index >=size) {
            return null;
        }
        ListNode result = sentinel;
        for (int i = 0; i < index + 1; i = i + 1) {
            result = result.next;
        }
        return result.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ListNode result = getRecursivehelper(sentinel, index);
        return result.item;
    }

    private ListNode getRecursivehelper(ListNode current, int index) {
        ListNode result =current;
        if (index == 0) {
            result = current.next;
        } else {
            result = getRecursivehelper(current.next, index - 1);
        }
        return result;
    }
}
