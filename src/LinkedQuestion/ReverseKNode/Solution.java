package LinkedQuestion.ReverseKNode;

import LinkedQuestion.Node.Node;

import java.util.Stack;

/**
 * 给定一个单链表的头节点head，实现一个调整单链表的函数，使得每K个节点之间逆序，
 * 如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如：
 *  链表：1->2->3->4->5->6->7->8->null，K=3.
 *  调整后为：3->2->1->6->5->4->7->8->null。其中7、8不调整，因为 不够一组。
 */
public class Solution {
    //利用栈结构解决
    public Node reverseKthNodeOne(Node head,int k){
        if(k<2){
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node preHead = new Node(0);
        preHead.next = head;
        Node cur = head;
        Node pre = preHead;
        Node newHead = head;
        Node next = null;

        while (cur != null){
            stack.push(cur);
            next = cur.next;
            if(stack.size() == k){
                pre = reversrOne(stack,pre,next);
                newHead = newHead==head?cur:newHead;
            }
            cur = next;
        }
        return newHead;
    }

    public Node reversrOne(Stack<Node> stack,Node pre,Node next){
        Node temp = stack.pop();
        pre.next = temp;
        while (!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = next;
        pre = temp;
        return pre;
    }


    /**
     * 不需要栈结构，在原链表中直接调整
     */

    //大bug

/*    public Node reverseKthNodeTwo(Node head,int K){
        if(K<2){
            return head;
        }
        Node preHead = new Node(0);
        preHead.next = head;
        Node first= head;
        Node pre = preHead;
        Node last = head;
        Node newHead = head;
        Node next = null;
        int count = 1;
        while (last != null){
            next = last.next;
            if(count == K){
                first = pre.next;
                pre = reverseTwo(pre,first,last,next);
                newHead = newHead==head ? pre:newHead;
                System.out.println(newHead.value);
                count = 0;
            }
            count ++;
            last = next;
        }
        return newHead;

    }

    public Node reverseTwo(Node pre,Node first,Node last,Node next){
        Node temp = null;
        Node cur = first;
        while (next != last){
            temp = first.next;
            first.next = next;
            next = first;
            first = temp;
        }
        pre.next = next;
        pre = cur;
        next = last.next;
        return pre;
    }*/
}
