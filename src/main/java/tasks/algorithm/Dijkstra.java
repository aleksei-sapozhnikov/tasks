package tasks.algorithm;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Алгоритм Дейкстры.
 *
 * @author Aleksei Sapozhnikov (vermucht@gmail.com)
 * @version 0.1
 * @since 0.1
 */
public class Dijkstra {
    /**
     * "Бесконечность"
     */
    public static final int INF = Integer.MAX_VALUE / 2;

    /**
     * Алгоритм сложности O(n^2).
     *
     * @param graph Представление графа (матрица смежности).
     * @param start Вершина, от которой мы ищем путь (порядковый номер этой вершины, начиная от 0).
     */
    public int[] dijkstraO2(int[][] graph, int start) {
        /*
         * Количество вершин в графе.
         */
        int nEdge = graph.length;
        /*
         * Пометки уже пройденных (использованных) вершин
         */
        boolean[] used = new boolean[nEdge];
        /*
         * Минимальные расстояния: dist[v] - от вершины start до вершины v
         */
        int[] dist = new int[nEdge];

        /*
         * Начальное состояние: все вершины недостижимы, кроме начальной.
         */
        Arrays.fill(dist, INF);
        dist[start] = 0;

        /*
        Сделано в дурном тоне: бесконечный цикл.
         */
        for (; ; ) {
            /*
             * Ищем ближайшую к стартовой вершину (ее номер).
             * Для этого перебираем все вершины, ищем самую ближнюю ("дешевую").
             * Ищем, чтобы:
             *      1. Эта вершину мы не проходили ранее
             *      2. Она не имеет отметки INF - то есть, соединена с вершиной, в которой мы до этого находились.
             *      3. Она является ближайшей (по сравнению с ранее найденными)
             */
            int nearest = -1;
            for (int edge = 0; edge < nEdge; edge++) {
                if (!used[edge]
                        && dist[edge] < INF
                        && (nearest == -1 || dist[nearest] > dist[edge])
                ) {
                    nearest = edge;
                }
            }
            /*
             * Если ни одной ближайшей вершины не найдено - выходим из цикла
             */
            if (nearest == -1) {
                break;
            }
            /*
             * Если ближайшая вершина найдена - переходим на нее и сразу помечаем, что мы с ней "поработали".
             * Далее перебираем все вершины в графе и ищем, такие, что:
             *      1. Мы их ранее не проходили.
             *      2. Они имеют соединение с текущей (определяем по матрице смежности).
             * Найдя такую вершину, сравниваем, что дешевле ("ближе):
             * уже имеющийся другой путь до найденной вершины или путь через нашу текущую вершину.
             */
            used[nearest] = true;
            for (int edge = 0; edge < nEdge; edge++) {
                if (!used[edge] && graph[nearest][edge] < INF) {
                    int stored = dist[edge];
                    int current = dist[nearest] + graph[nearest][edge];
                    dist[edge] = Math.min(stored, current);
                }
            }
        }
        return dist;
    }
}
