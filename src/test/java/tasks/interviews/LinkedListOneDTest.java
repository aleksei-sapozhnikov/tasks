package tasks.interviews;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LinkedListOneDTest {

    @Test
    public void testAdd() {
        LinkedListOneD<String> list = new LinkedListOneD<>();
        list.add("one");
        list.add("two");
        list.add("three");
        assertThat(list.toString(), is("{ one --> two --> three }"));
    }

    /////////////////////////////////////////////////
    // Revert list WITHOUT creation of the new one
    ////////////////////////////////////////////////

    @Test
    public void testRevertEmptyListThisList() {
        LinkedListOneD<String> list = new LinkedListOneD<>();
        list.revertThisList();
        assertThat(list.toString(), is("{  }"));
    }

    @Test
    public void testRevertOneElementListThisList() {
        LinkedListOneD<String> list = new LinkedListOneD<>();
        list.add("one");
        list.revertThisList();
        assertThat(list.toString(), is("{ one }"));
    }

    @Test
    public void testRevertNormalListThisList() {
        LinkedListOneD<String> list = new LinkedListOneD<>();
        list.add("one");
        list.add("two");
        list.add("three");
        assertThat(list.toString(), is("{ one --> two --> three }"));
        list.revertThisList();
        assertThat(list.toString(), is("{ three --> two --> one }"));
    }

    ////////////////////////////////////
    // Revert list CREATING the new one
    ////////////////////////////////////

    @Test
    public void testRevertEmptyListNewList() {
        LinkedListOneD<String> before = new LinkedListOneD<>();
        assertThat(before.toString(), is("{  }"));
        LinkedListOneD<String> after = before.revertCreateNewList();
        assertThat(before.toString(), is("{  }"));   // not changed
        assertThat(after.toString(), is("{  }"));
    }

    @Test
    public void testRevertOneElementListNewList() {
        LinkedListOneD<String> before = new LinkedListOneD<>();
        before.add("one");
        assertThat(before.toString(), is("{ one }"));
        LinkedListOneD<String> after = before.revertCreateNewList();
        assertThat(before.toString(), is("{ one }"));   // not changed
        assertThat(after.toString(), is("{ one }"));
    }

    @Test
    public void testRevertNormalListNewList() {
        LinkedListOneD<String> before = new LinkedListOneD<>();
        before.add("one");
        before.add("two");
        before.add("three");
        assertThat(before.toString(), is("{ one --> two --> three }"));
        LinkedListOneD<String> after = before.revertCreateNewList();
        assertThat(before.toString(), is("{ one --> two --> three }")); // not changed
        assertThat(after.toString(), is("{ three --> two --> one }"));
    }
}