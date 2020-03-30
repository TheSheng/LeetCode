package 数学;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName： 圆圈中最后剩下的数字  约瑟夫环
 * @description:
 * @author: lisheng
 * @create: 2020-03-30 08:42
 **/
public class 圆圈中最后剩下的数字 {

    public static int lastRemaining(int n, int m) {
         List<Integer> db=new ArrayList(n);
         for(int i=0;i<n;i++){
             db.add(i);
         }
         int index=0;
         while(n>1){
             index=(index+m-1)%n;
             db.remove(index);
             n--;
         }
        return db.get(0);
    }
    public int lastRemainingByMath(int n, int m) {
        int ans=0;
        int index=1;
        while (index<=n){
            ans=(ans+m)%index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(10,17));
    }
}
