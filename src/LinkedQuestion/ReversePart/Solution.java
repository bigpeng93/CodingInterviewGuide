package LinkedQuestion.ReversePart;

import LinkedQuestion.Node.Node;

/**
 * 反转部分单项链表
 *
 * 给定一个单向链表的头结点head，以及两个整数from和to，在单项链表上把第from个节点到to个节点这一部分进行反转。
 * 例如：
 *  1->2->3->4->5->null，from=2，to=4
 *  调整结果为:1->4->3->2->5->null
 *  再入：
 *  1->2->3->null，from=1，to=3
 *  调整结果为:3->2->1->null
 */
public class Solution {
    public Node reversePart(Node head,int from,int to){
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node fPos = null;

        while(node1 != null){
            len ++;
            fPre = len == from-1 ? node1 : fPre;
            fPos = len == to+1 ? node1 : fPos;
            node1 = node1.next;
        }
        if(from > to || from < 1 || to > len)
            return head;
        node1 = fPre == null ?head:fPre.next;
        Node node2 = node1.next;
        node1.next = fPos;
        Node next= null;
        while (node2 != fPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(fPre != null){
            fPre.next = node1;
            return head;
        }
        return node1;
    }

    public Node reversePartTwo(Node head,int from,int to){
        if(head == null) return null;
        Node first = new Node(0);
        first.next = head;
        Node pre = first;
        for(int i =0;i<from-1;i++)
            pre = pre.next;
        Node start = pre.next;
        Node then = start.next;

        for(int i = 0; i < to-from;i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return first.next;
    }

}
