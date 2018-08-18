package BinaryTree.ToTree;

import BinaryTree.Node.Node;

/**
 * 先序、中序和后序数组两两结合重构二叉树
 * <p>
 * 已知一棵二叉树的所有节点值都不同，给定这棵二叉树正确的先序、中序和后序数组。
 * 请分别用三个函数实现任意两种数组结合重构原来的二叉树，并返回重构二叉树的头节点。
 */
public class Solution {

    /**
     * 先序和中序结合重构二叉树
     *
     * @param pre 先序数组
     * @param in  中序数组
     * @return 返回二叉树的根节点
     */
    public Node preInToTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        return preInmakeTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public Node preInmakeTree(int[] pre, int pref, int prel, int[] in, int inf, int inl) {
        if (pref > prel || inf > inl)
            return null;
        Node head = new Node(pre[pref]);
        int i = inf;
        for (; i <= inl; i++) {
            if (in[i] == pre[pref]) {
                break;
            }
        }
        head.left = preInmakeTree(pre, pref + 1, pref + (i - inf), in, inf, i);
        head.right = preInmakeTree(pre, pref + (i - inf) + 1, prel, in, i + 1, inl);
        return head;
    }

    /**
     * 先序和后序结合重构二叉树
     *
     * @param pos 后序数组
     * @param in  中序数组
     * @return 返回二叉树的根节点
     */
    public Node inPosToTree(int[] pos, int[] in) {
        if (pos == null || in == null) {
            return null;
        }
        return inPosMakeTree(pos, 0, pos.length - 1, in, 0, in.length - 1);

    }

    public Node inPosMakeTree(int[] pos, int posf, int posl, int[] in, int inf, int inl) {
        if (posf > posl || inf > inl)
            return null;
        Node head = new Node(pos[posl]);
        int i = inf;
        for (; i <= inl; i++) {
            if (in[i] == pos[posl]) {
                break;
            }
        }
        head.left = inPosMakeTree(pos, posf, posf + (i - inf) - 1, in, inf, i - 1);
        head.right = inPosMakeTree(pos, posf + (i - inf), posl - 1, in, i + 1, inl);
        return head;
    }

    public Node prePosToTree(int[] pre, int[] pos) {
        return null;
    }

}
