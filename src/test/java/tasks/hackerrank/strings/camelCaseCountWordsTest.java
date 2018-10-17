package tasks.hackerrank.strings;

import org.junit.Test;
import utils.CommonMethods;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class camelCaseCountWordsTest {

    private camelCaseCountWords test = new camelCaseCountWords();

    private String input1 = "saveChangesInTheEditor";
    private int result1 = 5;

    private String input2 = CommonMethods.getInstance().loadFileAsString(this,
            this.getClass().getPackage().getName().replace(".", "/"),
            "camelCaseCountWordsInput2", "UTF-8");
    private int result2 = 86;

    private String input3 = CommonMethods.getInstance().loadFileAsString(this,
            this.getClass().getPackage().getName().replace(".", "/"),
            "camelCaseCountWordsInput3", "UTF-8");
    private int result3 = 50000;

    private String input4 = "";
    private int result4 = 0;

    public camelCaseCountWordsTest() throws IOException {
    }


    @Test
    public void usingStreams() {
        assertThat(test.usingStreams(this.input1), is(this.result1));
        assertThat(test.usingStreams(this.input2), is(this.result2));
        assertThat(test.usingStreams(this.input3), is(this.result3));
        assertThat(test.usingStreams(this.input4), is(this.result4));
    }

    @Test
    public void withoutStreams() {
        assertThat(test.withoutStreams(this.input1), is(this.result1));
        assertThat(test.withoutStreams(this.input2), is(this.result2));
        assertThat(test.withoutStreams(this.input3), is(this.result3));
        assertThat(test.withoutStreams(this.input4), is(this.result4));
    }

    @Test
    public void usingSplitString() {
        assertThat(test.usingSplitString(this.input1), is(this.result1));
        assertThat(test.usingSplitString(this.input2), is(this.result2));
        assertThat(test.usingSplitString(this.input3), is(this.result3));
        assertThat(test.usingSplitString(this.input4), is(this.result4));
    }
}