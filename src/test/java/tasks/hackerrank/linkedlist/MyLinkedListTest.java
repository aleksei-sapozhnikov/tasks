package tasks.hackerrank.linkedlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyLinkedListTest {

    private MyLinkedList test = new MyLinkedList();
    private List<Integer> buffer = new ArrayList<>();

    @Test
    public void removeDuplicates() {
        Consumer<Integer> consumer = this.buffer::add;
        /*
         *
         */
        int[] input1 = {1, 2, 2, 3, 3, 4};
        this.test.build(
                input1
        ).removeDuplicates().toConsumer(consumer);
        assertThat(this.buffer, is(new ArrayList<>(Arrays.asList(
                1, 2, 3, 4
        ))));
        /*
         *
         */
        this.buffer.clear();
        int[] input2 = {1, 1, 1, 1, 1, 1, 1};
        this.test.build(
                input2
        ).removeDuplicates().toConsumer(consumer);
        assertThat(this.buffer, is(new ArrayList<>(Collections.singletonList(
                1
        ))));
        /*
         *
         */
        this.buffer.clear();
        int[] input3 = {3, 9, 9, 11, 11, 11, 11, 89, 89, 100, 100, 101, 102, 103, 108, 200, 250, 250, 250, 250};
        this.test.build(
                input3
        ).removeDuplicates().toConsumer(consumer);
        assertThat(this.buffer, is(new ArrayList<>(Arrays.asList(
                3, 9, 11, 89, 100, 101, 102, 103, 108, 200, 250
        ))));
    }
}