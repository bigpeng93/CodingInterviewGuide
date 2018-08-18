package LinkedQuestion.ReverseKNode;

import LinkedQuestion.Node.TestNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        //printNode(new Solution().reverseKthNodeOne(makeLinkedNode(nums),3));
        printNode(new Solution().reverseKthNodeOne(makeLinkedNode(nums), 3));
    }
}
