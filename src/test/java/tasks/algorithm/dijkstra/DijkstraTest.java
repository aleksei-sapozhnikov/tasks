package tasks.algorithm.dijkstra;

import org.junit.Test;
import tasks.algorithm.dijkstra.Dijkstra;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;


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
        int startGraph = 0;
        int[] distances = new Dijkstra().dijkstraO2(matrix, startGraph);
        assertArrayEquals(new int[] {0, 1, 3, 4}, distances);
        System.out.println(Arrays.toString(distances));
    }
}