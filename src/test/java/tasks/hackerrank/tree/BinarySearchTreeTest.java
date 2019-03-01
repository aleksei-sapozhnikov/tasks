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

    /*
               3
              / \
             2   5
            /   / \
           1   4   7
    */
    private int[] stdInput1 = {3, 5, 4, 7, 2, 1};

    /*
            _____ 25 _____
          /                \
        12               __ 39 __
       /   \           /          \
      9    19        31            55
             \        \           /   \
              23       35       41     60
                                         \
                                          70
                                            \
                                             90
     */
    private int[] stdInput2 = {25, 39, 12, 19, 9, 23, 55, 31, 60, 35, 41, 70, 90};

    /*
              ____ 20 ____
            /              \
           9             __ 50 __
             \         /          \
              16     35            62
             /         \
           11           44
             \
              13
     */
    private int[] stdInput3 = {20, 50, 35, 44, 9, 15, 62, 11, 13};

    /*
        2
    */
    private int[] stdInput4 = {4};

    @Test
    public void buildTree() {
        assertThat(this.tree.buildTree(this.stdInput1).getTreeHeight(), is(2));
        assertThat(this.tree.buildTree(this.stdInput2).getTreeHeight(), is(5));
        assertThat(this.tree.buildTree(this.stdInput3).getTreeHeight(), is(4));
        assertThat(this.tree.buildTree(this.stdInput4).getTreeHeight(), is(0));
    }

    @Test
    public void traverseLevelByLevel() {
        List<Integer> result1 = this.tree.buildTree(this.stdInput1)
                .traverseLevelByLevel().stream()
                .map(BinarySearchTree.Node::getValue)
                .collect(Collectors.toList());
        List<Integer> expected1 = new ArrayList<>(Arrays.asList(3, 2, 5, 1, 4, 7));
        assertThat(result1, is(expected1));

        List<Integer> result2 = this.tree.buildTree(this.stdInput2)
                .traverseLevelByLevel().stream()
                .map(BinarySearchTree.Node::getValue)
                .collect(Collectors.toList());
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(25, 12, 39, 9, 19, 31, 55, 23, 35, 41, 60, 70, 90));
        assertThat(result2, is(expected2));

        List<Integer> result3 = this.tree.buildTree(this.stdInput3)
                .traverseLevelByLevel().stream()
                .map(BinarySearchTree.Node::getValue)
                .collect(Collectors.toList());
        List<Integer> expected3 = new ArrayList<>(Arrays.asList(20, 9, 50, 15, 35, 62, 11, 44, 13));
        assertThat(result3, is(expected3));
    }

    @Test
    public void traversePreOrder() {

        List<Integer> result1 = this.tree.buildTree(this.stdInput1)
                .traversePreOrder().stream()
                .map(BinarySearchTree.Node::getValue)
                .collect(Collectors.toList());
        List<Integer> expected1 = new ArrayList<>(Arrays.asList(3, 2, 1, 5, 4, 7));
        assertThat(result1, is(expected1));

        List<Integer> result2 = this.tree.buildTree(this.stdInput2)
                .traversePreOrder().stream()
                .map(BinarySearchTree.Node::getValue)
                .collect(Collectors.toList());
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(25, 12, 9, 19, 23, 39, 31, 35, 55, 41, 60, 70, 90));
        assertThat(result2, is(expected2));

        List<Integer> result3 = this.tree.buildTree(this.stdInput3)
                .traversePreOrder().stream()
                .map(BinarySearchTree.Node::getValue)
                .collect(Collectors.toList());
        List<Integer> expected3 = new ArrayList<>(Arrays.asList(20, 9, 15, 11, 13, 50, 35, 44, 62));
        assertThat(result3, is(expected3));
    }
}