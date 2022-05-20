package TestUtil.图.深度优先搜索遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 图深度优先遍历（判断是否有环）（邻接表）
 */
public class HasCycleDFS {

    private static boolean[] visited;
    private static boolean[] onPath;
    private static boolean hasCycle=false;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v = sc.nextInt();
        int e=sc.nextInt();
        visited=new boolean[v];
        onPath=new boolean[v];
        List<Integer>[] graph=new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i <e; i++) {
            int from=sc.nextInt();
            int to=sc.nextInt();
            graph[from].add(to);
        }
        for(int i=0;i<graph.length;++i){
            if(!visited[i]){
                dfs(graph, i);
            }
            if(hasCycle){
                System.out.println(hasCycle);
                return;
            }
        }
        System.out.println(hasCycle);
    }

    private static void dfs(List<Integer>[] graph, int v) {
        if(onPath[v]){
            hasCycle=true;
            return;
        }
        if(visited[v]){
            return;
        }
        visited[v]=true;
        onPath[v]=true;
        for (Integer next : graph[v]) {
            dfs(graph,next);
        }
        onPath[v]=false;
    }
}
