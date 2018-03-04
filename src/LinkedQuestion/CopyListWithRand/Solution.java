package LinkedQuestion.CopyListWithRand;

import LinkedQuestion.Node.NodeSpe;

import java.util.HashMap;

/**
 * 复制含有随机指针节点的链表
 *
 * 一种特殊的链表节点类NodeSpe
 *
 * Node类中的value是节点值，next指针和正常单链表中next 指针的意义一样，都指向下一个节点，
 * rand指针是Node类中新增的指针，这个指针可能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个函数完成这个链表中所有结构的复制，
 * 并返回复制的新链表的头节点。
 * 例如：链表1->2->3->null，假设1的rand指针指向3，2的rand指针指向null，3的rand指针指向1。
 * 复制后的链表应该也是这种结构，比如，1'->2'->3'->null，1'的rand指针指向3'，
 * 2'的rand指针指向null，3的 rand 指针指向 1，最后返回 1。
 */

public class Solution {
    public NodeSpe copyListWithRandOne(NodeSpe head){
        HashMap<NodeSpe,NodeSpe> map = new HashMap<>();
        NodeSpe cur = head;
        while (cur != null){
            map.put(cur,new NodeSpe(cur.value));
            cur = (NodeSpe)cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = (NodeSpe)cur.next;
        }
        return map.get(head);
    }

    /**
     * 进阶：不使用额外的数据结构，只用有限几个变量，且在时间复杂度为O(N)内完成原问题要实现的函数。
     */
    public NodeSpe copyListWithRandTwo(NodeSpe head){
        if(head == null)
            return null;
        //复制链表，将节点与副本节点串联起来为：1->1'->2->2'->3->3'->...
        NodeSpe cur = head;
        NodeSpe next = null;
        while (cur != null){
            next = (NodeSpe)cur.next;
            cur.next = new NodeSpe(cur.value);
            cur.next.next = next;
            cur = next;
        }
        //复制节点的rand指针
        cur = head;
        NodeSpe curCopy = null;
        while(cur != null){
            next = (NodeSpe)cur.next.next;
            curCopy = (NodeSpe)cur.next;
            curCopy.rand = cur.rand== null ? null:cur.rand.next;
            cur = next;
        }
        //拆分
        NodeSpe res = (NodeSpe)head.next;
        cur = head;
        while (cur != null){
            next = (NodeSpe) cur.next.next;
            curCopy = (NodeSpe) cur.next;
            cur.next = (NodeSpe) next;
            curCopy.next = next == null? null : ((NodeSpe) next).next;
            cur = next;
        }
        return res;
    }
}
