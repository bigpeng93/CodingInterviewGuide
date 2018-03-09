package BinaryTree.IsPostArray;

import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree{
    public static void main(String[] args) {
        int[] nums ={3,5,4,7,9,8,6};
        System.out.println(new Solution().isPostArray(nums));
    }
}
