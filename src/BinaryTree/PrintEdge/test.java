package BinaryTree.PrintEdge;

import BinaryTree.Node.Node;
import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree{
    public static void main(String[] args) {
        int[][] nums = {
                {1},
                {2,3},
                {4,5,6,7},
                {-1,-1,8,9,10,11},
                {-1,-1,-1,12,13,-1},
                {14,15,16,17}
        };
        Node head = makeBinaryNode(nums);
        new Solution().printEdgeOne(head);
        System.out.println();
        new Solution().printEdgeTwo(head);


    }
}
