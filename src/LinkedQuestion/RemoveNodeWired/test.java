package LinkedQuestion.RemoveNodeWired;

import LinkedQuestion.Node.Node;
import LinkedQuestion.Node.TestNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8};
        Node head = makeLinkedNode(nums);
        Node node = getNthNode(head,4);
        new Solution().removeNodeWired(node);
        printNode(head);

/*      不能删除最后一个节点
        node = getNthNode(head,7);
        new Solution().removeNodeWired(node);
        printNode(head);*/
    }
}
