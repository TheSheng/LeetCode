package 数组;

import java.util.*;

/**
 * @ClassName： 使数组S唯一的最小增量
 * @description:
 * @author: lisheng
 * @create: 2020-03-22 15:21
 **/
public class 使数组S唯一的最小增量{
    //排序解法(也可以借鉴计数法的思路）
    public int minIncrementForUnique(int[] A) {
       Arrays.sort(A);
       int moveCount=0;
       int index=1;
       while (index<A.length){
           if(A[index]<=A[index-1]){
               moveCount+=A[index-1]+1-A[index];
               A[index]=A[index-1]+1;
           }
           index++;
       }
       return moveCount;
    }
    //计数法
    //如果有重复的 可以直接操作次数-这个数   如果遇到没见过的数 直接在操作次数+这个数
    public int minIncrementForUniqueCount(int[] A) {
        int[] db=new int[80000];
        for(int x:A)db[x]++;
        int index=0;
        int moveCount=0;
        int repeat=0;
        while (index<db.length){
            if(db[index]>1){
                moveCount-=(db[index]-1)*index;
               repeat+=db[index]-1;
            }
            if(db[index]==0&&repeat>0){
                moveCount+=index;
                repeat--;
            }
            index++;
        }
        return moveCount ;
    }

    //一位Leecode老哥的计数法
    public int minIncrementForUniqueByCount(int[] A) {
        // counter数组统计每个数字的个数。
        //（这里为了防止下面遍历counter的时候每次都走到40000，所以设置了一个max，这个数据量不设也行，再额外设置min也行）
        int[] counter = new int[40001];
        int max = -1;
        for (int num: A) {
            counter[num]++;
            max = Math.max(max, num);
        }

        // 遍历counter数组，若当前数字的个数cnt大于1个，则只留下1个，其他的cnt-1个后移
        int move = 0;
        for (int num = 0; num <= max; num++) {
            if (counter[num] > 1) {
                int d = counter[num] - 1;
                //把这d个数往前移动一位 +d
                move += d;
                counter[num + 1] += d;
            }
        }
        // 最后, counter[max+1]里可能会有从counter[max]后移过来的，counter[max+1]里只留下1个，其它的d个后移。
        // 设 max+1 = x，那么后面的d个数就是[x+1,x+2,x+3,...,x+d],
        // 因此操作次数是[1,2,3,...,d],用求和公式求和。
        //移动超出数组最大值还有的话
        int d = counter[max + 1] - 1;
        move += (1 + d) * d / 2;
        return move;
    }
    //寻址压缩
    int[] pos = new int [80000];
    public int minIncrementForUniqueByZip(int[] A) {
        Arrays.fill(pos, -1); // -1表示空位
        int move = 0;
        // 遍历每个数字a对其寻地址得到位置b, b比a的增量就是操作数。
        for (int a: A) {
            int b = findPos(a);
            move += b - a;
        }
        return move;
    }

    // 线性探测寻址（含路径压缩）
    private int findPos(int a) {
        int b = pos[a];
        // 如果a对应的位置pos[a]是空位，直接放入即可。
        if (b == -1) {
            pos[a] = a;
            return a;
        }
        // 否则向后寻址
        // 因为pos[a]中标记了上次寻址得到的空位，因此从pos[a]+1开始寻址就行了（不需要从a+1开始）。
        b = findPos(b + 1);
        pos[a] = b; // 寻址后的新空位要重新赋值给pos[a]哦，路径压缩就是体现在这里。
        return b;
    }




}
