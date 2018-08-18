package BinaryTree.OrderRecur;

import BinaryTree.Node.Node;

import java.util.Stack;

/**
 * 分别用递归和非递归方式实现二叉树先序、中序和后序遍历
 * <p>
 * 用递归和非递归的方式，分别按照二叉树先序、中序和后序的打印所有的节点。
 * 我们约定：
 * 先序遍历顺序为根、左、右；
 * 中序遍历顺序为左、根、右；
 * 后序遍历顺序为左、右、根。
 */
public class Solution {
    //递归：先序遍历
    public void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //递归：中序遍历
    public void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    //递归：后序遍历
    public void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 非递归的方式
     * <p>
     * 用递归方法解决的问题都能用非递归的方法实现。这是因为递归方法无非就是利用函数栈来保存信息，
     * 如果用自己申请的数据结构来代替函数栈，也可以实现相同的功能。
     */

    //非递归：前序遍历
    public void preOrderUnRecur(Node head) {
        if (head == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null)
                stack.push(head.right);
            if (head.left != null)
                stack.push(head.left);
        }
    }

    //非递归：中序遍历
    public void inOrderUnRecur(Node head) {
        if (head == null)
            return;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }

    //非递归：后序遍历
    //方法一：使用两个stack
    public void posOrderUnRecurOne(Node head) {
        if (head == null)
            return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null)
                stack1.push(head.left);
            if (head.right != null)
                stack1.push(head.right);
        }
        while (!stack2.isEmpty())
            System.out.print(stack2.pop().value + " ");
    }

    //方法二：使用一个stack
    public void posOrderUnRecurTwo(Node head) {
        if (head == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node cur = null;
        stack.push(head);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            //head表示最近一次弹出并打印的节点
            //所以如果head等于cur的左节点（孩子）或者右节点（孩子），说明cur的左子树与右子树已经打印完毕，
            //此时不应该再将cur的左节点放入stack中。
            if (cur.left != null && head != cur.left && head != cur.right) {
                stack.push(cur.left);
                cur = cur.left;
            } else if (cur.right != null && head != cur.right) {
                stack.push(cur.right);
            } else {
                System.out.print(stack.pop().value + " ");
                head = cur;
            }
        }

    }
}
