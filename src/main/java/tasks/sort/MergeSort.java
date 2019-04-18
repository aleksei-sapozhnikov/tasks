package tasks.sort;

import java.util.Arrays;

/**
 * Реализация сортировки слиянием.
 *
 * @author Aleksei Sapozhnikov (vermucht@gmail.com)
 * @version 0.1
 * @since 0.1
 */
public class MergeSort {

    /**
     * Разбиваем массив на две части пополам.
     * Обе части рекурсивно сортируем.
     * Затем сливаем обе части - и получаем результат.
     *
     * @param a Массив на входе.
     * @return Этот же массив после сортировки.
     */
    public int[] mergeSort(int[] a) {
        int n = a.length;
        if (n < 2) {
            return a;
        }
        // разбиваем
        int mid = n / 2;
        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, n);
        // сортируем части
        this.mergeSort(left);
        this.mergeSort(right);
        // слияние частей
        this.merge(a, left, right);
        return a;
    }

    /**
     * Слияние двух сортированных частей.
     *
     * @param dest  Куда сливаем (результирующий массив).
     * @param left  Левая сортированная часть.
     * @param right Правая сортированная часть.
     */
    private void merge(int[] dest, int[] left, int[] right) {
        int nLeft = left.length;
        int nRight = right.length;
        int iLeft = 0;
        int iRight = 0;
        int iDest = 0;
        while (iLeft < nLeft && iRight < nRight) {
            dest[iDest++] = left[iLeft] <= right[iRight]
                    ? left[iLeft++]
                    : right[iRight++];
        }
        while (iLeft < nLeft) {
            dest[iDest++] = left[iLeft++];
        }
        while (iRight < nRight) {
            dest[iDest++] = right[iRight++];
        }
    }
}
