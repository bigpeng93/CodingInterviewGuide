package LinkedQuestion.AddList;

import LinkedQuestion.Node.Node;
import java.util.Stack;

/**
 * 两个单链表生成相加链表
 *
 * 假设链表中每一个节点的值都在0~9之间，那么链表整体就可以代表一个整数。
 * 例如：9->3->7，可以代表整数937.
 * 给定两个这种链表的头节点head1和head2，请生成代表两个整数相加值的结果链表。
 * 例如：
 *  链表1为9->3->7，链表2为6->3，最后生成新的结果链表为1->0->0->0。
 */
public class Solution {
    //用栈结构求解
    public Node addListOne(Node head1,Node head2){
        if(head1 ==null && head2 == null){
            return null;
        }
        //将两个链表的值入栈
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head1 != null){
            stack1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null){
            stack2.push(head2.value);
            head2 = head2.next;
        }

        //将出栈，并进行计算，同时连接成新的链表
        int n1 = 0;
        int n2 = 0;
        int cur= 0;
        int n = 0;
        Node node = null;
        Node pre = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            n1 = stack1.isEmpty() ? 0:stack1.pop();
            n2 = stack2.isEmpty() ? 0:stack2.pop();
            n = n1 + n2 + cur;
            pre = node;
            node = new Node(n%10);
            node.next = pre;
            cur = n/10;
        }
        //判断进位
        if(cur == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

    //利用链表的逆序求解，可以省掉用栈的空间
    public Node addListTwo(Node head1,Node head2){
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        int cur = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node c1 = head1;
        Node c2 = head2;
        Node node = null;
        Node pre = null;
        while (c1!=null || c2 != null){
            n1 = c1==null ? 0:c1.value;
            n2 = c2==null ? 0:c2.value;
            n = n1 + n2 + cur;
            pre = node;
            node = new Node(n%10);
            node.next= pre;
            c1 = c1.next;
            c2 = c2.next;
            cur = n/10;
        }
        return node;
    }

    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
