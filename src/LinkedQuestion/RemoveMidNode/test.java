package LinkedQuestion.RemoveMidNode;

import LinkedQuestion.Node.Node;
import LinkedQuestion.Node.TestNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //创建两个链表，不然会对同一链表引用重复操作
        Node head1 = makeLinkedNode(nums);
        Node head2 = makeLinkedNode(nums);

        printNode(new Solution().removeMidNode(head1));
        printNode(new Solution().removeByRatio(head2, 3, 6));
    }
}
