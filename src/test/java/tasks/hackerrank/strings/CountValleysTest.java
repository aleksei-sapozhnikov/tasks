package tasks.hackerrank.strings;

import org.junit.Test;
import utils.CommonMethods;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CountValleysTest {

    @Test
    public void countPairsOfSocksTest() throws IOException {
        CountValleys test = new CountValleys();
        String input1 = "UDDDUDUU";
        String input2 = "DDUUDDUDUUUD";
        String input3 = "UDUUUDUDDD";
        String input4 = CommonMethods.getInstance().loadFileAsString(this,
                this.getClass().getPackage().getName().replace(".", "/"),
                "countValleysInput4", "UTF-8");
        assertThat(test.countValleys(input1), is(1));
        assertThat(test.countValleys(input2), is(2));
        assertThat(test.countValleys(input3), is(0));
        assertThat(test.countValleys(input4), is(398));
    }

}