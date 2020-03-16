package 字符串;

/**
 * @ClassName： 字符串压缩
 * @description:
 * @author: lisheng
 * @create: 2020-03-16 08:07
 **/
public class 字符串压缩 {
    public String compressString(String S) {
        if(S.length()<2)return S;
        StringBuilder news=new StringBuilder();
        int currLength=0;
        char  curr = 0;
        int index=0;
        while (index<S.length()){
            if(0==curr){
                curr=S.charAt(index);
                news.append(curr);
            }
            if((curr^S.charAt(index))==0)currLength++;
            else {
                news.append(currLength);
                curr=S.charAt(index);
                news.append(curr);
                currLength=1;
            }
            index++;
        }
        news.append(currLength);
        if(news.length()>=S.length())return S;
        else return news.toString();


    }
}
