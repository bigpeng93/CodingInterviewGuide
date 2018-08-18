package LinkedQuestion.RemoveRep;

import LinkedQuestion.Node.Node;

import java.util.HashSet;

/**
 * 删除无序单链表中值重复出现的节点
 * <p>
 * 给定一个无序单链表的头节点head，删除其中值重复出现的节点
 * 例如：1->2->3->3->4->4->2->1->1->null，删除值重复的节点之后为1->2->3->4->null。
 * 请按照以下要求实现两种方法：
 * 方法一：如果链表长度为N，时间复杂度达到O(N)。
 * 方法二：额外空间复杂度为O(1)。
 */
public class Solution {
    //方法一：利用哈希表。时间复杂度为O(N)，额外空间复杂度为O(N)。
    public void removeRepOne(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        hashSet.add(pre.value);
        while (cur != null) {
            if (hashSet.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                hashSet.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    //类似选择排序的过程，时间复杂度为O(N^2)，额外空间复杂度为O(1)。
    public void removeRepTwo(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.value == next.value) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;

            }
            cur = cur.next;
        }
    }
}
