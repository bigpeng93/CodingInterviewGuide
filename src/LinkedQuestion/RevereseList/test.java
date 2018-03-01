package LinkedQuestion.RevereseList;

import LinkedQuestion.Node.TestNode;

public class test extends TestNode{
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        printNode(new Solution().reverseList(makeLinkedNode(nums)));
        printNode(new Solution().reverseList(makeLinkedDoubleNode(nums)));
    }
}
