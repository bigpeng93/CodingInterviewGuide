package BinaryTree.IsBalance;

import BinaryTree.Node.Node;
import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree{
    public static void main(String[] args) {
        int[][] nums = {
                {1},
                {2,3},
                {-1,-1,6,7},
                {12,13,14,15}
        };
        Node head = makeBinaryNode(nums);
        System.out.println(new Solution().isBalance(head));
    }
}
