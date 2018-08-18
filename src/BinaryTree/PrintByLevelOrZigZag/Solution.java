package BinaryTree.PrintByLevelOrZigZag;

import BinaryTree.Node.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的按层打印与ZigZag打印
 *
 * 给定一棵二叉树的头节点head，分别实现安层打印和ZigZag打印二叉树的函数。
 * 例如，二叉树：
 *
 *          1
 *       /     \
 *      2       3
 *     /       / \
 *    4       5   6
 *           / \
 *          7   8
 *
 * 按层打印时，输出格式必须如下：
 *  Level 1 : 1
 *  Level 2 : 2 3
 *  Level 3 : 4 5 6
 *  Level 4 : 7 8
 *
 * ZigZag打印时，输出格式必须如下：
 *  Level 1 from left to right: 1
 *  Level 2 from right to left: 3 2
 *  Level 3 from left to right: 4 5 6
 *  Level 4 from right to left: 8 7
 */
public class Solution {
    //按层打印
    public void printByLevel(Node head){
        if(head == null)
            return;
        int level = 1;
        Queue<Node> queue = new LinkedList<>();
        //last:上一层的最后一个节点
        Node last = head;
        //nlast:当前层的最后一个节点
        Node nlast = head;
        queue.offer(head);
        System.out.print("Level "+(level++)+" : ");
        while (!queue.isEmpty()){
            head = queue.poll();
            System.out.print(head.value+" ");
            if (head.left!=null) {
                queue.offer(head.left);
                nlast = head.left;
            }
            if (head.right!=null) {
                queue.offer(head.right);
                nlast = head.right;
            }
            if (head==last && !queue.isEmpty()){
                System.out.print("\n"+"Level "+(level++)+" : ");
                last =nlast;
            }
        }
    }

    //zigzag打印
    public void printByZigZag(Node head){
        if (head == null)
            return;
        //true：从左往右打印；false：从右往左打印
        boolean lr = true;
        int level = 1;
        //双端队列
        Deque<Node> deque = new LinkedList<>();
        Node last = head;
        Node nlast = null;
        deque.offerFirst(head);
        printLevel(level++,lr);
        while (!deque.isEmpty()){
            if (lr){
                head = deque.pollFirst();
                System.out.print(head.value+" ");
                if (head.left!=null){
                    nlast = nlast==null?head.left:nlast;
                    deque.offerLast(head.left);

                }
                if (head.right!=null){
                    nlast = nlast==null?head.right:nlast;
                    deque.offerLast(head.right);
                }
            }else {
                head = deque.pollLast();
                System.out.print(head.value+" ");
                if (head.right!=null){
                    nlast = nlast==null?head.right:nlast;
                    deque.offerFirst(head.right);

                }
                if (head.left!=null){
                    nlast = nlast==null?head.left:nlast;
                    deque.offerFirst(head.left);
                }
            }
            if (head == last && (!deque.isEmpty())){
                System.out.println();
                lr = !lr;
                last = nlast;
                nlast = null;
                printLevel(level++,lr);
            }
        }
    }

    public void printLevel(int level,boolean lr){
        System.out.print("Level "+level+" ");
        System.out.print(lr?"from left to right: ":"from right to left: ");
    }
}
