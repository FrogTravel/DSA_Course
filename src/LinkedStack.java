/**
 * @author ekaterina
 */
public class LinkedStack<E> {
    private LinkedList<E> list = new LinkedList<E>();

    /**
     * @return size of linked stack
     */
    public int size() {
        return list.size();
    }

    /**
     * @param element that we want to add to linked stack
     */
    public void push(E element) {
        list.addFirst(element);
    }

    /**
     * Removes first element from stack and return it
     *
     * @return first element from linked stack
     */
    public E pop() {
        return list.removeFirst();
    }

    /**
     * @return first element of a stack
     */
    public E top() {
        if (isEmpty()) return null;
        return list.first();
    }

    /**
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
