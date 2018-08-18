package BinaryTree.PrintTree;

import BinaryTree.Node.Node;
import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree {
    public static void main(String[] args) {
        int[][] nums = {
                {1},
                {2,3},
                {4,-1,5,6},
                {-1,7}
        };
        Node head = makeBinaryNode(nums);
        new Solution().printTree(head);
    }
}
