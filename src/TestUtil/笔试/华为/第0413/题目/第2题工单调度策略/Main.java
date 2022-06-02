package TestUtil.笔试.华为.第0413.题目.第2题工单调度策略;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author:why
 * @create: 2022-06-01 22:50
 * @Description:
 * 贪心策略
 *
 */
/*
    7
    1 6
    1 7
    3 2
    3 1
    2 4
    2 5
    6 1
    15

    7
    4 70
    2 60
    4 50
    3 40
    1 30
    4 20
    6 10
    210
    230
 */
public class Main {
    public static void main(String[] args) {
        fun();
    }
    public static void fun(){
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        Integer[][] order=new Integer[N][2];
        for(int i=0;i<N;++i){
            order[i][0]=sc.nextInt()-1;
            order[i][1]=sc.nextInt();
        }
        Arrays.sort(order, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[1].intValue()-o1[1].intValue();
            }
        });
        int score=0;
        int[] route=new int[N];
        int right=0;
        while(right<N){
            int temp=order[right][0];
            while(temp>=0&&route[temp]!=0){
                temp--;
            }
            if(temp>=0){
                score+=order[right][1];
                route[temp]=1;
            }
            right++;
        }
        System.out.println(score);
    }
    public static void fun2(){
         Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        Integer[][] order=new Integer[N][2];
        for(int i=0;i<N;++i){
            order[i][0]=sc.nextInt();
            order[i][1]=sc.nextInt();
        }
        Arrays.sort(order, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[0].intValue()!=o2[0].intValue()){
                    return o1[0].intValue()-o2[0].intValue();
                }
                return o2[1].intValue()-o1[1].intValue();
            }
        });
        int score=0;
        int right=0;
        int left=0;
        while(right<N){
            if(order[right][0]>left){
                score+=order[right][1];
                left++;
            }
            right++;
        }
        System.out.println(score);
    }
}
