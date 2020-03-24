package 动态规划;

/**
 * @ClassName： 按摩师
 * @description:
 * @author: lisheng
 * @create: 2020-03-24 09:10
 **/
public class 按摩师 {
    int max=0;
    public int massage(int[] nums) {
        if(nums.length==0)return 0;
         Integer[] db=new Integer[nums.length];
         massageByDB(nums,0,db);
         if(nums.length>=2) massageByDB(nums,1,db);
        return max;
    }
    public int massageByDB(int[] nums,int index,Integer [] db){
        if(db[index]!=null)return db[index];
        int i=index+2;
        int thisNum=nums[index];
        while (i<nums.length){
            thisNum=Math.max(thisNum,nums[index]+massageByDB(nums,i,db));
            i++;
        }
        max=Math.max(thisNum,max);
        db[index]=thisNum;
        return thisNum;
    }
    public static  void main(String[] args){
        按摩师 anmo=new 按摩师();
        int rs=anmo.massage(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        System.out.println(rs);
    }
}
