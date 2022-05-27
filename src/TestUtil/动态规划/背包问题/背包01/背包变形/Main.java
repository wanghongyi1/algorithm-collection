package TestUtil.动态规划.背包问题.背包01.背包变形;

/**
 * @author:why
 * @create: 2022-05-23 14:31
 * @Description: 背包
 */
public class Main {
    /*
        416 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     */
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        int[] dp=new int[target+1];
        for(int i=0;i<nums.length;++i){
            for(int j=target;j>=nums[i];--j){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;
    }
    /*
        1049 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
        每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

        如果 x == y，那么两块石头都会被完全粉碎；
        如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
        最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
     */
    public static int lastStoneWeightII(int[] stones) {
        int sum=0;
        for (int i = 0; i < stones.length; i++) {
            sum+=stones[i];
        }
        int target=sum/2;
        int[] dp=new int[target+1];
        for(int i=0;i<stones.length;++i){
            for(int j=target;j>=stones[i];--j){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return Math.abs(dp[target]-(sum-target));
    }

    /*
        494 目标和
        给你一个整数数组 nums 和一个整数 target 。
        向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
        例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
        返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if((target+sum)%2!=0){
            return 0;
        }
        int a=(target+sum)/2;
        if(a<0){
            a=-a;
        }
        //dp[j] 表示：填满j（包括j）这么大容积的包，有dp[j]种方法
        int[] dp=new int[a+1];
        dp[0]=1;
        for(int i=0;i<nums.length;++i){
            for(int j=a;j>=nums[i];--j){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[a];
    }



}
