package BinaryTree.OrderRecur;

import BinaryTree.Node.Node;
import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree {
    public static void main(String[] args) {
        int[][] nums ={
                {   1   },
                { 2 , 3 },
                {4,5,6,7}
        };
        Node head = makeBinaryNode(nums);
        new Solution().preOrderRecur(head);
        System.out.println();
        new Solution().inOrderRecur(head);
        System.out.println();
        new Solution().posOrderRecur(head);
    }
}
