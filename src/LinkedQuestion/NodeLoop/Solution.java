package LinkedQuestion.NodeLoop;

import LinkedQuestion.Node.Node;

/**
 * 两个单链表相交的一系列问题
 *
 * 在本题中，单链表可能有环，也可能无环。给定两个单链表的头节点head1和head2，
 * 这两个链表可能相交，也可能不相交。请实现一个函数，如果两个链表相交，请返回相交的第一个节点；
 * 如果不相交，返回null即可。
 * 要求：
 *  如果链表1的长度为N，链表2的长度为M，时间复杂度请达到O(N+M)，额外空间复杂度请达到O(1)。
 */
public class Solution {
    /**
     * 问题一：如何判断一个链表是否有环，如果有，则返回第一个进入环的节点，没有则返回null。
     */
    public Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2){
            if(n2.next == null || n2.next.next == null){
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    /**
     * 问题二：如何判断两个无环链表是否相交，相交则返回第一个相交节点，不相交则返回null。
     */
    public Node noLoop(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1!=null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2!=null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2)
            return null;
        cur1 = head1;
        cur2 = head2;
        if(n>0){
            while (n!=0){
                n--;
                cur1 = cur1.next;
            }
        }else {
            while (n!=0){
                n++;
                cur2 = cur2.next;
            }
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 问题三：如何判断两个有环链表是否相交，相交则返回第一个相交节点，不相交则返回null。
     */
    public Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            int n = 0;
            cur1 = head1;
            cur2 = head2;
            while (cur1!=loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2!=loop2){
                n--;
                cur2 = cur2.next;
            }
            if(cur1 != cur2)
                return null;
            cur1 = head1;
            cur2 = head2;
            if(n>0){
                while (n!=0){
                    n--;
                    cur1 = cur1.next;
                }
            }else {
                while (n!=0){
                    n++;
                    cur2 = cur2.next;
                }
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
            while (cur1 != loop1){
                if(cur1 == loop2)
                    return loop1;
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public Node getIntersectNode(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }
        if(loop1 != null && loop2 != null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }

}
