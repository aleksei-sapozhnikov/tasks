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

}