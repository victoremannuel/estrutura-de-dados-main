package br.edu.ifgoiano.trabalhoEmGrupo3;

import br.edu.ifgoiano.trabalhoEmGrupo3.interfaces.*;

public class SortedDoublyLinkedList<T extends Comparable<T>> implements ISortedList<T>, IDoublyLinkedList<T> {
    private class ListNode<U> {
        U value;
        ListNode<U> next;
        ListNode<U> previous;

        ListNode(U value) {
            this.value = value;
        }
    }

    private ListNode<T> head;
    private ListNode<T> tail;
    private ListNode<T> navigationPointer;

    @Override
    public void insert(T value) {
        ListNode<T> newNode = new ListNode<>(value);

        if (head == null) {
            head = tail = newNode;
        } else {
            ListNode<T> current = head;
            ListNode<T> prev = null;

            while (current != null && value.compareTo(current.value) > 0) {
                prev = current;
                current = current.next;
            }

            if (prev == null) {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            } else if (current == null) {
                prev.next = newNode;
                newNode.previous = prev;
                tail = newNode;
            } else {
                newNode.next = current;
                newNode.previous = prev;
                prev.next = newNode;
                current.previous = newNode;
            }
        }
    }

    @Override
    public boolean remove(T value) {
        if (head == null) {
            return false;
        }

        ListNode<T> current = head;

        while (current != null) {
            if (current.value.equals(value)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.previous = null;
                    }
                } else if (current == tail) {
                    tail = tail.previous;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public T find(T value) {
        ListNode<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public void clear() {
        head = tail = null;
    }

    @Override
    public String listContent() {
        StringBuilder result = new StringBuilder();
        ListNode<T> current = head;
        while (current != null) {
            result.append(current.value).append(" -> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();
    }

    @Override
    public String listContentReverse() {
        StringBuilder result = new StringBuilder();
        ListNode<T> current = tail;
        while (current != null) {
            result.append(current.value).append(" -> ");
            current = current.previous;
        }
        result.append("null");
        return result.toString();
    }

    @Override
    public void clearNavigation() {
        navigationPointer = head;
    }

    @Override
    public T getNextElement() {
        if (navigationPointer == null) {
            return null;
        }
        T value = navigationPointer.value;
        navigationPointer = navigationPointer.next;
        return value;
    }

    @Override
    public T getPreviousElement() {
        if (navigationPointer == null) {
            return null;
        }
        T value = navigationPointer.value;
        navigationPointer = navigationPointer.previous;
        return value;
    }
}
