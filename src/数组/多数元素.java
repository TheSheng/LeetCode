package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName： 多数元素
 * @description:
 * @author: lisheng
 * @create: 2020-03-13 08:51
 **/
public class 多数元素 {

    //最垃圾的穷举法
    public int majorityElement(int[] nums) {
          Map<Integer,Integer> map=new HashMap<>();
          int index=0;
          while (0<nums.length){
              Integer count = map.getOrDefault(nums[index], 0);
              count++;
              if(count>nums.length/2)return nums[index];
              map.put(nums[index],count);
          }
          return 0;
    }
    //可以排序n/2这位一定是众数


    //摩尔投票法
    //先假定  第0位是众数 遇到相同的+1 遇到不同的减-  如果减到0 更换值 因为众数个数最多 最后至少剩下一个众数
    public  int majorityElementByMajor(int[] nums){
        int  rs=nums[0];
        int count=1;
        int inedx=1;
        while (inedx<nums.length){
            if(rs==nums[inedx]) {
                count++;
                if(count>nums.length/2)return rs;
            }
            else{
                if(count==1)rs=nums[inedx];
                else count--;
            }
            inedx++;
        }
        return rs;
    }
}
