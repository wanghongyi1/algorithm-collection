package TestUtil.图.广度搜索遍历;


import java.util.*;
/*
6 6
0 1
0 4
0 3
1 2
3 5
4 1
 */
/**
 * 图的广度优先搜索遍历（邻接表）
 */
public class BFSGraph{
    private static boolean[] visited;
    private static List<Integer> path;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v = sc.nextInt();
        int e=sc.nextInt();
        visited=new boolean[v];
        List<Integer>[] graph=new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i <e; i++) {
            int from=sc.nextInt();
            int to=sc.nextInt();
            graph[from].add(to);
        }
        path=new ArrayList<>();
        for(int i=0;i<v;++i){
            if(!visited[i]){
                BFS(graph,i);
            }
        }
        for (int i = 0; i < path.size(); i++) {
            if(i==path.size()-1){
                System.out.print(path.get(i));
            }else{
                System.out.print(path.get(i)+" ");
            }
        }
    }

    private static void BFS(List<Integer>[] graph,int v) {
        Queue<Integer> que=new LinkedList<>();
        que.offer(v);
        while(!que.isEmpty()){
            int len=que.size();
            for(int i=0;i<len;++i){
                Integer poll = que.poll();
                path.add(poll);
                visited[poll]=true;
                for (Integer integer : graph[poll]) {
                    if(!visited[integer]){
                        que.offer(integer);
                    }
                }
            }
        }
    }
}
