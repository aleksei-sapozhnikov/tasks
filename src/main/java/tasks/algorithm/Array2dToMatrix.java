package tasks.algorithm;

import java.util.Arrays;

/**
 * Convert 2d array to matrix.
 *
 * @author Aleksei Sapozhnikov (vermucht@gmail.com)
 * @version 0.1
 * @since 0.1
 */
public class Array2dToMatrix {
    /**
     * "Бесконечность"
     */
    public static final int INF = Integer.MAX_VALUE / 2;

    /**
     * Создает матрицу смежности из двумерного массива.
     * В массиве указаны цифры - некая "высота" участка.
     * <p>
     * Перемещаться можно из текущей клетки в соседнюю клетку справа или слева
     * или в соседнюю клетку сверху или снизу.
     * <p>
     * Сложность перемещения из клетки в клетку определяется как
     * модуль разности между "высотой" в этой клетке и в той, в которую перемещаемся.
     * <p>
     * В результате работы метода появляется матрица смежности (см. теорию графов).
     * Элемент (i, j) в матрице смежности означает сложность ("цену") перемещения
     * из i-го графа в j-й граф. Если переместиться невозможно - используется значение
     * "бесконечность", заданное полем {@link Array2dToMatrix#INF}.
     * <p>
     * Полученная матрица смежности применяется затем в алгоритме Дейкстры для нахождения
     * самого "дешевого" пути из одной точки (графа) в другую.
     * <p>
     * Нумерация графов, получаемых из элементов массива идет в следующем порядке:
     * (0,0) => граф номер 0 - нулевая строка, нулевой столбец.
     * (0,1) => граф номер 1 - нулевая строка, первый столбец.
     * (0,2) => граф номер 2 - нулевая строка, второй столбец.
     * И так далее до конца строки.
     * <p>
     * Пусть в строке было n колонок, значит, последним в этой строке мы отметили элемент:
     * (0, n-1) => граф номер (n-1).
     * <p>
     * Затем нумерация продолжается с начала следующей строки:
     * (1,0) => граф номер n (==(n-1)+1) - первая строка, нулевой столбец
     * (1,1) => граф номер (n+1)
     * (1,2) => граф номер (n+2) и так далее.
     * <p>
     * В итоге из массива размером (m x n) со строками 0..n-1 и столбцами 0..m-1
     * получится (m x n) графов. В таком случае матрица смежности из такого массива
     * будет иметь размер {(m*n) x (m*n)}.
     *
     * @param input Массив "высот".
     * @return Матрица смежности.
     */
    public int[][] convert(int[][] input) {
        this.validateArray(input);
        int size = input.length * input[0].length;
        int[][] matrix = this.createInitialMatrix(size);
        this.findAllWaysAndWriteToMatrix(input, matrix);
        return matrix;
    }

    /**
     * Проверяет, что массив не пустой.
     * Если пустой - бросает исключение.
     *
     * @param array Массив "высот".
     */
    private void validateArray(int[][] array) {
        if (array.length <= 0) {
            throw new RuntimeException("Empty array given");
        }
    }

    /**
     * Создает изначальную матрицу смежности, заполняя
     * ее "бесконечностями" - изначально все точки считаем
     * недостижимыми.
     *
     * @param size Размер матрицы.
     * @return Матрица смежности.
     */
    private int[][] createInitialMatrix(int size) {
        int[][] result = new int[size][size];
        for (int[] row : result) {
            Arrays.fill(row, INF);
        }
        return result;
    }

    /**
     * Проходится по всем элементам массива, подсчитывает все возможные
     * варианты перемещения из ячейки в соседние и записывает результаты
     * в матрицу смежности.
     *
     * @param input  Массив "высот".
     * @param matrix Матрица смежности.
     */
    private void findAllWaysAndWriteToMatrix(int[][] input, int[][] matrix) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                int[] cell = new int[]{i, j};
                this.findWaysFromCellAndWriteToMatrix(input, matrix, cell);
            }
        }
    }

    /**
     * Ищет все возможные пути из данной ячейки в смежные, считает их сложность
     * и записывает результат в матрицу смежности.
     *
     * @param array  Массив "высот".
     * @param matrix Матрица смежности.
     * @param cell   Координаты ячейки в виде массива из двух элементов: {номерСтроки, номерСтолбца}.
     */
    private void findWaysFromCellAndWriteToMatrix(int[][] array, int[][] matrix, int[] cell) {
        int iStart = cell[0];
        int jStart = cell[1];
        int[][] destinations = {
                {iStart + 1, jStart}, {iStart - 1, jStart},
                {iStart, jStart + 1}, {iStart, jStart - 1}
        };
        int curGraph = this.graphNumber(array, cell);
        for (int[] dest : destinations) {
            if (this.isInBounds(array, dest)) {
                int destGraph = this.graphNumber(array, dest);
                matrix[curGraph][destGraph] = this.findWay(array, cell, dest);
            }
        }
    }

    /**
     * Возвращает сложность перехода из стартовой ячейки в финишную.
     *
     * @param array Массив "высот".
     * @param start Стартовая ячейка. Координаты заданы в виде массива из двух элементов: {номерСтроки, номерСтолбца}.
     * @param dest  Финишная ячейка. Координаты заданы в виде массива из двух элементов: {номерСтроки, номерСтолбца}.
     * @return Сложность пути из стартовой ячейки в финишную.
     */
    private int findWay(int[][] array, int[] start, int[] dest) {
        int iStart = start[0];
        int jStart = start[1];
        int iDest = dest[0];
        int jDest = dest[1];
        return Math.abs(array[iDest][jDest] - array[iStart][jStart]);
    }

    /**
     * Возвращает - находится ли данная ячейка внутри массива.
     *
     * @param array Массив.
     * @param cell  Ячейка. Координаты заданы в виде массива из двух элементов: {номерСтроки, номерСтолбца}.
     * @return <tt>true</tt>, если ячейка внутри массива, <tt>false</tt>, если нет.
     */
    private boolean isInBounds(int[][] array, int[] cell) {
        int iRow = cell[0];
        int iCol = cell[1];
        return iRow >= 0 && iRow < array.length
                && iCol >= 0 && iCol < array[0].length;
    }

    /**
     * Возвращает номер графа, соответстующего данной ячейке в массиве.
     * <p>
     * Нумерация графов, получаемых из элементов массива идет в следующем порядке:
     * (0,0) => граф номер 0 - нулевая строка, нулевой столбец.
     * (0,1) => граф номер 1 - нулевая строка, первый столбец.
     * (0,2) => граф номер 2 - нулевая строка, второй столбец.
     * И так далее до конца строки.
     * <p>
     * Пусть в строке было n колонок, значит, последним в этой строке мы отметили элемент:
     * (0, n-1) => граф номер (n-1).
     * <p>
     * Затем нумерация продолжается с начала следующей строки:
     * (1,0) => граф номер n (==(n-1)+1) - первая строка, нулевой столбец
     * (1,1) => граф номер (n+1)
     * (1,2) => граф номер (n+2) и так далее.
     * <p>
     * В итоге из массива размером (m x n) со строками 0..n-1 и столбцами 0..m-1
     * получится (m x n) графов. В таком случае матрица смежности из такого массива
     * будет иметь размер {(m*n) x (m*n)}.
     *
     * @param array Массив.
     * @param cell  Ячейка. Координаты заданы в виде массива из двух элементов: {номерСтроки, номерСтолбца}.
     * @return Номер графа, соответстующего ячейке.
     */
    private int graphNumber(int[][] array, int[] cell) {
        int iRow = cell[0];
        int iCol = cell[1];
        return iRow * array[0].length + iCol;
    }
    
}
