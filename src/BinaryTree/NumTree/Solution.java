package BinaryTree.NumTree;

/**
 * 统计和生成所有不同的二叉树
 * <p>
 * 给定一个整数N，如果N<1，代表空树结构，否则代表中序遍历的结果为{1,2,3,...,N}。
 * 请返回可能的二叉树结构有多少。
 * 例如，N=-1，代表空树结构，返回1；N=2,时，满足中序遍历为{1,2}的二叉树结构只有下图所示的
 * 两种，所以返回结果为2。
 * 1                        2
 * /   \                    /   \
 * null   2                 null   1
 * /   \                    /   \
 * null  null               null  null
 */
public class Solution {
    //动态规划问题
    public int numTree(int n) {
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }

    //进阶：N的含义不变，假设可能的二叉树结构有N种，请返回M个二叉树的头节点，
    //每一棵二叉树代表一种可能的结构。
}
