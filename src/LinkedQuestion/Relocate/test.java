package LinkedQuestion.Relocate;

import LinkedQuestion.Node.Node;
import LinkedQuestion.Node.TestNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Node head = makeLinkedNode(nums);
        new Solution().relocate(head);
        printNode(head);
    }

}
