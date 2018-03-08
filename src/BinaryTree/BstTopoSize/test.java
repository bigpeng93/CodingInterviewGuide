package BinaryTree.BstTopoSize;

import BinaryTree.Node.Node;
import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree{
    public static void main(String[] args) {
        int[][] nums = {
                {6},
                {1, 12},
                {0, 3, 10, 13},
                {-1, -1, -1, -1, 4, 14, 20, 16},
                {2, 5, 11, 15}
        };
        Node head = makeBinaryNode(nums);
        //System.out.println(new Solution().BstTopoSizeOne(head));
        System.out.println(new Solution().BstTopoSizeTwo(head));
    }
}
