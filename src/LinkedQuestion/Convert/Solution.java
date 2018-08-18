package LinkedQuestion.Convert;

import LinkedQuestion.Node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将搜索二叉树转换为双向链表
 * <p>
 * 对于二叉树的节点来说，有本身的值域，有指向左孩子和右孩子的两个指针；
 * 对双向链表的节点来说，有本身的值域，有指向上一个节点和下一个节点的指针。
 * 在结构上，两种结构有相似性，现在有一颗搜索二叉树，请将其转换为一个有序的双向链表。
 */
public class Solution {
    //方法一：用队列等容器收集二叉树中序遍历结果的方法。
    //时间复杂度为O(N)，额外空间复杂度为O(N)。
    public TreeNode convertOne(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty())
            return null;
        head = queue.poll();
        TreeNode pre = head;
        pre.left = null;
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;

    }

    public void inOrderToQueue(TreeNode head, Queue<TreeNode> queue) {
        if (head == null) {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
    }

    //方法二：利用递归函数，除此之外不使用任何容器的方法。
    // 时间复杂度为O(N)，额外空间复杂度为O(h),h为二叉树的高度。
    public TreeNode convertTwo(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode last = process(head);
        head = last.right;
        last.right = null;
        return head;
    }

    public TreeNode process(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode leftE = process(head.left);
        TreeNode rightE = process(head.right);
        TreeNode leftS = leftE != null ? leftE.right : null;
        TreeNode rightS = rightE != null ? rightE.right : null;
        if (leftE != null && rightE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = rightS;
            rightS.left = head;
            rightE.right = leftS;
            return rightE;
        } else if (leftE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        } else if (rightE != null) {
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        } else {
            head.right = head;
            return head;
        }
    }
}
