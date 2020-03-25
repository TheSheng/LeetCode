package 数学;

/**
 * @ClassName： 三维体的表面积
 * @description:
 * @author: lisheng
 * @create: 2020-03-25 14:29
 **/
public class 三维体的表面积 {
    //做加法
    public int surfaceArea(int[][] grid) {
       int allSum=0;
       for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[i].length;j++){
                 int thisValue=grid[i][j];
                 //如果这一块有值  那么上下两面贡献2
               allSum+=thisValue==0?0:2;
               //左面  和左柱子高度比 也就是 grid[i-1][j]
               allSum+=i-1<0?thisValue:Math.max(thisValue-grid[i-1][j],0);
               //右面  和右柱子高度比 也就是 grid[i+1][j]
               allSum+=i+1>=grid.length?thisValue:Math.max(thisValue-grid[i+1][j],0);
               //后面  和后柱子高度比 也就是 grid[i][j+1]
               allSum+=j+1>=grid[i].length?thisValue:Math.max(thisValue-grid[i][j+1],0);
               //前面  和前柱子高度比 也就是 grid[i][j-1]
               allSum+=j-1<0?thisValue:Math.max(thisValue-grid[i][j-1],0);
           }
       }
       return allSum;
    }
    //做减法
    public int surfaceAreaByJian(int[][] grid) {
        //总共立方体个数
        int allSum=0;
        //接触面
        int euv=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int thisValue=grid[i][j];
                //增加几个立方体个数
                allSum+=thisValue;
                //内部接触面  v-1
                euv+=thisValue>1?thisValue-1:0;
                //左侧接触面面  和左柱子高度比 也就是 grid[i-1][j]  接触面积是两者取小
                euv+=i-1<0?0:Math.min(thisValue,grid[i-1][j]);
                //前面  和前柱子高度比 也就是 grid[i][j-1]  不用计算对立面后面会自己计算
                euv+=j-1<0?0:Math.min(thisValue,grid[i][j-1]);
            }
        }
        return 6*allSum-euv*2;
    }
}
