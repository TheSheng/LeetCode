package 动态规划;

/**
 * @ClassName： 最大子序和
 * @description:
 * @author: lisheng
 * @create: 2020-03-04 09:45
 **/
public class 最大子序和 {
    //贪心算法
    public static int maxSubArray(int[] nums) {
        if(nums.length==0)return 0;
        int sum=nums[0];
        //当前最优解
        int start=1;
        //局部最优解
        int curr=nums[0];
        while (start<nums.length){
            //如果是sum的话 会求出不连续的解
            curr=Math.max(nums[start],sum+nums[start]);
            sum=Math.max(curr,sum);
            start++;
        }
        return  sum;
    }
    //动态规划
    public  static  int sumByDongTaI(int[] nums){
        if(nums.length==0)return 0;
        int sum=nums[0];
        int index=1;
        while (index<nums.length){
            if(nums[index-1]>0)nums[index]=nums[index]+nums[index-1];
            sum=Math.max(sum,nums[index]);
            index++;
        }
        return  sum;
    }

    //暴力破解
    public static int Baoli(int[] nums) {
        int length=nums.length-1;
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            int cuusum=nums[i];
            for(int j=i+1;j<nums.length;j++){
                cuusum=cuusum+nums[j];
                sum=Math.max(sum,cuusum);
            }
        }
        return  sum;
    }


    public static void main(String[] args) {
        int[] param=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(sumByDongTaI(param));
    }
}
