package TestUtil.动态规划.背包问题.背包01.基本实现;

import java.util.Arrays;

/**
 * @author:why
 * @create: 2022-05-22 23:45
 * @Description: 01背包  每个物品只有一个，选择或者不选择
 *   01背包中二维dp数组的两个for遍历的先后循序是可以颠倒了
 *   一维dp数组的两个for循环先后循序一定是先遍历物品，再遍历背包容量。
 */
public class Main {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4,8,1};
        int[] value = {15, 20, 30,23,50};
        int bagSize = 6;
        System.out.println(weightBagProblem22(weight, value, bagSize));
    }

    /**
     * 一维数组
     * @param weight
     * @param value
     * @param bagSize
     * @return
     */
    public static int weightBagProblem1(int[] weight,int[] value,int bagSize){
        int[] dp=new int[bagSize+1];
        for(int i=0;i<weight.length;++i){
            for(int j=bagSize;j>=weight[i];--j){
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        return dp[bagSize];
    }


    /**
     * 二维数组
     * @param weight
     * @param value
     * @param bagSize
     * @return
     */
    public static int weightBagProblem2(int[] weight,int[] value,int bagSize){
        int[][] dp=new int[weight.length][bagSize+1];
        for(int i=weight[0];i<=bagSize;++i){
            dp[0][i]=value[0];
        }
        for(int i=1;i<weight.length;++i){
            for(int j=1;j<=bagSize;++j){
                //不能装下
                if(j<weight[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    //能装下，选则装与不装的最大值
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }
        return dp[weight.length-1][bagSize];
    }

    /**
     * 二维数组 记录路径
     * @param weight
     * @param value
     * @param bagSize
     * @return
     */
    public static int weightBagProblem22(int[] weight,int[] value,int bagSize){
        int[][] dp=new int[weight.length][bagSize+1];
        for(int i=weight[0];i<=bagSize;++i){
            dp[0][i]=value[0];
        }
        for(int i=1;i<weight.length;++i){
            for(int j=0;j<=bagSize;++j){
                //不能装下
                if(j<weight[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    //能装下，选则装与不装的最大值
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }
        int[] path=new int[weight.length];
        int i=weight.length-1;
        int j=bagSize;
        while(i>0){
            if(dp[i][j]!=dp[i-1][j]){
                path[i]=1;
                j-=weight[i];
            }
            --i;
        }
        if(dp[0][j]!=0){
            path[0]=1;
        }
        System.out.println(Arrays.toString(path));
        return dp[weight.length-1][bagSize];
    }
}
