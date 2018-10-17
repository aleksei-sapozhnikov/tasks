package tasks.hackerrank.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTreeTest {

    @Test
    public void buildTree() {
        BinarySearchTree tree = new BinarySearchTree();
        int[] input1 = {3, 5, 2, 1, 4, 6, 7};
        int[] input2 = {20, 50, 35, 44, 9, 15, 62, 11, 13};
        int[] input3 = {25, 39, 12, 19, 9, 23, 55, 31, 60, 35, 41, 70, 90};
        assertThat(tree.buildTree(input1).getTreeHeight(), is(3));
        assertThat(tree.buildTree(input2).getTreeHeight(), is(4));
        assertThat(tree.buildTree(input3).getTreeHeight(), is(5));
    }
}