package 数学;

/**
 * @ClassName： 字符串转换整数
 * @description:
 * @author: lisheng
 * @create: 2020-04-03 08:41
 **/
public class 字符串转换整数 {
    public static int myAtoi(String str) {
        int num=0;
        int ans=0;
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='0'&&chars[i]<='9'){
                if(ans==0)ans=1;
                int thisNum=chars[i]-'0';
                if(num>Integer.MAX_VALUE/10||(num==Integer.MAX_VALUE/10&&thisNum>7)){
                    return ans==-1?~Integer.MAX_VALUE:Integer.MAX_VALUE;
                }
                num=num*10+thisNum;
            }
            else if(num==0&&ans==0){
                if(chars[i]=='-'&&ans==0)ans=-1;
                else if(chars[i]=='+'&&ans==0)ans=1;
                else if(chars[i]==' '&&ans==0);
                else break;
                continue;
            }
            else break;
        }
        return ans*num;
    }

    public static void main(String[] args) {
        System.out.println(~-2);
    }
}
