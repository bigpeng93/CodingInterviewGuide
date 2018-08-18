package LinkedQuestion.RemoveRep;

import LinkedQuestion.Node.Node;
import LinkedQuestion.Node.TestNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[] sums = {1, 2, 3, 3, 4, 4, 2, 1, 1};
        Node head = makeLinkedNode(sums);
//        new Solution().removeRepOne(head);
        new Solution().removeRepTwo(head);
        printNode(head);

    }
}
