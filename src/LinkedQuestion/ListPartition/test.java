package LinkedQuestion.ListPartition;

import LinkedQuestion.Node.TestNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[] nums = {1, 7, 5, 3, 2, 6, 8};
        printNode(new Solution().listPartitionOne(makeLinkedNode(nums), 4));
        printNode(new Solution().listPartitionTwo(makeLinkedNode(nums), 4));
    }
}
