package BinaryTree.PrintEdge;

import BinaryTree.Node.Node;
import org.omg.CORBA.NO_IMPLEMENT;

/**
 * 打印二叉树的边界节点
 *
 * 给定一个二叉树的头节点head，按照如下两种标准分别实现二叉树边界节点的逆时针打印。
 * 标准一：
 *  1、头节点为边界节点。
 *  2、叶节点为边界节点。
 *  3、如果节点在其所在的层中是最左或最右的，那么也是边界节点。
 * 标准二：
 *  1、头节点为边界节点。
 *  2、叶节点为边界节点。
 *  3、树左边界延伸下去的路径为边界节点。
 *  4、树右边界延伸下去的路径为边界节点。
 *
 *  例如：
 *                     ____1____
 *                ____/         \____
 *               2                   3
 *              / \                 / \
 *             4   5               6   7
 *                / \             / \
 *               8   9          10  11
 *                    \         /
 *                     12     13
 *                    /  \   /  \
 *                   14  15 16  17
 *  按标准一的打印结果为：1,2,4,8,12,14,15,16,17,13,11,7,3;
 *  按标准二的打印结果为：1,2,4,8,14,15,16,17,11,7,3;
 *
 */
public class Solution {
    //标准一
    public void printEdgeOne(Node head){
        if(head == null)
            return;
        int height = getHeight(head,0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head,0,edgeMap);
        //打印左边界
        int i = 0;
        while (i<height){
            System.out.print(edgeMap[i++][0].value+" ");
        }
        //打印最底层的边界
        printLeafNotInMap(head,0,edgeMap);
        //打印最右层的边界
        while (--i>=0){
            if (edgeMap[i][0] != edgeMap[i][1])
                System.out.print(edgeMap[i][1].value+" ");
        }

    }


    /**
     * 得到二叉树的深度
     * @param head  二叉树的根节点
     * @param l     当前进入递归的二叉树的层数
     * @return
     */
    public int getHeight(Node head ,int l){
        if(head == null){
            return l;
        }
        return Math.max(getHeight(head.left,l+1),getHeight(head.right,l+1));
    }

    /**
     * 将每一层的最左节点和最右节点存入数组
     * @param head      二叉树的根节点
     * @param m         当前进入递归的二叉树的层数
     * @param edgeMap   用于存储最左和最右节点的Node数组
     */
    public void setEdgeMap(Node head,int m,Node[][] edgeMap){
        if (head == null)
            return;
        edgeMap[m][0] = edgeMap[m][0]==null?head:edgeMap[m][0];
        edgeMap[m][1] = head;
        setEdgeMap(head.left,m+1,edgeMap);
        setEdgeMap(head.right,m+1,edgeMap);
    }

    /**
     * 打印最底层的边界，这些边界节点既不属于最左节点和最右节点。
     * @param head      二叉树的根节点
     * @param n         当前进入递归的二叉树的层数
     * @param edgeMap   用于存储最左和最右节点的Node数组
     */
    public void printLeafNotInMap(Node head,int n,Node[][] edgeMap){
        if(head == null){
            return;
        }
        if(head!=edgeMap[n][0] && head != edgeMap[n][1] && head.left==null && head.right==null){
            System.out.print(head.value+" ");
        }
        printLeafNotInMap(head.left,n+1,edgeMap);
        printLeafNotInMap(head.right,n+1,edgeMap);
    }


    //标准二
    public void printEdgeTwo(Node head){
        if (head == null){
            return;
        }
        System.out.print(head.value+" ");
        if(head.left != null && head.right!=null){
            printLeftEdge(head.left,true);
            printRightEdge(head.right,true);
        }else
            printEdgeTwo(head.left!=null ?head.left:head.right);
    }

    /**
     * 打印左侧边界
     * @param head  根节点
     * @param print 是否打印的布尔值
     */
    public void printLeftEdge(Node head,boolean print){
        if (head==null)
            return;
        if(print || (head.right==null && head.left==null))
            System.out.print(head.value +" ");
        printLeftEdge(head.left,print);
        printLeftEdge(head.right,print && head.left==null ? true:false);
    }

    /**
     * 打印右侧边界
     * @param head  根节点
     * @param print 是否打印的布尔值
     */
    public void printRightEdge(Node head,boolean print){
        if (head == null)
            return;
        printRightEdge(head.left,print && head.right==null?true:false);
        printRightEdge(head.right,print);
        if(print || (head.left == null && head.right ==null))
            System.out.print(head.value+" ");
    }
}
