package TestUtil.二分搜索.高级应用;

/**
 * 1、确定 x, f(x), target 分别是什么，并写出函数 f 的代码。
 *
 * 2、找到 x 的取值范围作为二分搜索的搜索区间，初始化 left 和 right 变量。
 *
 * 3、根据题目的要求，确定应该使用搜索左侧还是搜索右侧的二分搜索算法，写出解法代码。
 */
public class Main {
    public static void main(String[] args) {

    }


    /*
    珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
    珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
    珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
    返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=(int)1e9;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(f(piles,mid)==h){
                right=mid-1;
            }else if(f(piles,mid)>h){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

    /**
     * 速度为x时，需要f(x)小时吃完香蕉
     * 单调递减
     * @param piles
     * @param x
     * @return
     */
    public static int f(int[] piles,int x){
        int hour=0;
        for (int i = 0; i < piles.length; i++) {
            hour+=(piles[i]-1)/x+1;
        }
        return hour;
    }

    /*
        1011.在D天内运送包裹的能力
        传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
        传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
        返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
     */
    public static int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;
        for (int i = 0; i < weights.length; i++) {
            left=Math.max(left, weights[i]);
            right+=weights[i];
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(f1(weights,mid)==days){
                right=mid-1;
            }else if(f1(weights,mid)>days){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    //单调递减
    public static int f1(int[] weights,int x){
        int days=1;
        int sum=0;
        for (int weight : weights) {
            if(sum+weight<=x){
                sum+=weight;
            }else {
                sum=weight;
                days++;
            }
        }
        return days;
    }
    /*
        410.分割数组的最大值
        给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
        设计一个算法使得这 m 个子数组各自和的最大值最小。
     */
    public static int splitArray(int[] nums, int m) {
        int left=0;
        int right=0;
        for (int i = 0; i < nums.length; i++) {
            left=Math.max(left,nums[i]);
            right+=nums[i];
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(f3(nums,mid)==m){
                right=mid+1;
            }else if(f3(nums,mid)>m){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    public static int f3(int[] nums,int x){
        int count=1;
        int sum=0;
        for (int num : nums) {
            if(sum+num<=x){
                sum+=num;
            }else{
                sum=num;
                count++;
            }
        }
        return count;
    }
    /*
        给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
        请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
     */
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] preSum=new int[m+1][n+1];
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                preSum[i][j]=preSum[i-1][j]+preSum[i][j-1]-preSum[i-1][j-1]+mat[i-1][j-1];

            }
        }
        int left=0;
        int right=Math.min(m,n);
        while(left<=right){
            int mid=left+(right-left)/2;
            if (check(mat,mid,threshold,preSum)) {
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right;
    }
    public boolean check(int[][] mat,int mid,int threshold,int[][] preSum){
        for(int i=0;i+mid-1<mat.length;++i){
            for(int j=0;j+mid-1<mat[0].length;++j){
                if(preSum[i+mid][j+mid]-preSum[i][j+mid]-preSum[i+mid][j]+preSum[i][j]<=threshold){
                    return true;
                }
            }
        }
        return false;
    }


}
