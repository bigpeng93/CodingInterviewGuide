package BinaryTree.GetNextNode;

import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree {
    public static void main(String[] args) {
        int[][] nums = {
                {6},
                {3, 9},
                {1, 4, 8, 10},
                {-1, 2, 5, 7}
        };
        int num = 8;
        System.out.println(new Solution().getNextNode(makeBinaryNewNode(nums, num)).value);
    }
}
