package TestUtil.动态规划.背包问题.完全背包.基本实现;

/**
 * @author:why
 * @create: 2022-05-23 16:26
 * @Description: 基本实现
 * 对于一维dp数组来说，其实两个for循环嵌套顺序同样无所谓！
 */
public class Main {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        System.out.println(completePack(weight, value, bagWeight));
    }
    //先遍历物品，再遍历背包
    public static int completePack(int[] weight,int[] value,int bagSize){
        int[] dp=new int[bagSize+1];
        for(int i=0;i<weight.length;++i){
            for(int j=1;j<=bagSize;++j){
                if(j-weight[i]>=0){
                    dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
                }
            }
        }
        return dp[bagSize];
    }

}
