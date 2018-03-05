package LinkedQuestion.RemoveNodeWired;

import LinkedQuestion.Node.Node;

/**
 * 一种怪异的节点删除方式
 *
 * 链表节点值类型为int型，给定一个链表中的节点node，但不给定整个链表的头节点。
 * 如何在链表中删除node？请实现一个函数，并分析这么会出现哪些问题。
 * 要求：时间复杂度为O(1)。
 *
 * 例如：
 *  链表1->2->3->null，只知道要删除节点2，而不知道头节点。那么只需把节点2的
 *  值变成3的值，在链表中删除节点3即可。
 *
 * 问题一：这样的删除方式无法删除最后一个节点。
 *      不可以将最后一个节点变成null，null在系统中指向一个特定的区域，
 *      如果想让上一个节点的next指针指向null，必须找到上一个节点。
 * 问题二：这种删除方式在本质上根本就不是删除了node节点，而是把node节点的值改变，
 * 然后删除node的下一个节点。
 *      比如，工程上的一个节点可能代表很复杂的结构，节点值的复制会相当复杂，
 *      或者可能改变节点值这个操作都是被禁止的；
 *      再如，工程上一个节点代表提供服务的一个服务器，外界对每个节点都有很多依赖，
 *      比如，在示例中删除节点2时，其实影响了节点3对外提供的服务
 */
public class Solution {
    public void removeNodeWired(Node node){
        if(node == null){
            return;
        }
        Node next = node.next;
        if(next == null){
            throw new RuntimeException("不能删除最后一个节点");
        }
        node.value = next.value;
        node.next = next.next;
    }
}
