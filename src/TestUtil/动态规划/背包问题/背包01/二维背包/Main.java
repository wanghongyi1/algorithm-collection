package TestUtil.动态规划.背包问题.背包01.二维背包;

/**
 * @author:why
 * @create: 2022-05-23 15:17
 * @Description: 二位背包
 */
public class Main {

    /*
        474 一和零
        给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
        请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
        如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            int zero=0;
            int one=0;
            for(int j=0;j<strs[i].length();++j){
                if(strs[i].charAt(j)=='0'){
                    zero++;
                }else{
                    one++;
                }
            }
            for(int j=m;j>=zero;--j){
                for(int k=n;k>=one;--k){
                    dp[j][k]=Math.max(dp[j][k],dp[j-zero][k-one]+1);
                }
            }
        }
        return dp[m][n];
    }
}
