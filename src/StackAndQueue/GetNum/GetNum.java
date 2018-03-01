package StackAndQueue.GetNum;

import java.util.LinkedList;

public class GetNum {
    public int getNum (int[] arr,int num){
        if(arr == null || arr.length ==0){
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i=0;
        int j=0;
        int res = 0;
        while(i<arr.length){
            while (j<arr.length){
                while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
                    break;
                }
                j++;
                //System.out.println(qmin.peekFirst()+" "+qmax.peekFirst());
            }
            if(qmin.peekFirst()==i){
                qmin.pollFirst();
            }
            if(qmax.peekFirst()==i){
                qmax.pollFirst();
            }
            //System.out.println("suoyin"+j+" "+i);
            res += j-i;
            i++;
        }
        return res;
    }
}
