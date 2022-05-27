package TestUtil.动态规划.背包问题.完全背包.最小价值;

import java.util.Arrays;

/**
 * @author:why
 * @create: 2022-05-23 20:25
 * @Description: 最小价值
 */
public class Main {
    /*
        322 零钱兑换
        给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
        计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
        你可以认为每种硬币的数量是无限的。
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<coins.length;++i){
            for(int j=1;j<=amount;++j){
                if(j>=coins[i]){
                    if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                        dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                    }
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
    /*
        279 完全平方数
        给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
        完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     */
    public static int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i*i<=n;++i){
            for(int j=i*i;j<=n;++j){
                if(dp[j-i*i]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n]==Integer.MAX_VALUE?-1:dp[n];
    }
}
