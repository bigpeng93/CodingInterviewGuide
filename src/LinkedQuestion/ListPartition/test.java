package LinkedQuestion.ListPartition;

import LinkedQuestion.Node.TestNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[] nums = {1,7,5,3,2,6,8};
        printNode(new Solution().listPartition(makeLinkedNode(nums),4));

    }
}
