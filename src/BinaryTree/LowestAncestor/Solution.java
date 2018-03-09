package BinaryTree.LowestAncestor;

import BinaryTree.Node.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 在二叉树中找到两个节点的最近公共祖先
 *
 * 给定一棵二叉树的头节点head，以及 这棵树中的两个节点o1和o2，请返回o1和o2的最近公共祖先节点。
 * 例如，二叉树：
 *
 *             1
 *         /       \
 *        2         3
 *      /   \     /   \
 *     4     5   6     7
 *                    /
 *                   8
 *
 * 节点4和节点5的最近公共祖先节点为节点2，节点5和节点2 的最近公共祖先节点为节点2，节点6和节点8的
 * 最近公共祖先节点为节点3，节点5和节点8的最近公共祖先节点为节点1。
 *
 */
public class Solution {
    //后序遍历
    public Node lowestAncestor(Node head,Node o1,Node o2){
        if (head== null || head==o1|| head == o2){
            return head;
        }
        Node left= lowestAncestor(head.left,o1,o2);
        Node right = lowestAncestor(head.right,o1,o2);
        if (left != null && right!=null){
            return head;
        }
        return left!=null?left:right;
    }

    //进阶：如果查询两个节点的最近公共祖先的操作十分频繁，想法让单条查询的查询时间减少。
    //结构一：建立二叉树汇总每个节点对应的父节点信息，是一张哈希表
    public Node lowestAncestorRecord(Node head,Node o1,Node o2){
        if (head == null || head == o1 || head== o2){
            return head;
        }
        Map<Node,Node> map = new HashMap<>();
        setMap(head,map);
        return query(o1,o2,map);

    }
    //迭代，将子节点和父节点插入map中，key为子节点，value为父节点
    public void setMap(Node head,Map map){
        if (head== null)
            return;
        if (head.left!=null){
            map.put(head.left,head);
        }
        if (head.right!= null){
            map.put(head.right,head);
        }
        setMap(head.left,map);
        setMap(head.right,map);
    }
    //建立一个set，将o1的父节点插入到set中，在set中查找o2的父节点。
    public Node query(Node o1,Node o2,Map map){
        Set<Node> set = new HashSet<>();
        while (map.containsKey(o1)){
            set.add(o1);
            o1 =(Node) map.get(o1);
        }
        while (!set.contains(o2)){
            o2 =(Node) map.get(o2);
        }
        return o2;

    }
    //结构二：直接建立任意两个节点之间的最近公共祖先记录，便于以后查询时直接查。
    public Node lowestAncestorRecordTwo(Node head,Node o1,Node o2){
        return null;
    }


    //再进阶：给定二叉树的头节点head，同时给定所有想要进行的查询。二叉树的节点数量为N，
    //查询条数为M，请在时间复杂度为O(N+M)内返回所有查询的结果。

}
