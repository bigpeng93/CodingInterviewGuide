package LinkedQuestion.JosephusKill;

import LinkedQuestion.Node.TestNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printNode(new Solution().josephusKillOne(makeRoundLinkedNode(nums), 3));
    }
}
