package TestUtil.图.广度搜索遍历;

import java.util.*;
/*
    6 6
    0 1 2
    0 4 2
    0 3 2
    1 2 2
    3 5 2
    4 1 2
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

        int[] disTo = dijkstra(0, graph);
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
}
