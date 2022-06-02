package TestUtil.图论.图.最短距离.迪杰斯特拉.邻接矩阵;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author:why
 * @create: 2022-06-01 09:11
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        int[][] edges=new int[7][7];
        int[] v0 = new int[]{0, 4, 6, 6, Integer.MAX_VALUE, Integer.MAX_VALUE,Integer.MAX_VALUE};
        int[] v1 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 1, Integer.MAX_VALUE, 7, Integer.MAX_VALUE,Integer.MAX_VALUE};
        int[] v2 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6,4,Integer.MAX_VALUE};
        int[] v3 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, Integer.MAX_VALUE,5,Integer.MAX_VALUE};
        int[] v4 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,6};
        int[] v5 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, Integer.MAX_VALUE,8};
        int[] v6 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,Integer.MAX_VALUE};
        edges[0] = v0;
        edges[1] = v1;
        edges[2] = v2;
        edges[3] = v3;
        edges[4] = v4;
        edges[5] = v5;
        edges[6] = v5;
        int[] distances = dijkstra(edges,7,0);
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + ":" + distances[i]);
        }
    }
    public static int[] dijkstra(int[][] distance,int verNum,int src) {
        //记录最短路径顺序的数组
        int[] disTo = new int[verNum];
        int[] path=new int[verNum];
        //遍记已经淘汰的顶点
        int[] flag=new int[verNum];
        //初始化
        for(int i=0;i<verNum;++i){
            disTo[i]=distance[src][i];
            if(distance[src][i]!=Integer.MAX_VALUE){
                path[i]=src;
            }else{
                path[i]=Integer.MAX_VALUE;
            }
        }
        path[src]=-1;
        flag[src]=1;
        for(int k=0;k<verNum-1;++k){
            int minIndex=-1;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<verNum;++i){
                if(flag[i]==0&&disTo[i]<min){
                    min=disTo[i];
                    minIndex=i;
                }
            }
            flag[minIndex]=1;
            for(int i=0;i<verNum;++i){
                if(flag[i]==0&&distance[minIndex][i]!=Integer.MAX_VALUE&&disTo[minIndex]+distance[minIndex][i]<disTo[i]){
                    disTo[i]=disTo[minIndex]+distance[minIndex][i];
                    path[i]=minIndex;
                }
            }
        }
        printPath(path,6);
        return disTo;
    }

    /**
     *
     * @param path
     * @param x 目标点
     */
    private static void printPath(int[] path,int x) {
        ArrayList<Integer> track=new ArrayList<>();
        track.add(x);
        while(path[x]!=-1){
            track.add(path[x]);
            x=path[x];
        }
        Collections.reverse(track);
        for (Integer integer : track) {
            System.out.print(integer+",");
        }
        System.out.println();
    }
}
