package BinaryTree.IsBSTOrCBT;

import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree {
    public static void main(String[] args) {
        int[][] nums = {
                {6},
                {4, 8},
                {-1, 5, 7, 9},
        };
        //System.out.println(new Solution().isBST(makeBinaryNode(nums)));
        System.out.println(new Solution().isCBT(makeBinaryNode(nums)));
    }
}
