package ShuntingYard;

import java.util.Queue;

/**
 * Created by ekaterina on 05.02.17.
 */
public class LinkedQueue<E> {
    private LinkedList<E> list = new LinkedList<E>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(E element) {
        list.addLast(element);
    }

    public E first() {
        return list.first();
    }

    public E dequeue() {
        return list.removeFirst();
    }
}
