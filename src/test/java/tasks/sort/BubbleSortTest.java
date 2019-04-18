package tasks.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class BubbleSortTest {

    private final BubbleSort sort = new BubbleSort();

    @Test
    public void testResult() {
        assertArrayEquals(this.sort.bubbleSort(
                new int[]{8, 0, 4, 7, 3, 7, 10, 12, -3}),
                new int[]{-3, 0, 3, 4, 7, 7, 8, 10, 12});
        assertArrayEquals(this.sort.bubbleSort(
                new int[]{}),
                new int[]{});
        assertArrayEquals(this.sort.bubbleSort(
                new int[]{6}),
                new int[]{6});
        assertArrayEquals(this.sort.bubbleSort(
                new int[]{5, 2}),
                new int[]{2, 5});
        assertArrayEquals(this.sort.bubbleSort(
                new int[]{-4, 2}),
                new int[]{-4, 2});
        assertArrayEquals(this.sort.bubbleSort(
                new int[]{-4, 2, 5}),
                new int[]{-4, 2, 5});
        assertArrayEquals(this.sort.bubbleSort(
                new int[]{5, 2, -4}),
                new int[]{-4, 2, 5});
        assertArrayEquals(this.sort.bubbleSort(
                new int[]{5, -4, 2}),
                new int[]{-4, 2, 5});
        assertArrayEquals(this.sort.bubbleSort(
                new int[]{11, 3, 14, 16, 7}),
                new int[]{3, 7, 11, 14, 16});
    }
}