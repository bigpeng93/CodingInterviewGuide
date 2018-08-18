package LinkedQuestion.RemoveLastKthNode;

import LinkedQuestion.Node.DoubleNode;
import LinkedQuestion.Node.Node;

/**
 * 在单链表和双链表中删除倒数第K个节点
 * <p>
 * 分别实现两个函数，一个可以删除单链表中倒数第K个节点，另一个可以删除双链表中倒数第K个节点
 */
public class RemoveLastKthNode {
    public Node removelastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            System.out.println(lastKth + ":" + cur.value);
            lastKth--;
            cur = cur.next;

        }
        if (lastKth == 0)
            head = head.next;
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;

        }
        return head;
    }

    public DoubleNode removeDoubleLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            System.out.println(lastKth + ":" + cur.value);
            lastKth--;
            cur = (DoubleNode) cur.next;

        }
        if (lastKth == 0) {
            head = (DoubleNode) head.next;
            head.last = null;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = (DoubleNode) cur.next;
            }
            DoubleNode newNext = (DoubleNode) cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = null;
            }
        }
        return head;
    }
}
