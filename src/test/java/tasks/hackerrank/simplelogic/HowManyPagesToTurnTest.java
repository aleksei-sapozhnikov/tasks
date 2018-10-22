package tasks.hackerrank.simplelogic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HowManyPagesToTurnTest {

    private HowManyPagesToTurn test = new HowManyPagesToTurn();

    @Test
    public void countPages() {
        assertThat(this.test.countPages(6, 2), is(1));
        assertThat(this.test.countPages(5, 4), is(0));
        assertThat(this.test.countPages(6, 5), is(1));
        assertThat(this.test.countPages(96993, 70030), is(13481));
        assertThat(this.test.countPages(15603, 6957), is(3478));
    }

}