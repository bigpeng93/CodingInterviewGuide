package BinaryTree.GetNextNode;

import BinaryTree.Node.NewNode;
import BinaryTree.Node.Node;

/**
 * 在二叉树中找到一个节点的后继节点
 * <p>
 * 现在有一种新的二叉树节点类型NewNode,该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
 * 假设有一棵NewNode类型的节点组成的二叉树，树中每个节点的parent指针都正确地指向自己的父节点，
 * 头节点的parent指向null。只给一个在二叉树中的某个节点，请实现返回该节点的后继节点函数。
 * 在二叉树的中序遍历的序列中，node的下一个节点叫做node的后继节点。
 * <p>
 * 6
 * /         \
 * 3            9
 * /   \       /     \
 * 1     4     8      10
 * \     \   /
 * 2     5 7
 * <p>
 * 中序遍历的结果为：1,2,3,4,5,6,7,8,9,10
 * 所以节点1的后继节点2，节点2的后继节点3，......，节点10的后继为null。
 */
public class Solution {
    public NewNode getNextNode(NewNode node) {
        if (node == null)
            return null;
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            NewNode par = node.parent;
            while (par != null && par.left != node) {
                par = par.parent;
            }
            return par;
        }
    }

    public NewNode getLeftMost(NewNode node) {
        if (node == null)
            return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
