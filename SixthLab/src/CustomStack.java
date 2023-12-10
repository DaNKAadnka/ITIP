public class CustomStack<T> {

    private T[] data;
    private int size;

    public CustomStack (int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push (T element) {
        data[size] = element;
        size++;
    }

    public T pop () {
        return data[--size];
    }

    public T peek () {
        return data[size-1];
    }
}
