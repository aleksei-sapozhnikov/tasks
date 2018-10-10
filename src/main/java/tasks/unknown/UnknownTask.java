package tasks.unknown;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Входные параметры:
 * 0 5 10 0 11 14 13 4 11 8 8 7 1 4 12 11
 * <p>
 * Задача:
 * Нужно найти ячейку с максимальным значением, обнулить её и перераспределить
 * это значение по всем ячейкам начиная со следующей. Через N шагов будет обнаружена
 * комбинация значений в ячейках, которая уже встречалась ранее, а значит ситуация
 * будет бесконечно повторяться.
 * <p>
 * Сколько шагов до обнаружения бесконечного цикла? (ответ 7864)
 * Какая длина цикла? (ответ 1695)
 * <p>
 * <p>
 * Пример:
 * =======
 * 0 2 7 0
 * 2 4 1 2 <--
 * 3 1 2 3
 * 0 2 3 4
 * 1 3 4 1
 * 2 4 1 2 <-- нашли цикл за 5 шагов, длинна цикла = 4
 * <p>
 * <p>
 * <p>
 * ===============================================================================================================
 * <p>
 * Предварительное задумка решения (возможно, неверная):
 * <p>
 * 1. есть массив из n элементов, находим наибольший элемент m со значением i
 * 2. запоминаем его значение, обнуляем его
 * 3. делаем цикл на i итераций с элемента m+1 и добавляем текущему элементу ++
 * 4. сравниваем текущий массив с первым, чтобы определить зацикленность
 * <p>
 * ===============================================================================================================
 */
class UnknownTask {

    public static void main(String[] args) {
        UnknownTask test = new UnknownTask();
        System.out.println(test.findCycle(new int[]{0, 2, 7, 0}));
        System.out.println(test.findCycle(new int[]{0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11}));
    }

    private static void processArr(int[] arr, int maxNumberIndex) {
        int remaining = arr[maxNumberIndex];
        arr[maxNumberIndex] = 0;
        for (int i = maxNumberIndex + 1; remaining > 0; i++) {
            if (i >= arr.length) {
                i = 0;
            }
            arr[i] = arr[i] + 1;
            remaining--;
        }
    }

    public Result findCycle(final int[] arrayQ) {
        int[] array = Arrays.copyOf(arrayQ, arrayQ.length);
        Result result = null;
        int stepCounter = 0;
        boolean hasCycle = false;
        HashMap<Sequence, Integer> storage = new HashMap<>();
        while (!hasCycle) {
            Sequence sequence = new Sequence(array);
            if (storage.putIfAbsent(sequence, stepCounter++) != null) {
                int currentStep = storage.get(sequence);
                result = new Result(stepCounter - 1, currentStep, stepCounter - 1 - currentStep);
                hasCycle = true;
            }
            processArr(array, this.mazNumberIndex(array));
        }
        return result;
    }

    private int mazNumberIndex(int[] arr) {
        int temp = 0;
        int foundIndexNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > temp) {
                temp = arr[i];
                foundIndexNumber = i;
            }
        }
        return foundIndexNumber;
    }

    static class Result {
        private int steps;
        private int currentStep;
        private int cycleSize;

        public Result(int steps, int currentStep, int cycleSize) {
            this.steps = steps;
            this.currentStep = currentStep;
            this.cycleSize = cycleSize;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "steps=" + steps +
                    ", currentStep=" + currentStep +
                    ", cycleSize=" + cycleSize +
                    '}';
        }
    }

    static class Sequence {
        int[] arr;

        Sequence(int[] arr) {
            this.arr = arr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Sequence sequence = (Sequence) o;
            return Arrays.equals(arr, sequence.arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }

        @Override
        public String toString() {
            return "Sequence{" +
                    "arr=" + Arrays.toString(arr) +
                    '}';
        }
    }


}