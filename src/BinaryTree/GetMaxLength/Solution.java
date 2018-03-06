package BinaryTree.GetMaxLength;

import BinaryTree.Node.Node;

import java.util.HashMap;
import java.util.jar.JarEntry;

/**
 * 在二叉树中找到累加和为指定值的最长路径长度
 *
 * 给定一颗二叉树的头节点head和一个32位整数sum，二叉树节点值类型为整型，
 * 求累加和为sum的最长路径长度。路径是指从某个节点往下，每次最多选择一个孩子节点或者不选所
 * 形成的节点链。
 * 例如，二叉树：
 *              -3
 *            /     \
 *          3         -9
 *        /   \      /   \
 *       1     0    2     1
 *            / \
 *           1   6
 * 如果sum=6，那么累加和为6的最长路径为：-3、3、0、6，所以返回4；
 * 如果sum=-9，那么累加和为-9的最长路径为：-9，所以返回1。
 * 注：本题不考虑节点值相加可能溢出的情况
 */
public class Solution {
    public int getMaxLength(Node head,int sum){
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,0);
        return preOrder(head,sum,0,1,0,sumMap);
    }

    public int preOrder(Node head, int sum, int preSum, int level,
                        int maxLen, HashMap<Integer,Integer> sumMap){
        if (head == null)
            return maxLen;
        int curSum = preSum + head.value;
        if(!sumMap.containsKey(curSum)){
            sumMap.put(curSum,level);
        }
        if (sumMap.containsKey(curSum-sum)){
            maxLen = Math.max(maxLen,level-sumMap.get(curSum-sum));
        }
        maxLen = preOrder(head.left,sum,curSum,level+1,maxLen,sumMap);
        maxLen = preOrder(head.right,sum,curSum,level+1,maxLen,sumMap);
        if(level == sumMap.get(curSum))
            sumMap.remove(curSum);
        return maxLen;
    }
}
