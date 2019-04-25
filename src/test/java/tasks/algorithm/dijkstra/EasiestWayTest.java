package tasks.algorithm.dijkstra;

import static org.junit.Assert.*;

import org.junit.Test;
import tasks.algorithm.dijkstra.EasiestWay;


public class EasiestWayTest {

    private EasiestWay easiestWay = new EasiestWay();

    @Test
    public void easiestWay() {
        int[][] input = {
                {1, 3, 6},
                {6, 4, 5}
        };
        int[] start = {0, 0};
        int[] end = {1, 2};
        int result = this.easiestWay.easiestWay(input, start, end);
        assertEquals(4, result);
    }

}