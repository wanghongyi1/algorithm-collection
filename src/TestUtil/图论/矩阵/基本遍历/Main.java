package TestUtil.图论.矩阵.基本遍历;

import java.util.*;

/**
 * @author:why
 * @create: 2022-05-31 16:01
 * @Description:
 * //逆向遍历
 */
public class Main {
    /*
        733 图像渲染
        有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。
        你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。
        为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为 newColor 。
        最后返回 经过上色渲染后的图像 。
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]!=newColor){
            dfs(image,sr,sc,newColor,image[sr][sc]);
        }
        return image;
    }
    private void dfs(int[][] image,int i,int j,int newColor,int val) {
        if(i<0||i>=image.length||j<0||j>=image[0].length){
            return;
        }
        if(image[i][j]!=val){
            return;
        }
        image[i][j]=newColor;
        dfs(image,i-1,j,newColor,val);
        dfs(image,i,j-1,newColor,val);
        dfs(image,i+1,j,newColor,val);
        dfs(image,i,j+1,newColor,val);

    }
    //递归遍历方法
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]!=newColor){
            dfs(image,sr,sc,newColor,image[sr][sc]);
        }
        return image;
    }
    int[] dx={0,0,1,-1};
    int[] dy={1,-1,0,0};
    private void dfs2(int[][] image,int x,int y,int target,int src) {
        if(!(x>=0&&x<=image.length-1&&y>=0&&y<=image[0].length-1)){
            return;
        }
        if(image[x][y]!=src){
            return;
        }
        image[x][y]=target;
        for(int i=0;i<4;++i){
            int mx=x+dx[i],my=y+dy[i];
            dfs2(image,mx,my,target,src);
        }
    }
    //广度优先搜索遍历
    public int[][] floodFill3(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){
            return image;
        }
        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[]{sr,sc});
        int src=image[sr][sc];
        image[sr][sc]=newColor;
        while(!que.isEmpty()){
            int[] poll = que.poll();
            int x=poll[0],y=poll[1];
            for(int i=0;i<4;++i){
                int mx=x+dx[i],my=y+dy[i];
                if(mx>=0&&mx<=image.length-1&&my>=0&&my<=image[0].length-1&&image[mx][my]==src){
                    que.offer(new int[]{mx,my});
                    image[mx][my]=newColor;
                }
            }
        }
        return image;
    }
    private void dfs3(int[][] image,int x,int y,int target,int src) {
        if(image[x][y]!=src){
            return;
        }
        image[x][y]=target;
        for(int i=0;i<4;++i){
            int mx=x+dx[i],my=y+dy[i];
            if(mx>=0&&mx<=image.length-1&&my>=0&&my<=image[0].length){
                dfs3(image,mx,my,target,src);
            }
        }
    }
    /*
        417. 太平洋大西洋水流问题
        有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
        这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
        岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
        返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] flag1=new int[heights.length][heights[0].length];
        int[][] flag2=new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;++i){
            dfs8(heights,i,0,flag1,heights[i][0]);
            dfs8(heights,i,heights[0].length-1,flag2,heights[i][heights[0].length-1]);
        }
        for(int i=0;i<heights[0].length;++i){
            dfs8(heights,0,i,flag1,heights[0][i]);
            dfs8(heights,heights.length-1,i,flag2,heights[heights.length-1][i]);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<heights.length;++i){
            for(int j=0;j<heights[0].length;++j){
                if(flag1[i][j]==1&&flag2[i][j]==1){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public void dfs8(int[][] heights,int x,int y,int[][] flag,int pre){
        if(x<0||y<0||x>=heights.length||y>=heights[0].length){
            return;
        }
        if(flag[x][y]==1||heights[x][y]<pre){
            return;
        }
        flag[x][y]=1;
        for(int i=0;i<4;++i){
            int mx=x+dx[i],my=y+dy[i];
            dfs8(heights,mx,my,flag,heights[x][y]);
        }
    }

}
