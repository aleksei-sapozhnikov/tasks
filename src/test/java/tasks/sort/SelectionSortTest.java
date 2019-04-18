package tasks.sort;

import static org.junit.Assert.*;

import org.junit.Test;


public class SelectionSortTest {

    private final SelectionSort sort = new SelectionSort();

    @Test
    public void testResult() {
        assertArrayEquals(this.sort.selectionSort(
                new int[]{8, 0, 4, 7, 3, 7, 10, 12, -3}),
                new int[]{-3, 0, 3, 4, 7, 7, 8, 10, 12});
        assertArrayEquals(this.sort.selectionSort(
                new int[]{}),
                new int[]{});
        assertArrayEquals(this.sort.selectionSort(
                new int[]{6}),
                new int[]{6});
        assertArrayEquals(this.sort.selectionSort(
                new int[]{5, 2}),
                new int[]{2, 5});
        assertArrayEquals(this.sort.selectionSort(
                new int[]{-4, 2}),
                new int[]{-4, 2});
        assertArrayEquals(this.sort.selectionSort(
                new int[]{-4, 2, 5}),
                new int[]{-4, 2, 5});
        assertArrayEquals(this.sort.selectionSort(
                new int[]{5, 2, -4}),
                new int[]{-4, 2, 5});
        assertArrayEquals(this.sort.selectionSort(
                new int[]{5, -4, 2}),
                new int[]{-4, 2, 5});
        assertArrayEquals(this.sort.selectionSort(
                new int[]{11, 3, 14, 16, 7}),
                new int[]{3, 7, 11, 14, 16});
    }
}