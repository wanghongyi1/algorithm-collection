package TestUtil.笔试.华为.第0413.总结.第2题任务调度问题.单核.运行时间相同;

/**
 * @author:why
 * @create: 2022-06-02 13:13
 * @Description:贪心＋优先权队列
 */

import java.util.*;

/*
    7
    4 70
    2 60
    4 50
    3 40
    1 30
    4 20
    6 10
    230
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if(N==0){
            System.out.println(0);
            return;
        }
        //tasks数组保存输入,tasks[i][0]代表工单等待时长，tasks[i][1]代表对应分数
        int[][]tasks=new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                tasks[i][j] = scanner.nextInt();
            }
        }
        //我们首先应该选择等待时间小的，时间从0开始一个个判断，如果相等在选择积分大的。这样得到的肯定是最优的
        Arrays.sort(tasks, (a, b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }
                return o2[1]-o1[1];
            }
        });
        //这里需要按照积分从小到大排序
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        //当前处理工单耗时
        int cur_time = 0;
        for (int i=0;i<tasks.length;i++) {
            int time = tasks[i][0], score = tasks[i][1];
            if(time>cur_time){
                //增加时长（可以看到，队列的长度就是当前时长。因为每个工单都是耗时一小时）
                cur_time++;
                q.offer(tasks[i]);
            }else if(!q.isEmpty() && q.peek()[1] <score) {
                //队首工单我们撤销处理，有可以处理的积分更大的
                q.poll();
                q.offer(tasks[i]);
            }
        }
        //积分总和
        int ans=0;
        //此时，队列中保存的就是满足条件的工单
        while (!q.isEmpty()){
            ans+=q.poll()[1];
        }
        System.out.println(ans);
    }
}
