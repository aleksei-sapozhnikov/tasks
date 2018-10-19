package tasks.hackerrank.linkedlist;

import java.util.function.Consumer;

/**
 * From: hackerrank.com. Date: 19.10.2018
 * <p>
 * Simple implementation of a linked list, to perform tasks.
 */
public class MyLinkedList {
    private Node head = null;

    /**
     * Builds linked list.
     * (not efficient way, because while inserting each node we start
     * with head node and traverse to the last value).
     *
     * @param data Array of data values.
     * @return List with data.
     */
    public MyLinkedList build(int... data) {
        if (data.length <= 0) {
            this.head = null;
            return this;
        }
        this.head = new Node(data[0]);
        for (int i = 1; i < data.length; i++) {
            this.insert(this.head, data[i]);
        }

        return this;
    }

    /**
     * Inserts new Node with data to the end of the list.
     * The list is defined by the first node (head).
     *
     * @param head Head of the list.
     * @param data Data to insert.
     * @return Head of the list.
     */
    private Node insert(Node head, int data) {
        Node insert = new Node(data);
        if (head == null) {
            head = insert;
        } else if (head.next == null) {
            head.next = insert;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = insert;
        }
        return head;
    }

    /**
     * Traverses all nodes and returns them a list of values.
     *
     * @param consumer Consumer to accept result.
     */
    public void toConsumer(Consumer<Integer> consumer) {
        Node current = this.head;
        while (current != null) {
            consumer.accept(current.data);
            current = current.next;
        }
    }

    /**
     * Removes duplicates.
     * Public method for use.
     *
     * @return Current list.
     */
    public MyLinkedList removeDuplicates() {
        this.removeDuplicates(this.head);
        return this;
    }

    /**
     * Name: Day 24: More Linked Lists (30 days of code). From: hackerrank.com. Date: 19.10.2018
     * <p>
     * Make method to delete any duplicate nodes from the linked list.
     * Note: The <tt>head</tt> pointer may be null, indicating that the list is empty.
     * <p>
     * Constraaints: data elements are always given in non-decreasing order.
     * <p>
     * Example: given list = {1, 2, 2, 3, 3, 4} we return {1, 2, 3, 4}.
     *
     * @param head Head node.
     * @return Head of the list (after duplicates removal).
     */
    private Node removeDuplicates(Node head) {
        if (head == null) {
            return head;
        }
        Node current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * Node.
     */
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


}