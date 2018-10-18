package tasks.hackerrank.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTreeTest {

    private BinarySearchTree tree = new BinarySearchTree();

    @Test
    public void buildTree() {
        int[] input1 = {3, 5, 2, 1, 4, 6, 7};
        int[] input2 = {20, 50, 35, 44, 9, 15, 62, 11, 13};
        int[] input3 = {25, 39, 12, 19, 9, 23, 55, 31, 60, 35, 41, 70, 90};
        int[] input4 = {2};
        assertThat(this.tree.buildTree(input1).getTreeHeight(), is(3));
        assertThat(this.tree.buildTree(input2).getTreeHeight(), is(4));
        assertThat(this.tree.buildTree(input3).getTreeHeight(), is(5));
        assertThat(this.tree.buildTree(input4).getTreeHeight(), is(0));
    }

    @Test
    public void traverseLevelByLevel() {

        int[] input1 = {3, 5, 4, 7, 2, 1};
        List<Integer> result1 = this.tree.buildTree(input1)
                .traverseLevelByLevel().stream()
                .map(BinarySearchTree.Node::getValue)
                .collect(Collectors.toList());
        List<Integer> expected1 = new ArrayList<>(Arrays.asList(3, 2, 5, 1, 4, 7));
        assertThat(result1, is(expected1));

        int[] input2 = {25, 39, 12, 19, 9, 23, 55, 31, 60, 35, 41, 70, 90};
        List<Integer> result2 = this.tree.buildTree(input2)
                .traverseLevelByLevel().stream()
                .map(BinarySearchTree.Node::getValue)
                .collect(Collectors.toList());
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(25, 12, 39, 9, 19, 31, 55, 23, 35, 41, 60, 70, 90));
        assertThat(result2, is(expected2));

        int[] input3 = {20, 50, 35, 44, 9, 15, 62, 11, 13};
        List<Integer> result3 = this.tree.buildTree(input3)
                .traverseLevelByLevel().stream()
                .map(BinarySearchTree.Node::getValue)
                .collect(Collectors.toList());
        List<Integer> expected3 = new ArrayList<>(Arrays.asList(20, 9, 50, 15, 35, 62, 11, 44, 13));
        assertThat(result3, is(expected3));
    }
}