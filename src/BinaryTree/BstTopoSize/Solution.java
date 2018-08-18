package BinaryTree.BstTopoSize;

import BinaryTree.Node.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到二叉树中符合搜索二叉树条件的最大拓扑结构
 * <p>
 * 给定一棵二叉树的头节点head，已知所有节点的值都不一样，
 * 返回其中最大且符合搜索二叉树条件的最大拓扑结构的大小。
 * <p>
 * 6
 * /         \
 * 1           12
 * /   \      /      \
 * 0     3    10      13
 * /  \    /  \
 * 4    14 20  16
 * / \   / \
 * 2   5 11 15
 * <p>
 * 其中最大的且符合搜索二叉树条件的最大拓扑结构
 * <p>
 * 6
 * /         \
 * 1           12
 * /   \      /      \
 * 0     3    10      13
 * \
 * 16
 */
public class Solution {
    //方法一：二叉树的节点数为N，时间复杂度为O(N^2)的方法
    public int BstTopoSizeOne(Node head) {
        if (head == null)
            return 0;
        int max = maxTopo(head, head);
        max = Math.max(BstTopoSizeOne(head.left), max);
        max = Math.max(BstTopoSizeOne(head.right), max);
        return max;
    }

    /**
     * 递归，求最大子树的数量
     *
     * @param m 当前子树的根节点
     * @param n 当前子树的子节点
     * @return
     */
    public int maxTopo(Node m, Node n) {
        if (m != null && n != null && isBSTNode(m, n))
            return maxTopo(m, n.left) + maxTopo(m, n.right) + 1;
        return 0;
    }

    /**
     * 递归，判断是不是子树中的节点
     *
     * @param m 子树中的节点
     * @param n 要查找的节点
     * @return
     */
    public boolean isBSTNode(Node m, Node n) {
        if (m == null)
            return false;
        if (m == n) {
            return true;
        }
        return isBSTNode(m.value > n.value ? m.left : m.right, n);
    }

    //方法二：二叉树的节点数为N，时间复杂度最好为O(N)，最差为O(NlogN)的方法。
    public int BstTopoSizeTwo(Node head) {
        Map<Node, Record> map = new HashMap<>();
        return posOrder(head, map);
    }


    /**
     * 采用后序遍历的方式求拓扑贡献记录
     *
     * @param head 子树的根节点
     * @param map  拓扑贡献记录
     * @return 返回最大贡献值
     */
    public int posOrder(Node head, Map<Node, Record> map) {
        if (head == null)
            return 0;
        int ls = posOrder(head.left, map);
        int rs = posOrder(head.right, map);

        modifyMap(head.left, head.value, map, true);
        modifyMap(head.right, head.value, map, false);

        Record lr = map.get(head.left);     //左子树的拓扑记录
        Record rr = map.get(head.right);    //右子树的拓扑记录

        //计算当前子树的拓扑记录
        int lbst = lr == null ? 0 : lr.l + lr.r + 1;
        int rbst = rr == null ? 0 : rr.l + rr.r + 1;
        map.put(head, new Record(lbst, rbst));

        return Math.max(lbst + rbst + 1, Math.max(ls, rs));
    }


    /**
     * 递归，向上转换根节点后，调整拓扑贡献值
     *
     * @param node  当前子树
     * @param value 整个树的根节点的值
     * @param map
     * @param s     标记左右子节点，左节点为true，右节点为false
     * @return 返回要减去的贡献值
     */
    public int modifyMap(Node node, int value, Map<Node, Record> map, boolean s) {
        if (node == null || (!map.containsKey(node)))
            return 0;
        Record r = map.get(node);

        // 如果在左子树中，右节点(当前节点)的值比根节点的值大，
        // 则从map中删除该节点，并返回当前节点作为子树根节点的最大贡献值
        // 如果在右子树中，左节点(当前节点)的值比根节点的值小，
        // 则从map中删除该节点，并返回当前节点作为子树根节点的最大贡献值
        if ((s && node.value > value) || ((!s) && node.value < value)) {
            map.remove(node);
            return r.r + r.l + 1;
        } else {
            int minus = modifyMap(s ? node.right : node.left, value, map, s);
            if (s) {
                r.r = r.r - minus;
            } else
                r.l = r.l - minus;
            map.put(node, r);
            return minus;
        }
    }

    /**
     * 拓扑贡献记录
     * 每个节点旁边都有被括号括起来的两个值，第一个值代表节点的左子树可以为当前头节点的拓扑贡献几个节点，
     * 第二个值代表节点的右子树可以为当前节点的拓扑贡献的几个节点。
     * 10(3,3)
     * /               \
     * 4(1,1)           14(1,1)
     * /      \         /       \
     * 2(0,0)  5(0,0)   11(0,0)  15(0,0)
     * <p>
     * <p>
     * 13(0,1)
     * /      \
     * 20(0,0)  16(0,0)
     */

    public class Record {
        public int l;
        public int r;

        public Record(int left, int right) {
            this.l = left;
            this.r = right;
        }
    }
}
