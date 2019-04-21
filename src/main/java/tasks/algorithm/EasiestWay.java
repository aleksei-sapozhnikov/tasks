package tasks.algorithm;


/**
 * Задача: дан двумерный массив, показывающий некие "высоты" на местности.
 * <p>
 * Из каждой ячейки массива мы можем пойти в соседнюю: направо, налево, вниз, вверх
 * (конечно, не выходя за пределы массива).
 * <p>
 * Задача: найти цену самого короткого пути из одной заданной точки в другую.
 *
 * @author Aleksei Sapozhnikov (vermucht@gmail.com)
 * @version 0.1
 * @since 0.1
 */
public class EasiestWay {
    /**
     * Преобразует массив высот в матрицу смежности для алгоритма Дейкстры.
     */
    private Array2dToMatrix array2dToMatrix = new Array2dToMatrix();
    /**
     * Алгоритм Дейкстры - находит самые "дешевые" пути из одного графа в другой.
     */
    private Dijkstra dijkstra = new Dijkstra();

    public int easiestWay(int[][] heights, int[] start, int[] end) {
        int[][] matrix = this.array2dToMatrix.convert(heights);
        int graphStart = this.array2dToMatrix.graphNumber(heights, start);
        int graphEnd = this.array2dToMatrix.graphNumber(heights, end);
        int[] minWays = dijkstra.dijkstraO2(matrix, graphStart);
        return minWays[graphEnd];
    }

}
