package TestUtil.动态规划.买卖股票;

/**
 * @author:why
 * @create: 2022-05-24 14:52
 * @Description: 股票问题
 */
public class Main {
    /*
        121 买卖股票的最佳时机1  -》》一直股票，1笔交易
        给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
        你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
        返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     */
    public int maxProfit(int[] prices) {
        int min= Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;++i){
            min=Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }

    /*
        122买卖股票的最佳时机2  -》》一支股票，无限次交易
        给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
        在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
        返回 你能获得的 最大 利润 。
     */
    public int maxProfit2(int[] prices) {
        int[][] dp=new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<prices.length;++i){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
    /*
        123买卖股票的最佳时机 III  -》》一支股票，两笔交易
        给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
        设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    public int maxProfit3(int[] prices) {
        int[][][] dp=new int[prices.length][3][2];
        for(int i=0;i<prices.length;++i){
            for(int k=2;k>=1;--k){
                if(i-1==-1){
                    dp[i][k][0]=0;
                    dp[i][k][1]=-prices[0];
                    continue;
                }
                dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[prices.length-1][2][0];
    }
    /*
        188 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
        设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    public int maxProfit4(int k,int[] prices) {
        int[][][] dp=new int[prices.length][3][2];
        for(int i=0;i<prices.length;++i){
            for(int j=k;j>=1;--j){
                if(i-1==-1){
                    dp[i][j][0]=0;
                    dp[i][j][1]=-prices[0];
                    continue;
                }
                dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[prices.length-1][2][0];
    }
    /*
        309
        给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
       设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    public int maxProfit5(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<prices.length;++i){
            if(i-1==-1){
                dp[0][0]=0;
                dp[0][1]=-prices[0];
                continue;
            }
            if(i-2==-1){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
                continue;
            }
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    /*
        714
        给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
返回获得利润的最大值。
     */
    public int maxProfit6(int[] prices, int fee) {
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<prices.length;++i){
            if(i-1==-1){
                dp[0][0]=0;
                dp[0][1]=-prices[0]-fee;
                continue;
            }
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
        }
        return dp[prices.length-1][0];
    }
    /*
        真题：
     */
    public int maxProfit7(int[] prices, int fee) {
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<prices.length;++i){
            if(i-1==-1){
                dp[0][0]=0;
                dp[0][1]=-prices[0]-fee;
                continue;
            }
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
        }
        return dp[prices.length-1][0];
    }
}
