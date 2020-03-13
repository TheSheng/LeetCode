package Hash表;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName： 两数之和
 * @description:
 * @author: lisheng
 * @create: 2020-03-03 08:38
 **/
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) throws Exception {
        Map<Integer,Integer> hashsKey=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashsKey.containsKey(target-nums[i])){
                return new int[]{hashsKey.get(target-nums[i]),i};
            }
            hashsKey.put(nums[i],i);
        }
        throw new Exception("没有找到对应数字");

    }

}
