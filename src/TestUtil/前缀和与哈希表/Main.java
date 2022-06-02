package TestUtil.前缀和与哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:why
 * @create: 2022-05-31 13:33
 * @Description:
 * 解决：连续子数组和的问题
 */
public class Main {
    /*
        剑指 Offer II 011. 0 和 1 个数相同的子数组-》0--1-》求最长的连续子数组，其元素和为0
        给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
     */
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        int res=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;++i){
            if(nums[i]==0){
                count--;
            }else{
                count++;
            }
            if(map.containsKey(count)){
                res=Math.max(res,i-map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return res;
    }
}
