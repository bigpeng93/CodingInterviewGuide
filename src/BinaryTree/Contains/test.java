package BinaryTree.Contains;

import BinaryTree.Node.Node;
import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree {
    public static void main(String[] args) {
        int[][] nums1 = {
                {1},
                {2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, -1}
        };
        int[][] nums2 = {
                {2},
                {4, 5},
                {8, -1}
        };
        Node head1 = makeBinaryNode(nums1);
        Node head2 = makeBinaryNode(nums2);
        System.out.println(new Solution().contains(head1, head2));
        //printTree(head2);
    }

}
