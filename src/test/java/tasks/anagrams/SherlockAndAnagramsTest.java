package tasks.anagrams;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SherlockAndAnagramsTest {

    @Test
    public void numOfAnagramPairs() {
        SherlockAndAnagrams test = new SherlockAndAnagrams();
        assertThat(test.numOfAnagramPairs("abba"), is(4));
        assertThat(test.numOfAnagramPairs("abcd"), is(0));
        assertThat(test.numOfAnagramPairs("ifailuhkqq"), is(3));
        assertThat(test.numOfAnagramPairs("kkkk"), is(10));
        assertThat(test.numOfAnagramPairs("cdcd\n"), is(5));
    }
}