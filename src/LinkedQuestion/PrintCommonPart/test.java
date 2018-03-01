package LinkedQuestion.PrintCommonPart;

import LinkedQuestion.Node.Node;
import LinkedQuestion.Node.TestNode;

public class test extends TestNode{
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6};
        int[] nums2 = {2,4,5,6,8};
        Node head1 = makeLinkedNode(nums1);
        Node head2 = makeLinkedNode(nums2);
        new PrintCommonPart().printCommonPart(head1,head2);
    }
}
