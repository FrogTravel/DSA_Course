package ShuntingYard;

/**
 * Created by ekaterina on 03.02.17.
 */
public class LinkedList<E> implements LinkedListInterface{
    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    public LinkedList (){}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        if(isEmpty()) return null;
        return head.getElement();
    }

    @Override
    public E last() {
        if(isEmpty()) return null;
        return tail.getElement();
    }



    public void addFirst(E element) {
        head = new Node<> (element, head);
        if(isEmpty()){
            tail = head;
        }
        size++;
    }


    public void addLast(E element) {
        Node<E> newElement = new Node<E>(element, null);
        if(isEmpty()){
            head = newElement;
        }else{
            tail.setNextElement(newElement);
        }
        tail = newElement;
        size++;
    }

    public E removeFirst() {
        if(isEmpty()) return null;

        E result = head.getElement();

        head = head.getNext();
        size--;

        if(isEmpty())
            tail = null;

        return result;
    }



}
