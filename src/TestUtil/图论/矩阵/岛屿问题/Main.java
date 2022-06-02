package TestUtil.图论.矩阵.岛屿问题;

/**
 * @author:why
 * @create: 2022-05-31 19:38
 * @Description:
 */
public class Main {
    /*
        200 岛屿数量
        给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
        此外，你可以假设该网格的四条边均被水包围。
     */
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }

        }
        return count;
    }
    int[] dx={0,0,1,-1};
    int[] dy={1,-1,0,0};
    private void dfs(char[][] grid, int i, int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        for(int k=0;k<4;++k){
            int mx=i+dx[k],my=j+dy[k];
            dfs(grid,mx,my);
        }
    }
    /*
        695 岛屿的最大面积
        给你一个大小为 m x n 的二进制矩阵 grid 。
        岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
        岛屿的面积是岛上值为 1 的单元格的数目。
        计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
     */
    public int maxAreaOfIsland(int[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==1){
                    res=Math.max(res,dfs2(grid,i,j));
                }
            }

        }
        return res;
    }
    private int dfs2(int[][] grid, int i, int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        int count=0;
        for(int k=0;k<4;++k){
            int mx=i+dx[k],my=j+dy[k];
            count+=dfs2(grid,mx,my);
        }
        return count;
    }
    /*
        1254. 统计封闭岛屿的数目
        二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
        请返回 封闭岛屿 的数目。
     */
    public int closedIsland(int[][] grid) {

        for(int i=0;i<grid.length;++i){
            dfs3(grid,i,0);
            dfs3(grid,i,grid[0].length-1);
        }
        for(int i=0;i<grid[0].length;++i){
            dfs3(grid,0,i);
            dfs3(grid,grid.length-1,i);
        }
        int count=0;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==0){
                    count++;
                    dfs3(grid,i,j);
                }
            }

        }
        return count;
    }
    private void dfs3(int[][] grid, int i, int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
        }
        if(grid[i][j]==1){
            return;
        }
        grid[i][j]=1;
        for(int k=0;k<4;++k){
            int mx=i+dx[k],my=j+dy[k];
            dfs3(grid,mx,my);
        }
    }
    /*
        飞地数量，封闭岛屿的面积
     */

    /*
        1905 统计子岛屿
        给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
        如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
        请你返回 grid2 中 子岛屿 的 数目 。
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for(int i=0;i<grid1.length;++i){
            for(int j=0;j<grid1[0].length;++j){
                if(grid1[i][j]==0&&grid2[i][j]==1){
                    dfs4(grid2,i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<grid2.length;++i){
            for(int j=0;j<grid2[0].length;++j){
                if(grid2[i][j]==1){
                    count++;
                    dfs4(grid2,i,j);
                }
            }

        }
        return count;

    }

    private void dfs4(int[][] grid, int i, int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
        }
        if(grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        for(int k=0;k<4;++k){
            int mx=i+dx[k],my=j+dy[k];
            dfs3(grid,mx,my);
        }
    }
}
