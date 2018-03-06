package LinkedQuestion.JosephusKill;

import LinkedQuestion.Node.Node;

/**
 * 环形单链表的约瑟夫问题
 *
 * 据说著名的犹太历史学家Josephus有过以下故事：在罗马人占领桥塔帕特后，
 * 39个犹太人与Josephus 及他的朋友躲到一个洞中，39个犹太人宁愿死也不要被敌人抓到，
 * 于是决定了一个自杀方式，41个人排成一个圆圈，由第一个人开始报数，报数到3的人就自杀，
 * 然后再有下一个人重新报1，报数到3的人再自杀。这样依次下去，直到剩下最后一个人时，
 * 那个人可以自由选择自己的命运。这就是著名的约瑟夫问题。
 * 现在请用单向环形链表描述该结构并呈现整个自杀过程。
 * 输入：一个环形单向链表的头节点head 和报数的值m。
 * 返回：最后生存下来的节点，且这个节点自己组成环形单向链表，其他节点都删掉。
 */
public class Solution {
    public Node josephusKillOne(Node head,int m){
        if(head == null|| head.next == head || m<1){
            return head;
        }
        Node last = head;
        while (last.next != head){
            last = last.next;
        }
        int count = 0;
        while (head != last){
            if(++count == m){
                System.out.println(last.next.value);
                last.next = head.next;
                count = 0;
            }else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    /**
     * 进阶：
     *  如果链表节点数为N，想在时间复杂度为O(N)时完成原问题的要求。
     */
    public Node josephusKillTwo(Node head,int m){
       if(head == null || head.next == head || m<1){
           return head;
       }
       Node cur = head.next;
       int tmp = 1;
       while (cur != head){
           tmp++;
           cur = cur.next;
       }
       tmp = getLive(tmp,m);
       while (--tmp != 0){
           head = head.next;
       }
       head.next = head;
       return head;
    }
    private int getLive(int i,int m){
        if(i==1){
            return 1;
        }
        return (getLive(i-1,m)+m-1) % i + 1;
    }
}
