package 数组;

import java.util.Arrays;

/**
 * @ClassName： 删除排序数组中的重复项
 * @description:
 * @author: lisheng
 * @create: 2020-03-04 08:56
 **/
public class 删除排序数组中的重复项 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0)return 0;
         int i=0;
         for(int j=1;j<nums.length;j++){
             if(nums[i]!=nums[j]){
                 i++;
                 nums[i]=nums[j];
             }
         }
         return  i;
    }

    public static void main(String[] args) {
        int []nums={1,1,2};
        int i = removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
}
