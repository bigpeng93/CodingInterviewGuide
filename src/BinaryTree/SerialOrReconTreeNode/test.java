package BinaryTree.SerialOrReconTreeNode;

import BinaryTree.Node.Node;
import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree{
    public static void main(String[] args) {
        int[][] nums = {
                {1},
                {2,3},
                {4,-1,-1,5},
        };
        Node head = makeBinaryNode(nums);
        String serial = new Solution().serialByPre(head);
        System.out.println(serial);
        Node cur = new Solution().reconByPreString(serial);
        printTree(cur);

        String serial2 = new Solution().serialByLevel(head);
        System.out.println(serial2);
        Node cur2 = new Solution().reconByLevelString(serial2);
        printTree(cur2);
    }
}
