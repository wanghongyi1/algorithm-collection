package TestUtil.笔试.华为.第0406.第2题服务启动;

import java.util.*;

/**
 * @author:why
 * @create: 2022-06-02 22:43
 * @Description:
 */
/*
4
2
0
1,0
1,1
2,0,1
结果：
0,1

2
1
1,1
1,0
结果：
-1
 */
public class Main {
    static boolean[] path;
    static boolean hasCycle=false;
    static List<Integer> track;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        int M=sc.nextInt();
        List<Integer>[] graph=new ArrayList[N];
        track=new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        sc.nextLine();
        for(int i=0;i<N;++i){
            String[] split = sc.nextLine().split(",");
            int to=i;
            int from;
            for (int i1 = 1; i1 < split.length; i1++) {
                from=Integer.parseInt(split[i1]);
                graph[to].add(from);
            }
        }
        path=new boolean[N];
        boolean[] visited=new boolean[N];
        dfs(graph,M,visited);
        if(hasCycle){
            System.out.println(-1);
            return;
        }
        track.remove(track.size()-1);
        track.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue()-o2.intValue();
            }
        });
        for (int i = 0; i < track.size(); i++) {
            if(i==0){
                System.out.print(track.get(i));
            }else{
                System.out.print(","+track.get(i));
            }
        }
    }
    private static void dfs(List<Integer>[] graph, int v, boolean[] visited) {
        if(path[v]){
            hasCycle=true;
            return;
        }
        if(visited[v]){
            return;
        }
        visited[v]=true;
        path[v]=true;
        for (Integer adj : graph[v]) {
            dfs(graph,adj, visited);
        }
        track.add(v);
        path[v]=false;
    }
}
