package LinkedQuestion.IsPalindromel;

import LinkedQuestion.Node.Node;
import LinkedQuestion.Node.TestNode;

import java.util.Stack;

/**
 * 给定一个链表的头节点head，请判断该链表是否为回文结构
 * 例如：
 * 1->2->1，返回true。
 * 1->2->2->1，返回true。
 * 15->6->15，返回false。
 * 1->2->3，返回false。
 */
public class Solution {
    public boolean isPalindromal(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value)
                return false;
            head = head.next;
        }
        return true;
    }

    /**
     * 进阶：
     * 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
     */
    public boolean isPalindromalTwo(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value)
                return false;
            head = head.next;
        }
        return true;
    }

    /**
     * 不使用栈回和其他数据结构
     */
    public boolean isPalindromalThere(Node head) {
        if (head == null || head.next == null)
            return true;

        //获取链表的中间节点n1和尾节点n2
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        //将n1后面的链表进行反转
        n2 = n1.next;
        Node n3 = null;
        n1.next = null;

        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        //将n2指向头节点head，将n3指向最后一个节点
        n3 = n1;
        n2 = head;

        //判断转后的链表值所有是否相等
        while (n2 != null && n3 != null) {
            if (n2.value != n3.value) {
                return false;
            }
            n2 = n2.next;
            n3 = n3.next;
        }

        //将右侧链表反转回来
        n3 = n1.next;
        n3.next = null;
        while (n3 != null) {
            n2 = n3.next;
            n3.next = n1;
            n1 = n3;
            n3 = n2;
        }
        return true;
    }

}
