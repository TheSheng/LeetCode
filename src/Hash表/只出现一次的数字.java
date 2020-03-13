package Hash表;

import java.util.*;

/**
 * @ClassName： 只出现一次的数字
 * @description:
 * @author: lisheng
 * @create: 2020-03-04 17:10
 **/
public class 只出现一次的数字 {
    //可以使用hash同样的没有加 有就删除  或者数学方法   2*set-list=单独的那一个
    public int singleNumber(int[] nums) {
        int index=0;
        Set<Integer> call=new HashSet<>();
        while (index<nums.length){
           if(call.contains(nums[index])){
               call.remove(nums[index]);
           }else{
               call.add(nums[index]);
           }
           index++;
        }
        return call.iterator().next();
    }
    public int singleNumberByYi(int[] nums) {
        int rs=0;
        int index=0;
        while (index<nums.length){
            rs=rs^nums[index];
            index++;
        }
        return rs;

    }

    //位异或操作  相同位为0 不同为1  ^  0^any=any  any^any=0   0^a^a^b=b
    //位或        a|a=a   0|a=a
    //位与       0|a=0    a&a=a
    //
    public static void main(String[] args) {
        System.out.println(2&2);
    }


}
