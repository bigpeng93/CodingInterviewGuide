package BinaryTree.PrintByLevelOrZigZag;

import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree{
    public static void main(String[] args) {
        int[][] nums ={
                {1},
                {2,3},
                {4,-1,5,6},
                {-1,-1,7,8}
        };
        //new Solution().printByLevel(makeBinaryNode(nums));
        new Solution().printByZigZag(makeBinaryNode(nums));
    }
}
