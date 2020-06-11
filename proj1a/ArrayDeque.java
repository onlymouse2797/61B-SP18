public class ArrayDeque<T> {

    //parameters
    private T[] items;
    private int size;
    private int arraySize;
    private int nextFirst;
    private int nextLast;

    //rotating function
    private int increase(int point) {
        if (point < arraySize - 1) {
            point = point + 1;
        } else if (point == arraySize - 1) {
            point = 0;
        }
        return point;
    }

    private int decrease(int point) {
        if (point > 0) {
            point = point - 1;
        } else if (point == 0) {
            point = arraySize - 1;
        }
        return point;
    }

    //constructor
    public ArrayDeque() {
        items = (T []) new Object[8];
        nextFirst = 1;
        nextLast = 2;
        size = 0;
        arraySize = 8;
    }

    //methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        if (size == 0) {
            System.out.print("Empty arraylist");
        } else {
            int current = increase(nextFirst);
            for (int i = 0; i < size; i = i + 1) {
                System.out.print(items[current] + " ");
                current = increase(current);
            }
        }
        System.out.println();
    }

    public void addFirst(T item) {
        if (size == arraySize) {
            resizeUp();
        }
        items[nextFirst] = item;
        size = size + 1;
        nextFirst = decrease(nextFirst);
    }

    public void addLast(T item) {
        if (size == arraySize) {
            resizeUp();
        }
        items[nextLast] = item;
        size = size + 1;
        nextLast = increase(nextLast);
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            if (size > 16 && 4 * size <= arraySize) {
                resizeDown();
            }
            int current = nextFirst;
            current = increase(current);
            T result = items[current];
            items[current] = null;
            nextFirst = increase(nextFirst);
            size = size - 1;
            return result;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            if (size > 8 && 4 * size <= arraySize) {
                resizeDown();
            }
            int current = nextLast;
            current = decrease(current);
            T result = items[current];
            items[current] = null;
            nextLast = decrease(nextLast);
            size = size - 1;
            return result;
        }
    }

    public T get(int index) {
        int current = nextFirst;
        for (int i = 0; i <= index; i = i + 1) {
            current = increase(current);
        }
        T result = items[current];
        return result;
    }

    private void resizeUp() {
        T[] newItems = (T []) new Object[arraySize * 2];
        int current = increase(nextFirst);
        for (int i = 0; i < size; i = i + 1) {
            newItems[i] = items[current];
            items[current] = null;
            current = increase(current);
        }
        items = newItems;
        arraySize = arraySize * 2;
        nextFirst = arraySize - 1;
        nextLast = size;
    }
    private void resizeDown() {
        T[] newItems = (T []) new Object[arraySize / 2];
        int current = increase(nextFirst);
        for (int i = 0; i < size; i = i + 1) {
            newItems[i] = items[current];
            items[current] = null;
            current = increase(current);
        }
        items = newItems;
        arraySize = arraySize / 2;
        nextFirst = arraySize - 1;
        nextLast = size;
    }
}
