package TestUtil.笔试.华为.第0413.总结.第2题任务调度问题.单核.运行时间相同;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:why
 * @create: 2022-06-02 10:30
 * @Description:贪心＋标记数组
 * 单处理器上具有期限和惩罚的单位时间任务调度问题，目标是使惩罚最小。
 * 具有截止时间和误时惩罚的单位时间任务时间表问题可描述如下：
 *      (1) n 个单位时间任务的集合S={1,2,…,n}（n≤500）；
 *      (2) 任务i的截止时间deadline[i]，1≤d[i]≤n，即要求任务i在时间d[i]之前结束；
 *      (3) 任务i 的误时惩罚1≤weught[i]<1000，即任务i 未在时间d[i]之前结束将招致w[i]的惩罚；若按时完成则无惩罚。
 * 任务时间表问题要求确定S 的一个时间表（最优时间表）使得总误时惩罚达到最小。
 * 贪心思路：
 *       贪心考虑的是局部的最优解，而不是全局的最优解，为了达到最小的误时惩罚，按照贪心策略，肯定是先去按时完成或提前完成惩罚较大的任务。
 *       若一个时间片上已经安排了按时完成的、有着较大惩罚的任务，那么，这个有着较小惩罚的任务，则需要提前完成（提前完成有着很多种方法，按照贪心策略，
 *       应该是放在紧邻的上一个时间片完成，若这个时间片也有任务，继续往前移，直到有空闲的时间片可以执行这个任务，否则，这个任务会带来惩罚）
 * 解题步骤：
 *        根据罚时的大小进行排序，将惩罚大的放在前面。开一个数组route作为时间槽，记录每个单位时间是否有任务安排。尽量将任务安排在deadline当天完成，
 *        若当天已有任务则安排在前面最近的某一天。若在第deadline天及之前都有任务安排，先不要将该任务加入到时间槽中（可能产生后效性），可以将这个任务舍去，同时，
 *        将其增加到罚时中，等到对全部的任务过滤一遍后，可以将罚时的任务随意地插入到时间槽中 （既然都有罚时了，那么在截止时间后的任何一个时间片，完成该任务都一样）
 */
public class Main {
    static class Task{
        private int id;
        private int deadline;
        private int weight;

        public Task(int id, int deadline, int weight) {
            this.id = id;
            this.deadline = deadline;
            this.weight = weight;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDeadline() {
            return deadline;
        }

        public void setDeadline(int deadline) {
            this.deadline = deadline;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        int n = 7; // 任务数量
        int[] deadline = new int[]{4,2,4,3,1,4,6}; // 任务期限，范围是闭区间[1,n]
        int[] weight = new int[]{70,60,50,40,30,20,10}; // 任务未按时完成的惩罚
        Task[] tasks=new Task[n];
        for(int i=0;i<tasks.length;++i){
            tasks[i]=new Task(i,deadline[i]-1,weight[i]);
        }
        greedyTaskDispatch(tasks);
    }

    private static void greedyTaskDispatch(Task[] tasks) {
        int[] route=new int[tasks.length]; // 记录任务的最终调度顺序
        Arrays.fill(route,-1);
        Arrays.sort(tasks,new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                return o2.getWeight() - o1.getWeight();
            }
        });
        int right=0;
        int punishment =0;
        while(right<tasks.length){
            int temp=tasks[right].getDeadline();
            while(temp>=0&&route[temp]!=-1){
                temp--;
            }
            if(temp<0){
                punishment +=tasks[right].getWeight();
            }else{
                route[temp]=tasks[right].getId();
            }
            right++;
        }
        System.out.println("总的惩罚为：" + punishment);
        System.out.println("任务执行顺序为：");
        for(int i = 0; i < route.length; ++i) {
            System.out.print("第" + (i+1) + "天执行的任务为：");
            if(route[i] != -1) {
                System.out.println(" " + tasks[route[i]].getId());
            }
            else {
                System.out.println("任选一个已超时任务执行");
            }
        }
    }
}
