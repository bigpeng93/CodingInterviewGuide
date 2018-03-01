package LinkedQuestion.RemoveLastKthNode;

import LinkedQuestion.Node.Node;
import LinkedQuestion.Node.TestNode;

public class test extends TestNode{
    public static void main(String[] args) {
        int[] nums= {1,2,3,4,5,6};
        Node head = makeLinkedNode(nums);
        printNode(new RemoveLastKthNode().removelastKthNode(head,2));
    }
}
