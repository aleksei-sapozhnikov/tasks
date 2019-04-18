package tasks.sort;


/**
 * Реализация сортировки массива вставками.
 * <p>
 * 1) Сортируем массив поэлементно слева направо.
 * 2) Уже отсортированную часть не трогаем.
 * 3) В оставшемся подмассиве ищем минимальный элемент
 * и вставляем его на место первого в этом подмассиве.
 * 4) Делаем i+1 и переходим к следующему подмассиву.
 *
 * @author Aleksei Sapozhnikov (vermucht@gmail.com)
 * @version 0.1
 * @since 0.1
 */
public class SelectionSort {

    public int[] selectionSort(int[] arr) {
        for (int dest = 0; dest < arr.length - 1; dest++) {
            int minPos = dest;
            for (int j = dest + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            int tmp = arr[dest];
            arr[dest] = arr[minPos];
            arr[minPos] = tmp;
        }
        return arr;
    }

}
