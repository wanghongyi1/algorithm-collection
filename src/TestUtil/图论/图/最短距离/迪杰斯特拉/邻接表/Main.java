package TestUtil.图论.图.最短距离.迪杰斯特拉.邻接表;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author:why
 * @create: 2022-06-01 10:33
 * @Description:
 */
public class Main {
    public static int[] dijkstra(int start, List<int[]>[] graph){

        int[] distTo=new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        Queue<State> que=new PriorityQueue<>((a, b)->{
            return a.distFromStart-b.distFromStart;
        });
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
