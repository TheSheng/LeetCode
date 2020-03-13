package 数学;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName： 整数反转
 * @description:
 * @author: lisheng
 * @create: 2020-03-04 13:53
 **/
public class 整数反转 {
    public static int reverse(int x){
        int rs=0;
        while (x!=0) {
            int last = x % 10;
            x=x/10;
            if(rs>Integer.MAX_VALUE/10||(rs==Integer.MAX_VALUE/10&&last==7)||rs<Integer.MIN_VALUE/10||(rs==Integer.MIN_VALUE/10&&last==-7))return 0;
            rs=rs*10+last;
        }
        return rs;

    }
    public static void main(String[] args) {
        System.out.println(reverse(12340));
    }

}
