package tasks.algorithm;

import org.junit.Test;

import java.util.Arrays;


public class DijkstraTest {
    private static final int I = Dijkstra.INF;

    @Test
    public void dijkstraO2() {
        int[][] matrix = {
                {I, 1, I, 4},
                {1, I, 2, I},
                {I, 2, I, 3},
                {4, I, 3, I}
        };
        int[] dist = new Dijkstra().dijkstraO2(matrix, 0);
        System.out.println(Arrays.toString(dist));
    }
}