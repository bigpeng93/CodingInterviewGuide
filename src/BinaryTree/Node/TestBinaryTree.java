package BinaryTree.Node;

import java.util.HashMap;
import java.util.HashSet;

public class TestBinaryTree {
    /**
     * 默认测试二叉树中没有数值重复的节点(实际情况很少出现数值重复的节点)，
     * 同时数值均大于0。所以如果二维数组中出现-1值，说明该处节点为null。
     *
     * @param nums  用于创建二叉树的二维数组
     * @return  返回二叉树的根节点
     */
    public static Node makeBinaryNode(int[][] nums){
        if (nums == null)
            return null;
        Node head = new Node(nums[0][0]);
        int len = nums.length;
        HashMap<Integer,Node> map = new HashMap<>();
        map.put(nums[0][0],head);
        for (int i=1;i<len;i++){
            int j = 0;
            while (j<nums[i].length){
                int cur = 0;
                while (cur<nums[i-1].length) {
                    //如果前一行节点中出现-1，则代表为null节点，则将指针指向下一个不是-1的节点。
                    if(nums[i-1][cur]==-1){
                        cur++;
                        continue;
                    }
                    //创建left节点
                    if (nums[i][j]==-1) {
                        map.get(nums[i-1][cur]).left = null;
                        j++;
                    }else{
                        Node temp = new Node(nums[i][j]);
                        map.get(nums[i-1][cur]).left = temp;
                        map.put(nums[i][j],temp);
                        j++;
                    }
                    //创建right节点
                    if (nums[i][j]==-1) {
                        map.get(nums[i-1][cur]).right = null;
                        j++;
                    }else{
                        Node temp = new Node(nums[i][j]);
                        map.get(nums[i-1][cur]).right = temp;
                        map.put(nums[i][j],temp);
                        j++;
                    }
                    cur++;
                }
            }
        }
        return head;
    }
}
