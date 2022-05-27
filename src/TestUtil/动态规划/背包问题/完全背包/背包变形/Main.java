package TestUtil.动态规划.背包问题.完全背包.背包变形;

import java.util.List;

/**
 * @author:why
 * @create: 2022-05-23 19:56
 * @Description: 背包
 * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
 * 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
 */
public class Main {
    public static void main(String[] args) {

    }
    /*
        518零钱兑换II
        给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
        请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
        假设每一种面额的硬币有无限个。 
        题目数据保证结果符合 32 位带符号整数。
     */
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i = 0; i< coins.length; ++i){
            for(int j=1;j<=amount;++j){
                if(j>=coins[i]){
                    dp[j]+=dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }
    /*
        377 组合总和 Ⅳ
        给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
        题目数据保证答案符合 32 位整数范围。
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int j=1;j<=target;++j){
            for(int i=0;i<nums.length;++i){
                if(j>=nums[i]){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
    /*
        升级版爬楼梯
     */
    public int combine(int m,int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int j=1;j<=n;++j){
            for(int i=1;i<=m;++i){
                if(j>=i){
                    dp[j]+=dp[j-i];
                }
            }
        }
        return dp[n];
    }

    /*
        139 单词拆分
        给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
        注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();++i){
            for(int j=i-1;j>=0;--j){
                if(wordDict.contains(s.substring(j,i))&&dp[j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
