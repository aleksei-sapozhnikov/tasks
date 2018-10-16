package tasks.hackerrank.strings;

import javafx.util.Pair;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RepeatedStringTest {

    @Test
    public void testCount() {
        RepeatedString test = new RepeatedString();
        Pair<String, Long> input1 = new Pair<>("aba", 10L);
        Pair<String, Long> input2 = new Pair<>("a", 1_000_000_000_000L);

        assertThat(test.count(input1.getKey(), input1.getValue(), 'a'), is(7L));
        assertThat(test.count(input2.getKey(), input2.getValue(), 'a'), is(1_000_000_000_000L));
    }

}