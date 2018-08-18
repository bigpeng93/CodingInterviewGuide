package BinaryTree.GenerateTree;

import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree{
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        printTree(new Solution().generateTree(nums));
    }
}
