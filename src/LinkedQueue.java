/**
 * @author ekaterina
 */
public class LinkedQueue<E> {
    private LinkedList<E> list = new LinkedList<E>();

    /**
     * @return size of linked queue
     */
    public int size() {
        return list.size();
    }

    /**
     * @return true if queue is empty
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adds new element to the tail of the queue
     *
     * @param element that we want to add
     */
    public void enqueue(E element) {
        list.addLast(element);
    }

    /**
     * @return first element of the queue
     */
    public E first() {
        return list.first();
    }

    /**
     * Delete and returns first element of the queue
     *
     * @return first element of the queue
     */
    public E dequeue() {
        return list.removeFirst();
    }
}
