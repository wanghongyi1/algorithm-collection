package TestUtil.笔试.华为.第0413.题目.第3题分糖果;

import java.util.Scanner;

/**
 * @author:why
 * @create: 2022-06-02 14:17
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        int sum=0;
        for(int i=0;i<n;++i){
            nums[i]=sc.nextInt();
            sum+=nums[i];
        }
        if(sum%2!=0){
            System.out.println(-1);
            return;
        }
        int target=sum/2;
        int[][] dp=new int[nums.length][target+1];
        for(int i=nums[0];i<=target;++i){
            dp[0][i]=nums[0];
        }
        for(int i=1;i<nums.length;++i){
            for(int j=0;j<=target;++j){
                if(j-nums[i]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        if(dp[nums.length-1][target]!=target){
            System.out.println(-1);
            return;
        }
        int[] choose=new int[nums.length];
        int i=nums.length-1;
        int j=target;
        while(i>0){
            if(dp[i][j]!=dp[i-1][j]){
                choose[i]=1;
                j=j-nums[i];
                --i;
            }else{
                --i;
            }
        }
        if(dp[0][j]!=0){
            choose[0]=1;
        }
        System.out.println(target);
        for(int k=0;k<choose.length;++k){
            if(choose[k]==1){
                System.out.print(nums[k]+" ");
            }
        }
        System.out.println();
        for(int k=0;k<choose.length;++k){
            if(choose[k]==0){
                System.out.print(nums[k]+" ");
            }
        }
    }
}
