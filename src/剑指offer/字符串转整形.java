package 剑指offer;

/**
 * @ClassName： 字符串转整形
 * @description:
 * @author: lisheng
 * @create: 2020-03-06 19:34
 **/
public class 字符串转整形 {
    public static int strToInt(String str) {
       int index=0;
        str = str.trim();
        if(str.length()<1)return 0;
        int ans=1;
        char begin = str.charAt(index);
        if(begin=='-'){
            ans=-1;
            index++;
        }else if(begin=='+'){
            index++;
        }else if(begin<'0'||begin>'9'){
            return 0;
        }
        int rs=0;
        while (index<str.length()&&str.charAt(index)>='0'&&str.charAt(index)<='9'){
            int curr = Integer.parseInt(str.charAt(index) + "");
            if((rs>Integer.MAX_VALUE/10||(rs==Integer.MAX_VALUE/10&&curr>7))){
                rs=Integer.MAX_VALUE;
                if(ans==-1)return ~rs;
                break;
            }
            rs=rs*10+curr;
            index++;

        }
        return  rs*ans;
    }

    public static void main(String[] args) {
        System.out.println(strToInt("-91283472332"));
    }
}
