/**
 * @author ekaterina
 */
class Node<E> {
    private E element;
    private Node<E> nextElement;

    public Node(E element, Node<E> node) {
        this.element = element;
        this.nextElement = node;
    }

    /**
     * @return element of current node
     */
    public E getElement() {
        return element;
    }

    /**
     * @return node to what current node link to
     */
    public Node<E> getNext() {
        return nextElement;
    }

    /**
     * @param element that will be set, so current node will like to that node
     */
    public void setNextElement(Node<E> element) {
        nextElement = element;
    }
}
