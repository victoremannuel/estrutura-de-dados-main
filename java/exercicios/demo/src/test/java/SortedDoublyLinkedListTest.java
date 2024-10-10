package br.edu.ifgoiano.trabalhoEmGrupo3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SortedDoublyLinkedListTest {
    @Test
    @DisplayName("retrieve an empty list")
    public void retrieveAnEmptyList() {
        SortedDoublyLinkedList<Integer> list = new SortedDoublyLinkedList<Integer>();

        String content = list.listContent();

        assertEquals("null", content);
    }

    @Nested
    @DisplayName("insert action")
    class Insertion {

        @Test
        @DisplayName("insert elements in order")
        public void insertElementsInOrder() {
            SortedDoublyLinkedList<Integer> list = new SortedDoublyLinkedList<Integer>();

            list.insert(2);
            list.insert(5);
            list.insert(8);
            list.insert(4);

            String content = list.listContent();

            assertEquals("2 -> 4 -> 5 -> 8 -> null", content);
        }
    }

    @Nested
    @DisplayName("find action")
    class Find {

        @Test
        @DisplayName("find an existing element")
        public void findAnExistingElement() {
            SortedDoublyLinkedList<Integer> list = new SortedDoublyLinkedList<Integer>();
            list.insert(2);
            list.insert(5);
            list.insert(8);
            list.insert(4);

            Integer foundElement = list.find(5);

            assertEquals(5, foundElement);
        }

        @Test
        @DisplayName("return null if element not found")
        public void returnNullIfElementNotFound() {
            SortedDoublyLinkedList<Integer> list = new SortedDoublyLinkedList<Integer>();
            list.insert(2);
            list.insert(5);
            list.insert(8);
            list.insert(4);

            Integer foundElement = list.find(10);

            assertNull(foundElement);
        }
    }

    @Nested
    @DisplayName("remove action")
    class Removal {

        @Test
        @DisplayName("remove an existing element")
        public void removeAnExistingElement() {
            SortedDoublyLinkedList<Integer> list = new SortedDoublyLinkedList<Integer>();
            list.insert(2);
            list.insert(5);
            list.insert(8);
            list.insert(4);

            boolean removed = list.remove(5);

            assertTrue(removed);
            String content = list.listContent();
            assertEquals("2 -> 4 -> 8 -> null", content);
        }

        @Test
        @DisplayName("return false if element not found")
        public void returnFalseIfElementNotFound() {
            SortedDoublyLinkedList<Integer> list = new SortedDoublyLinkedList<Integer>();
            list.insert(2);
            list.insert(5);
            list.insert(8);
            list.insert(4);

            boolean removed = list.remove(10);

            assertFalse(removed);
        }
    }

    @Test
    @DisplayName("clear the list")
    public void clearTheList() {
        SortedDoublyLinkedList<Integer> list = new SortedDoublyLinkedList<Integer>();
        list.insert(2);
        list.insert(5);
        list.insert(8);

        list.clear();

        String content = list.listContent();

        assertEquals("null", content);
    }
}
