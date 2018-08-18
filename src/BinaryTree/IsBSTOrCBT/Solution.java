package BinaryTree.IsBSTOrCBT;

import BinaryTree.Node.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断一棵二叉树是否为搜索二叉树和完全二叉树
 * <p>
 * 给定一个二叉树的头节点head，已知其中没有重复的节点，实现两个函数分别判断这棵二叉树是否是
 * 搜索二叉树和完全二叉树。
 * 搜索二叉树：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 它的左、右子树也分别为二叉排序树。
 * 完全二叉树：若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
 * 第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
 */
public class Solution {
    //中序遍历
    public boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && pre.value > head.value)
                    return false;
                pre = head;
                head = head.right;
            }
        }
        return true;

    }

    //层遍历
    public boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left == null && head.right != null)
                return false;
            if (leaf && (head.right != null || head.left != null))
                return false;
            if (head.left != null)
                queue.offer(head.left);
            if (head.right != null)
                queue.offer(head.right);
            else {
                leaf = true;
            }

        }
        return true;
    }

}
