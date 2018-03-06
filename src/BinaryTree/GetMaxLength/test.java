package BinaryTree.GetMaxLength;

import BinaryTree.Node.Node;
import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree{
    public static void main(String[] args) {
        int[][] nums={
                {-3},
                {3,-9},
                {1,0,2,1},
                {-1,-1,1,6}
        };
        Node head = makeBinaryNode(nums);
        System.out.println(new Solution().getMaxLength(head,-9));
    }
}
