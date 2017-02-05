package ShuntingYard;

/**
 * Created by ekaterina on 04.02.17.
 */
class Node<E> {
    private E element;
    private Node<E> nextElement;

    public Node(E element, Node<E> node) {
        this.element = element;
        this.nextElement = node;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return nextElement;
    }

    public void setNextElement(Node<E> element) {
        nextElement = element;
    }
}
