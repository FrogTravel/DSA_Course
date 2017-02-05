/**
 * @author ekaterina
 */
public interface LinkedListInterface<E> {

    /**
     * @return size of linked list
     */
    int size();

    /**
     * @return true if linked list is empty
     */
    boolean isEmpty();

    /**
     * @return first element in linked list
     */
    E first();

    /**
     * @return last element in linked list
     */
    E last();

    /**
     * @return removed element from linked list
     */
    E removeFirst();


}
