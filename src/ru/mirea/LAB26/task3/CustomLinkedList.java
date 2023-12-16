package ru.mirea.LAB26.task3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    private class CustomLinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomLinkedListIterator();
    }

    public static void main(String[] args) {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        linkedList.add("One");
        linkedList.add("Two");
        linkedList.add("Three");

        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

