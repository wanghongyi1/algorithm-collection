package TestUtil.图论.图.最短距离.迪杰斯特拉.邻接表;

import java.util.*;
/*
    6 6
    0 1 2
    0 4 2
    0 3 2
    1 2 2
    3 5 2
    4 1 2

    0->0:0
    0->1:2
    0->2:4
    0->3:2
    0->4:2
    0->5:4
 */
/**
 * 迪杰斯特拉求任意两点之间的最短距离
 */
class State{
    int id;
    int distFromStart;
    public State(int id,int distFromStart){
        this.id=id;
        this.distFromStart=distFromStart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistFromStart() {
        return distFromStart;
    }

    public void setDistFromStart(int distFromStart) {
        this.distFromStart = distFromStart;
    }
}
public class startToAnyOneDist {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        List<int[]>[] graph=new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<e;++i){
            int from=sc.nextInt();
            int to=sc.nextInt();
            int w=sc.nextInt();
            graph[from].add(new int[]{to,w});
        }
        int[] disTo = dijkstra3(0, graph);
        for (int i = 0; i < disTo.length; i++) {
            System.out.println(0+"->"+i+":"+disTo[i]);
        }
    }
    public static int[] dijkstra(int start,List<int[]>[] graph){
        Queue<State> que=new PriorityQueue<>((a,b)->{
            return a.distFromStart-b.distFromStart;
        });
        int[] distTo=new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        que.offer(new State(start, 0));
        distTo[start]=0;
        while(!que.isEmpty()){
            State curNode = que.poll();
            int curNodeId=curNode.getId();
            int curNodeDistFromStart=curNode.getDistFromStart();
            if(curNodeDistFromStart>distTo[curNodeId]){
                continue;
            }
            for (int[] nextNode : graph[curNodeId]) {
                int nextNodeId=nextNode[0];
                int nextNodeW=nextNode[1];
                int nextNodeDistFromStart=curNodeDistFromStart+nextNodeW;
                if(nextNodeDistFromStart<distTo[nextNodeId]){
                    distTo[nextNodeId]=nextNodeDistFromStart;
                    que.offer(new State(nextNodeId,nextNodeDistFromStart));
                }
            }
        }
        return distTo;
    }
    public static int[] dijkstra2(int start,List<int[]>[] graph){
        Queue<Integer> que=new LinkedList<>();
        int[] distTo=new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start]=0;
        que.offer(start);
        while(!que.isEmpty()){
            int curNodeId = que.poll();
            for (int[] adj : graph[curNodeId]) {
                int id=adj[0];
                int w=adj[1];
                if(distTo[curNodeId]+w<distTo[id]){
                    distTo[id]=distTo[curNodeId]+w;
                    que.offer(id);
                }
            }
        }
        return distTo;
    }
    public static int[] dijkstra3(int start,List<int[]>[] graph){
        int[] distTo=new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        int[] flag=new int[graph.length];

       /* for(int i=0;i<graph[start].size();++i){
            distTo[graph[start].get(i)[0]]=graph[start].get(i)[1];
        }*/
        distTo[start]=0;
        //flag[start]=1;
        for(int k=0;k<graph.length;++k){
            int min=Integer.MAX_VALUE;
            int minIndex=-1;
            for(int i=0;i<distTo.length;++i){
                if(flag[i]==0&&distTo[i]<min){
                    min=distTo[i];
                    minIndex=i;
                }
            }
            flag[minIndex]=1;
            for (int[] adj : graph[minIndex]) {
                if(flag[adj[0]]==0&&distTo[minIndex]+adj[1]<distTo[adj[0]]){
                    distTo[adj[0]]=distTo[minIndex]+adj[1];
                }
            }
        }
        return distTo;
    }
}
