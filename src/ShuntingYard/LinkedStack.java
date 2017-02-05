package ShuntingYard;

/**
 * Created by ekaterina on 03.02.17.
 */
public class LinkedStack<E> {
    private LinkedList<E> list = new LinkedList<E>();

    public int size() {
        return list.size();
    }

    public void push(E element) {
        list.addFirst(element);
    }

    public E pop() {
        return list.removeFirst();
    }

    public E top() {
        if (isEmpty()) return null;
        return list.first();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
