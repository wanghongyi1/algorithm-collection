package TestUtil.动态规划.子序列;

import java.util.Arrays;

/**
 * @author:why
 * @create: 2022-05-27 23:03
 * @Description: 子序列
 */
public class Main {
    /*
        300 最长递增子序列
        给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1 );
        int max=1;
        for(int i=1;i<nums.length;++i){
            for(int j=i-1;j>=0;--j){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
    /*
        674 最长连续递增子序列
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1 );
        int max=1;
        for(int i=1;i<nums.length;++i){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
                max=Math.max(max,dp[i]);
            }
        }
        return max;
    }
    /*
        718. 最长重复子数组
        给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
     */
    public int findLength(int[] nums1, int[] nums2) {
        int max=0;
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        for(int i=1;i<=nums1.length;++i){
            for(int j=1;j<=nums2.length;++j){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
    /*
        1143. 最长公共子序列
        给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
        一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
        例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
        两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int i=1;i<=text1.length();++i){
            for(int j=1;j<=text2.length();++j){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    /*
        1035. 不相交的线-->最长公共子序列
        在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
        现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
        nums1[i] == nums2[j]
        且绘制的直线不与任何其他连线（非水平线）相交。
        请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
        以这种方法绘制线条，并返回可以绘制的最大连线数。
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        for(int i=1;i<=nums1.length;++i){
            for(int j=1;j<=nums2.length;++j){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[nums1.length][nums2.length];
    }
    /*
        53 最大子数组的和
            给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    子数组 是数组中的一个连续部分。
     */
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;++i){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    /*
        392 判断子序列
        给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
        字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     */
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                ++i;
            }
            ++j;
        }
        return i==s.length();
    }
    /*
        115 不同的子序列
        给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
        字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
     */
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();++i){
            dp[i][0]=1;
        }
        for(int i=1;i<=s.length();++i){
            for(int j=1;j<=t.length();++j){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
    /*
        583 两个字符串的删除操作
        给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
     */
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m][n];

        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return word1.length()+word2.length()-2*dp[m][n];
    }
    /*
        72 编辑距离
        给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
        你可以对一个单词进行如下三种操作：
            插入一个字符
            删除一个字符
            替换一个字符
     */
    public int minDistance2(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=n;++i){
            dp[0][i]=i;
        }
        for(int i=0;i<=m;++i){
            dp[i][0]=i;
        }
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    //谁搞原字符串谁就是删除
                    dp[i][j]=Math.min(Math.min(dp[i][j-1]+1  ,dp[i-1][j]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }
}
