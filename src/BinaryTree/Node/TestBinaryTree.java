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

                    if(j>=nums[i].length){
                        break;
                    }
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

    public static void printTree(Node head){
        printInOrder(head,0,"H",17);
    }

    /**
     * 递归打印节点
     *
     * len长度的取值：
     *  在java中，整型值占用长度最长的值是Integer.MIN_VALUE(即-2147483648)，
     *  占用长度为11，加上前缀和后缀("H"、"v"或"^")之后占用长度为13。为了在打印
     *  之后更好地区分，再把前面加上两个空格，后面加上两个空格，总共占用长度为17.
     *  也就是说长度为17的空间必然可以放下任何一个32位整数。
     *
     * @param head      进入递归的根节点
     * @param height    记录二叉树的层数
     * @param to        标志根节点或左右节点,"H"为根节点、"V"为右节点、"^"为左节点
     * @param len       打印一个节点所占用的长度
     */

    private static void printInOrder(Node head,int height,String to,int len){
        if(head == null)
            return;

        printInOrder(head.right,height+1,"v",len);
        String val = to + head.value + to;
        int lenM = val.length();        //计算加上前缀和后缀之后的值的长度
        int lenL = (len-lenM)/2;        //计算左侧空格的长度
        int lenR = len-lenL-lenM;       //计算右侧空格的长度
        val = getSpace(lenL)+val+getSpace(lenR);
        System.out.println(getSpace(height*len) + val);
        printInOrder(head.left,height+1,"^",len);
    }

    /**
     * 获取空格的字符串
     * @param num   空格的长度
     * @return
     */
    private static String getSpace(int num){
        String space = " ";
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        while (i++ < num){
            buffer.append(" ");
        }
        return buffer.toString();
    }

}
