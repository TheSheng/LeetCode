package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName： 三数之和
 * @description:
 * @author: lisheng
 * @create: 2020-03-05 10:45
 **/
public class 三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3)return Collections.EMPTY_LIST;
        List<List<Integer>> rs=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)break;
            if(i>0 && nums[i]==nums[i-1])continue;
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    rs.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //可能连续好几个都是相同的 用if只会过滤掉一个
                    while(left<right&&nums[left]==nums[left+1])left++;
                    while (right>left&&nums[right]==nums[right-1])right--;
                    left++;
                    right--;
                }else if(sum>0)right--;
                else if(sum<0)left++;
            }
        }
        return  rs;

    }

    public static void main(String[] args) {
        threeSum(new int[]{-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0});
    }

}
