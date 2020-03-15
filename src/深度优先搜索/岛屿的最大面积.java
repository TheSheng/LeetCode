package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName： 岛屿的最大面积
 * @description:
 * @author: lisheng
 * @create: 2020-03-15 12:55
 **/
public class 岛屿的最大面积 {

    public static int maxAreaOfIsland(int[][] grid) {
        List<String> dp=new ArrayList<>();
        int x=0;
        int rs=0;
        while (x<grid.length){
            int y=0;
            while (y<grid[x].length){
                if(grid[x][y]==1&&!dp.contains(x+","+y)){
                    dp.add((x)+","+y);
                    int thisSum=maxAreaOfIslandByDFS(grid,x,y,dp,1);
                    rs=Math.max(rs,thisSum);
                }
                y++;
            }
            x++;
        }
        return rs;
    }
    public static int maxAreaOfIslandByDFS(int[][] grid,int x,int y,List<String> dp,int thisSum){
        if(y-1>=0&&grid[x][y-1]==1&&!dp.contains((x)+","+(y-1))){
            dp.add((x)+","+(y-1));
            thisSum=maxAreaOfIslandByDFS(grid,x,y-1,dp,++thisSum);
        }
        if(x-1>=0&&grid[x-1][y]==1&&!dp.contains((x-1)+","+(y))){
            dp.add((x-1)+","+(y));
            thisSum=maxAreaOfIslandByDFS(grid,x-1,y,dp,++thisSum);
        }
        if(x+1<grid.length&&grid[x+1][y]==1&&!dp.contains((x+1)+","+y)){
            dp.add((x+1)+","+y);
            thisSum=maxAreaOfIslandByDFS(grid,x+1,y,dp,++thisSum);
        }
        if(y+1<grid[x].length&&grid[x][y+1]==1&&!dp.contains((x)+","+(y+1))) {
            dp.add(x + "," + (y + 1));
            thisSum = maxAreaOfIslandByDFS(grid, x, y + 1, dp, ++thisSum);
        }
        return thisSum;
    }

    public static void main(String[] args) {
        int i = maxAreaOfIsland(new int[][]{{0, 1}, {1, 1}});
        System.out.println(i);
    }
}
