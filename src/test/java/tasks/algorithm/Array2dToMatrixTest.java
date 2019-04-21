package tasks.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;


public class Array2dToMatrixTest {
    private static final int I = Integer.MAX_VALUE / 2;

    private final Array2dToMatrix convert = new Array2dToMatrix();

    @Test
    public void convert() {
        int[][] input = {
                {1, 3, 6},
                {6, 4, 5}
        };
        int[][] matrix = {
                {I, 2, I, 5, I, I},
                {2, I, 3, I, 1, I},
                {I, 3, I, I, I, 1},
                {5, I, I, I, 2, I},
                {I, 1, I, 2, I, 1},
                {I, I, 1, I, 1, I}
        };
        int[][] result = this.convert.convert(input);
        assertTrue(Arrays.deepEquals(result, matrix));
    }

    @Test
    public void cellCoords() {
        int[][] array = {
                {1, 3, 6},
                {6, 4, 5}
        };
        assertArrayEquals(new int[]{0, 0}, this.convert.cellCoords(array, 0));
        assertArrayEquals(new int[]{0, 1}, this.convert.cellCoords(array, 1));
        assertArrayEquals(new int[]{0, 2}, this.convert.cellCoords(array, 2));
        assertArrayEquals(new int[]{1, 0}, this.convert.cellCoords(array, 3));
        assertArrayEquals(new int[]{1, 1}, this.convert.cellCoords(array, 4));
        assertArrayEquals(new int[]{1, 2}, this.convert.cellCoords(array, 5));
    }

}