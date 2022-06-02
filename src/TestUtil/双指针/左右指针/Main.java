package TestUtil.双指针.左右指针;

import java.util.*;

/**
 * @author:why
 * @create: 2022-06-01 17:11
 * @Description:
 * 双指针＋有序优化
 */
public class Main {
    /*
        1. 两数之和
        给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
        你可以按任意顺序返回答案。
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
    /*
        15 三数之和
        给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
        注意：答案中不可以包含重复的三元组。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;++i){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right&&nums[left]==nums[left-1]) left++;
                    while(left<right&&nums[right]==nums[right+1]) right--;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }

    /*
        923. 三数之和的多种可能
        给定一个整数数组 arr ，以及一个整数 target 作为目标值，返回满足 i < j < k 且 arr[i] + arr[j] + arr[k] == target 的元组 i, j, k 的数量。
        由于结果会非常大，请返回 109 + 7 的模。
     */
    public int threeSumMulti(int[] nums, int target) {
        Arrays.sort(nums);
        int count=0;
        int MOD=7+(int)1e9;
        for(int i=0;i<nums.length;++i){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==target){
                    if(nums[left]==nums[right]){
                        count=count%MOD+(right-left+1)%MOD*(right-left)%MOD/2%MOD;
                        break;
                    }else{
                        left++;
                        right--;
                        int a=1;
                        int b=1;
                        while(nums[left]==nums[left-1]){
                            left++;
                            a++;
                        }
                        while(nums[right]==nums[right+1]){
                            right--;
                            b++;
                        }
                        count=count%MOD+a%MOD*b%((int)1e9+7);
                    }
                }else if(sum>target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return count;
    }

    /*
        16. 最接近的三数之和
        给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
        返回这三个数的和。
        假定每组输入只存在恰好一个解。
     */
    public int threeSumClosest(int[] nums, int target) {
        int res=-1;
        int min=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;++i){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<min){
                    min=Math.abs(sum-target);
                    res=sum;
                }
                if(sum==target){
                    return target;
                }else if(sum>target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }



    /*
        18 四树之和
        给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
        0 <= a, b, c, d < n
        a、b、c 和 d 互不相同
        nums[a] + nums[b] + nums[c] + nums[d] == target
        你可以按 任意顺序 返回答案 。
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;++i){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length;++j){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left<right&&nums[left]==nums[left-1]) left++;
                        while(left<right&&nums[right]==nums[right+1]) right--;
                    }else if(sum>target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return res;
    }
    /*
        454. 四数相加 II
        给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
        0 <= i, j, k, l < n
        nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums1.length;++i){
            for(int j=0;j<nums2.length;++j){
                int sum=nums1[i]+nums2[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int count=0;
        for(int i=0;i<nums3.length;++i){
            for(int j=0;j<nums4.length;++j){
                int target=-nums3[i]-nums4[j];
                count+=map.getOrDefault(target,0);
            }
        }
        return count;
    }


}
