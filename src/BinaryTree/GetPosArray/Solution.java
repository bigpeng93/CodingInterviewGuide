package BinaryTree.GetPosArray;

/**
 * 通过先序和中序数组生成后序数组
 *
 * 已知一棵二叉树所有的节点值都不同，给定这棵树正确的先序和后序数组，
 * 不要重建整棵树，而是通过这两个数组直接生成正确的后序数组。
 */
public class Solution {
    public int[] getPosArray(int[] pre,int[] in){
        if (pre==null||in==null)
            return null;
        int[] pos = new int[pre.length];
        int[] index = new int[1];
        index[0] = pos.length-1;
        getPos(pos,pre,0,pre.length-1,in,0,in.length-1,index);
        return pos;

    }

    public void getPos(int[] pos,int[] pre,int pref,int prel,int[] in,int inf,int inl,int[] index){
        if (pref > prel || inf > inl)
            return;
        int cur = pre[pref];
        int i = inf;
        pos[index[0]] = cur;
        index[0] = index[0]-1;
        for (;i<=inl;i++){
            if (in[i] == cur)
                break;
        }
        getPos(pos,pre,pref+(i-inf)+1,prel,in,i+1,inl,index);
        getPos(pos,pre,pref+1,pref+(i-inf),in,inf,i-1,index);
    }
}
