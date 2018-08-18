package LinkedQuestion.RemoveValue;

import LinkedQuestion.Node.Node;

import java.util.Stack;

/**
 * 在单链表中删除指定值的节点
 * <p>
 * 给定一个链表的头节点head和一个整数num，请实现函数将值为null的节点全部删除
 * 例如，链表为1->2->3->4->null，num=3，链表调整为：1->2->4->null。
 */
public class Solution {
    //方法一：利用栈或者其他容器收集节点的方法。时间复杂度为O(N)，额外空间复杂度为O(N)。
    public Node removeValueOne(Node head, int num) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.value != num) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    //方法二：不用任何容器而直接调整的方法。时间复杂度为O(N)，额外空间复杂度为O(1)。
    public Node removeValueTwo(Node head, int num) {
        Node pre = new Node(0);
        pre.next = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
