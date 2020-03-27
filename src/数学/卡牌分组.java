package 数学;

import java.util.*;

/**
 * @ClassName： 卡牌分组
 * @description: 卡牌分组
 * @author: lisheng
 * @create: 2020-03-27 08:11
 **/
public class 卡牌分组 {
    public static boolean hasGroupsSizeX(int[] deck) {
        int[] nums=new int[10000];
        for(int i:deck){
            nums[i]++;
        }
        return ngcd(nums)>=2;

    }
    public static int ngcd(int [] nums) {
        int gcd=nums[0];
        for(int i:nums){
            if(i==1)return 1;
            if(i!=0)gcd=gcd(gcd,i);
            i++;
        }
        return gcd;
    }
    public static int gcd(int a,int b){
        return a%b==0?b:gcd(b,a%b);
    }
    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3}));
    }
}

