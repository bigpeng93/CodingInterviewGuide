package LinkedQuestion.AddList;

import LinkedQuestion.Node.TestNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {1,2,3,4,5};
        printNode(new Solution().addListOne(makeLinkedNode(nums1),makeLinkedNode(nums2)));
        printNode(new Solution().addListTwo(makeLinkedNode(nums1),makeLinkedNode(nums2)));
    }
}
