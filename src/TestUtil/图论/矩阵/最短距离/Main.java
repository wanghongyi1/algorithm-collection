package TestUtil.图论.矩阵.最短距离;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:why
 * @create: 2022-05-31 20:22
 * @Description:
 * 多源最短路径问题（点集到点集-》超级源点）
 */
public class Main {
    /*
        1162. 地图分析
        你现在手里有一份大小为 n x n 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地。
        请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的，并返回该距离。如果网格上只有陆地或者海洋，请返回 -1。
        我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
     */
    public static int maxDistance(int[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        Queue<int[]> que=new LinkedList<>();
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==1){
                    que.offer(new int[]{i,j});
                    visited[i][j]=1;
                }
            }
        }
        if(que.size()==0||que.size()==grid.length*grid[0].length){
            return -1;
        }
        int level=0;
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        while(!que.isEmpty()){
            int len=que.size();
            level++;
            for(int j=0;j<len;++j){
                int[] poll = que.poll();
                int x=poll[0],y=poll[1];
                for(int i=0;i<4;++i){
                    int mx=x+dx[i],my=y+dy[i];
                    if(mx>=0&&mx<=grid.length-1&&my>=0&&my<=grid[0].length-1&&visited[mx][my]==0){
                        que.offer(new int[]{mx,my});
                        visited[mx][my]=1;
                    }
                }
            }
        }
        return level-1;
    }
    int[] dx={0,0,1,-1};
    int[] dy={1,-1,0,0};
    public static int maxDistance2(int[][] grid) {
        int[][] disTo=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==1){
                    disTo[i][j]=0;
                }else{
                    disTo[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        return 0;
    }
}
