package LinkedQuestion.Convert;

import LinkedQuestion.Node.TestNode;
import LinkedQuestion.Node.TreeNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[][] nums = {
                {6},
                {4, 7},
                {2, 5, -1, 9},
                {1, 3, -1, -1, 8, -1}
        };
        TreeNode head = makeBinaryNode(nums);
        new Solution().convertOne(head);
        printNode(head);
    }

}
