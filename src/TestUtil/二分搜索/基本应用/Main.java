package TestUtil.二分搜索.基本应用;

public class Main {
    public static void main(String[] args) {
        System.out.println(mySqrt4(10));
    }
    public static double mySqrt4(double x) {
        double left=0;
        double right=x;
        double mid=-1;
        while(left<=right){
            double pre=mid;
            mid=left+(right-left)/2.0;
            if(mid*mid==x){
                return mid;
            }else if(mid*mid>x){
                right=mid;
            }else{
                left=mid;
            }
            if(pre==mid){
                break;
            }
        }
        return mid;
    }


    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     *
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     */
    public static int mySqrt(int x) {
        int left=0;
        int right=x;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid*mid==x){
                return mid;
            }else if(mid*mid>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return right;
    }

    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是小数,小数保留两位小数 。
     */
    public static String mySqrt3(double x) {
        double left=0;
        double right=x;
        while(left<=right){
            System.out.println(left+":"+right);
            double mid=left+(right-left)/2.0f;
            System.out.println("mid:"+mid);
            System.out.println("mid*mid"+mid*mid);
            if(mid*mid==x){
                return mid+"";
                //return String.format("%.2f", mid);
            }else if(mid*mid>x){
                right=mid;
            }else{
                left=mid;
            }
            if(right-left<Float.MIN_VALUE){
                break;
            }
        }
        return right+"";
        //return String.format("%.2f",right);
    }


    /*
        852.山脉数组的封顶索引
        符合下列属性的数组 arr 称为 山脉数组 ：
        arr.length >= 3
        存在 i（0 < i < arr.length - 1）使得：
        arr[0] < arr[1] < ... arr[i-1] < arr[i]
        arr[i] > arr[i+1] > ... > arr[arr.length - 1]
        给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left=1;
        int right=arr.length-2;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]>arr[mid+1]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    /*
        367有效的完全平方数
        给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
        进阶：不要 使用任何内置的库函数，如  sqrt 。

     */
    public boolean isPerfectSquare(int num) {
        int left=0;
        int right=num;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid*mid==num){
                return true;
            }else if(mid*mid>num){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }

}
