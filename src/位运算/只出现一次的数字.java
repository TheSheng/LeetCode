package 位运算;

import java.util.*;

/**
 * @ClassName： 只出现一次的数字
 * @description:
 * @author: lisheng
 * @create: 2020-03-06 14:59
 **/
public class 只出现一次的数字 {
    public int[] singleNumber(int[] nums) {
       Set<Integer> set=new HashSet<>();
        int start=0;
        while (start<nums.length){
            if (set.contains(nums[start])) set.remove(nums[start]);else set.add(nums[start]);
            start++;
        }
        int[] ints = set.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }
    public static int[] singleNumberByYihuo(int... nums){
        int num=0;
        for(int i:nums) num^=i;
        //在右边的差异位
        int diff=num&-num;
        int x=0;
        //求一个差异位对应的数字
        //             ==diff
        //如果 (diff&i)!=0 那就说明这个数在这个差异位上能留下1 这些上全部^留下的就是一个数
        for(int i:nums) if((diff&i)==diff)x^=i;
        return new int[]{x,x^num};
    }

    public static void main(String[] args) {

        String s = Arrays.toString(singleNumberByYihuo(1, 2, 1, 3, 2, 5));
        System.out.println(s);
    }
}
