package 数组;

/**
 * @ClassName： 车的可用补货量
 * @description:
 * @author: lisheng
 * @create: 2020-03-26 08:33
 **/
public class 车的可用补货量 {
    public int numRookCaptures(char[][] board) {
        int[] canFind=new int[16];
        int sum=0;
        A:for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='B'){
                    canFind[i]=0;
                    canFind[j+8]=0;
                }
                if(board[i][j]=='p'){
                    canFind[i]=1;
                    canFind[j+8]=1;
                }
                if(board[i][j]=='R'){
                    sum+=canFind[i]+canFind[j+8];
                    int x=i+1;
                    while (x<8){
                        if(board[x][j]=='B')break;
                        if(board[x][j]=='p'){
                            sum+=1;
                            break;
                        }
                        x++;
                    }
                    while (j<8){
                        if(board[i][j]=='B')break;
                        if(board[i][j]=='p'){
                            sum+=1;
                            break;
                        }
                        j++;
                    }
                    break A;
                }
            }
        }
        return sum;
    }
}
