package BinaryTree.BiggestSubBST;

import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree {
    public static void main(String[] args) {
        int[][] nums = {
                {6},
                {1,12},
                {0,3,10,13},
                {-1,-1,-1,-1,4,14,20,16},
                {2,5,11,15}

/*              //结果为16
                {6},
                {1,16},
                {0,3,10,18},
                {-1,-1,-1,-1,4,14,17,19},
                {2,5,11,15}
                */
        };
        System.out.println(new Solution().biggestSubBST(makeBinaryNode(nums)).value);
    }
}
