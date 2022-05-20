package TestUtil.图.深度优先搜索遍历;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * 拓扑排序
 */
/*
6 6
0 1
0 4
0 3
1 2
3 5
4 1
*/
public class tuopuDFS {

    private static boolean[] visited;
    private static boolean[] onPath;
    private static boolean hasCycle=false;
    private static List<Integer> path;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v = sc.nextInt();
        int e=sc.nextInt();
        visited=new boolean[v];
        onPath=new boolean[v];
        path=new ArrayList<>();
        List<Integer>[] graph=new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i <e; i++) {
            int from=sc.nextInt();
            int to=sc.nextInt();
            graph[from].add(to);
        }
        dfs(graph,0);
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            if(i==path.size()-1){
                System.out.print(path.get(i));
            }else{
                System.out.print(path.get(i)+" ");
            }
        }
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
        path.add(v);
        onPath[v]=false;
    }
}
