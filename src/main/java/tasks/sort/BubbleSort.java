package tasks.sort;

import java.util.Arrays;

/**
 * Реализация сортировки массива пузырьком.
 *
 * @author Aleksei Sapozhnikov (vermucht@gmail.com)
 * @version 0.1
 * @since 0.1
 */
public class BubbleSort {

    public int[] bubbleSort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    sorted = false;
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
        return a;
    }
}