package BinaryTree.LowestAncestor;

import BinaryTree.Node.Node;
import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree {
    public static void main(String[] args) {
        int[][] nums = {
                {1},
                {2, 3},
                {4, 5, 6, 7},
                {-1, -1, -1, -1, -1, -1, -1, 8}
        };
        Node head = makeBinaryNode(nums);
        Node o1 = getNode(head, 4);
        Node o2 = getNode(head, 5);
        System.out.println(new Solution().lowestAncestor(head, o1, o2).value);

        System.out.println(new Solution().lowestAncestorRecord(head, o1, o2).value);
    }
}
