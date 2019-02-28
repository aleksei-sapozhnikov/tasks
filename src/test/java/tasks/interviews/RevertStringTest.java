package tasks.interviews;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RevertStringTest {

    @Test
    public void revertUsingCharArray() {
        RevertString revert = new RevertString();
        assertThat(revert.revertUsingCharArray("odd"), is("ddo"));
        assertThat(revert.revertUsingCharArray("even"), is("neve"));
        assertThat(revert.revertUsingCharArray("123456789"), is("987654321"));
        assertThat(revert.revertUsingCharArray("12345678"), is("87654321"));
        assertThat(revert.revertUsingCharArray(""), is(""));
        assertThat(revert.revertUsingCharArray("арозаупаланалапуазора"), is("арозаупаланалапуазора"));
    }

    @Test
    public void revertUsingStringBuilder() {
        RevertString revert = new RevertString();
        assertThat(revert.revertUsingStringBuilder("odd"), is("ddo"));
        assertThat(revert.revertUsingStringBuilder("even"), is("neve"));
        assertThat(revert.revertUsingStringBuilder("123456789"), is("987654321"));
        assertThat(revert.revertUsingStringBuilder("12345678"), is("87654321"));
        assertThat(revert.revertUsingStringBuilder(""), is(""));
        assertThat(revert.revertUsingStringBuilder("арозаупаланалапуазора"), is("арозаупаланалапуазора"));
    }
}