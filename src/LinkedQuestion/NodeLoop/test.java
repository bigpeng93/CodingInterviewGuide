package LinkedQuestion.NodeLoop;

import LinkedQuestion.Node.Node;
import LinkedQuestion.Node.TestNode;

public class test extends TestNode{
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,8,9};
        int[] nums2 = {10,11,12,13,14,15};
        Node head1 = makeLinkedNode(nums1);
        Node head2 = makeLinkedNode(nums2);
        makeBothLinkedNode(head1,4,head2,3);
        System.out.println(new Solution().getIntersectNode(head1,head2).value);


    }
}
