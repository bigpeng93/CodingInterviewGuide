package BinaryTree.Contains;

import BinaryTree.Node.Node;

/**
 * 判断t1树是否包含t2树全部的拓扑结构
 * <p>
 * 给定彼此独立的两棵树头节点分别为t1和t2，判断t1树是否包含t2树全部的拓扑结构，
 * 例如，
 * t1树：
 * 1
 * /       \
 * 2         3
 * /   \     /   \
 * 4     5   6     7
 * / \   /
 * 8   9 10
 * <p>
 * t2树：
 * 2
 * /   \
 * 4     5
 * /
 * 8
 * <p>
 * t1树包含t2树全部的拓扑结构，所以返回true。
 */
public class Solution {
    public boolean contains(Node t1, Node t2) {
        if (t1 == null) {
            return false;
        }
        return check(t1, t2) || contains(t1.right, t2) || contains(t1.left, t2);
    }

    public boolean check(Node h, Node t2) {
        if (t2 == null) {
            return true;
        }
        if (h == null || h.value != t2.value) {
            return false;
        }
        return check(h.left, t2.left) && check(h.right, t2.right);
    }

}
