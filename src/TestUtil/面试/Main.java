package TestUtil.面试;

/**
 * @author:why
 * @create: 2022-05-27 13:50
 * @Description: 面试题
 */
public class Main {
    /*
        面试题 10.11. 峰与谷
        在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
     */
    public void wiggleSort(int[] nums) {
        //f-g-f
        for(int i=1;i<nums.length;++i){
            if(i%2!=0&&nums[i]>nums[i-1]){
                swap(nums,i,i-1);
            }
            if(i%2==0&&nums[i]<nums[i-1]){
                swap(nums,i,i-1);
            }
        }
    }
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }



}
