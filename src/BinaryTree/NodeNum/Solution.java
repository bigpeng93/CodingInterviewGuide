package BinaryTree.NodeNum;

import BinaryTree.Node.Node;

/**
 * 统计完全二叉树的节点数
 * <p>
 * 给定一棵完全二叉树的头节点head，返回这棵树的节点个数
 * <p>
 * 如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
 */
public class Solution {
    public int nodeNum(Node head) {
        if (head == null)
            return 0;
        return bs(head, 1, getMostLeftLevel(head, 1));
    }

    public int bs(Node head, int level, int h) {
        if (level == h)
            return 1;
        if (getMostLeftLevel(head.right, level + 1) == h) {
            return (1 << (h - level)) + bs(head.right, level + 1, h);
        } else {
            return (1 << (h - level - 1)) + bs(head.left, level + 1, h);
        }

    }

    public int getMostLeftLevel(Node head, int i) {
        if (head == null)
            return 0;
        while (head != null) {
            i++;
            head = head.left;
        }
        return i - 1;
    }
}
