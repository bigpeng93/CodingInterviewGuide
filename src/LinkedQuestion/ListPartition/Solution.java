package LinkedQuestion.ListPartition;

import LinkedQuestion.Node.Node;

import java.util.TreeSet;

/**
 * 将单项链表按某值划分成左边小、中间相等、右边大的形状
 * <p>
 * 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个整数pivot。
 * 实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的节点，
 * 中间部分都是值等于pivot的节点，右部分都是值大于pivot的节点。
 * 除这个要求外，对调整后的节点顺序没有更多的要求。
 * 例如：链表9->0->4->5->1，pivot=3.
 * 调整后的链表可以是1->0->4->9->5，也可以是0->1->9->5->4。
 * 总之，满足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部分为空），
 * 右部分都是大于3的节点即可。对某部分内部的节点顺序不做要求。
 */
public class Solution {
    public Node listPartitionOne(Node head, int pivot) {
        if (head == null || head.next == null)
            return head;
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] arr = new Node[i];
        cur = head;
        i = 0;
        while (cur != null) {
            arr[i] = cur;
            i++;
            cur = cur.next;
        }
        arrPatition(arr, pivot);
        for (i = 1; i < arr.length; i++) {
            arr[i - 1].next = arr[i];
        }
        arr[i - 1].next = null;
        return arr[0];

    }

    private void arrPatition(Node[] NodeArr, int pivot) {
        int small = -1;
        int big = NodeArr.length;
        int index = 0;
        while (index < big) {
            if (NodeArr[index].value < pivot) {
                swap(NodeArr, index++, ++small);
            } else if (NodeArr[index].value > pivot) {
                swap(NodeArr, index, --big);
            } else {
                index++;
            }
        }
    }

    private void swap(Node[] NodeArr, int m, int n) {
        Node temp = NodeArr[m];
        NodeArr[m] = NodeArr[n];
        NodeArr[n] = temp;
    }


    /**
     * 进阶：
     * 在原问题的要求上再增加如下两个要求：
     * ~ 在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左到右的顺序
     * 与原链表中节点的先后次序一致。
     * 例如：链表9->0->4->5->1，pivot=3。调整后的链表是0->1->9->4->5。在满足原问题要求的同时，
     * 左部分节点从左到右为0、1。在原链表中也是先出现0，后出现1；中间部分在本例中为空，不再讨论；
     * 右部分节点从左到右为9、4、5。在原链表中也是先出现9。然后出现4，最后出现5。
     * ~ 如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
     */

    public Node listPartitionTwo(Node head, int pivot) {
        Node sH = null;     //小链表的头部
        Node sT = null;     //小链表的尾部
        Node iH = null;     //相等链表的头部
        Node iT = null;     //相等链表的尾部
        Node bH = null;     //大链表的头部
        Node bT = null;     //大链表的尾部
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (iH == null) {
                    iH = head;
                    iT = head;
                } else {
                    iT.next = head;
                    iT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        //将三个链表连成一个链表，注意有的链表为null的情况
        if (sT != null) {
            sT.next = iH;
            iT = iT == null ? sT : iT;
        }
        if (iT != null) {
            iT.next = bH;
        }
        return sH != null ? sH : iH != null ? iH : bH;
    }
}

