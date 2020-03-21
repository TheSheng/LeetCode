package 数学;

/**
 * @ClassName： 水壶问题
 * @description:
 * @author: lisheng
 * @create: 2020-03-21 14:18
 **/
public class 水壶问题 {
    //贝斯定理  ax+by=cz  z是ab的最大公约数
    //也可以用dfs
    public boolean canMeasureWater(int x, int y, int z) {
       if(x+y<z)return false;
       if(x==0||y==0)return z==x+y||z==0;
       return z%gcd(x,y)==0;
    }
    //最小公倍数=a*b/最大公约数
    public  Integer gcd(int x,int y){
        return x%y==0?y:gcd(y,x%y);
    }

}
