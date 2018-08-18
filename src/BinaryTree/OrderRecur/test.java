package BinaryTree.OrderRecur;

import BinaryTree.Node.Node;
import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree {
    public static void main(String[] args) {
        int[][] nums = {
                {1},
                {2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11, 12, 13, 14, 15}
        };
        Node head = makeBinaryNode(nums);
        new Solution().preOrderRecur(head);
        System.out.println();
        new Solution().inOrderRecur(head);
        System.out.println();
        new Solution().posOrderRecur(head);
        System.out.println();
        new Solution().preOrderUnRecur(head);
        System.out.println();
        new Solution().inOrderUnRecur(head);
        System.out.println();
        new Solution().posOrderUnRecurOne(head);
        System.out.println();
        new Solution().posOrderUnRecurTwo(head);

    }
}
