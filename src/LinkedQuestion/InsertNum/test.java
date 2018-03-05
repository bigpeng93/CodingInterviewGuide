package LinkedQuestion.InsertNum;

import LinkedQuestion.Node.Node;
import LinkedQuestion.Node.TestNode;

public class test extends TestNode{
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6,7};
        Node head = makeRoundLinkedNode(nums);
        new Solution().insertNum(head,4);
        printRoundNode(head);

    }
}
