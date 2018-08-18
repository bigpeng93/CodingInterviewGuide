package LinkedQuestion.RemoveValue;

import LinkedQuestion.Node.TestNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        printNode(new Solution().removeValueOne(makeLinkedNode(nums), 4));
        printNode(new Solution().removeValueTwo(makeLinkedNode(nums), 5));
    }
}
