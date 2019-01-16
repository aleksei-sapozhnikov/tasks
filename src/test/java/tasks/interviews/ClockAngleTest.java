package tasks.interviews;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ClockAngleTest {

    private boolean areEqual(double first, double second) {
        return Math.abs(Double.compare(first, second)) < 0.0001;
    }

    @Test
    public void testAngleCalculation() {
        ClockAngle test = new ClockAngle();
        assertTrue(this.areEqual(test.angle(11, 11), 269.5));
        assertTrue(this.areEqual(test.angle(2, 40), 160));
        assertTrue(this.areEqual(test.angle(8, 20), 130));
        assertTrue(this.areEqual(test.angle(3, 15), 7.5));
    }

}