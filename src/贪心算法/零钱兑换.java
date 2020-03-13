package 贪心算法;

import java.util.*;

/**
 * @ClassName： 零钱兑换
 * @description:
 * @author: lisheng
 * @create: 2020-03-08 13:33
 **/
public class 零钱兑换 {

   public  int coinChange(int[] coins,int amount){
       return coinChangeByDongTai(coins,amount,new int[amount]);
   }
    //动态规划 F(n)=F(n-s)+1 其中s是最大一枚硬币的金额
    public   int coinChangeByDongTai(int[] coins,int amount,int[] db) {
        if(amount==0)return 0;
        if(amount<0)return -1;
        if(db[amount]!=0)return db[amount];
        int min=Integer.MAX_VALUE;
        for(int num:coins){
            int thisValue=coinChangeByDongTai(coins,amount-num,db)+1;
            if(thisValue==0)continue;
            if(thisValue>min)break;
            min=Math.min(thisValue,min);
        }
        min=min==Integer.MAX_VALUE?-1:min;
        db[amount]=min;
        return min;
    }
    //dfs
    int ans=Integer.MAX_VALUE;
    public  int coinChangeDFS(int[] coins,int amount){
        Arrays.sort(coins);
        getBydfs(coins,coins.length-1,amount,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public  void getBydfs(int[] coins,int currIndex,int amout,int cnt){
        if(currIndex<0)return ;
        for(int i=amout/coins[currIndex];i>=0;i--){
            int nextamout=amout-i*coins[currIndex];
            int nextcnt=cnt+i;
            if(amout==0){
                ans=Math.min(cnt,ans);
                break;
            }
            if(cnt+1>ans){
                break;
            }
            getBydfs(coins,currIndex-1,nextamout,nextcnt);
        }

    }





    public static void main(String[] args) {

    }
}
