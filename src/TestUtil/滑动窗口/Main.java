package TestUtil.滑动窗口;

/**
 * @author:why
 * @create: 2022-05-25 22:30
 * @Description: 滑动窗口
 */
public class Main {
    /*
        剑指 Offer II 011. 0 和 1 个数相同的子数组
        给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
        输入: nums = [0,1]
        输出: 2
        说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
     */
    public int findMaxLength(int[] nums) {
        int left=0;
        int right=0;
        int zero=0;
        int one=0;
        while(right<nums.length){
            if(nums[right]==0){
                zero++;
            }else{
                one++;
            }
            while(zero!=one){


                left++;
            }
            right++;
        }
        return 0;
    }
}
