package LinkedQuestion.Merge;

import LinkedQuestion.Node.TestNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6};
        printNode(new Solution().merge(makeLinkedNode(nums1), makeLinkedNode(nums2)));
    }
}
