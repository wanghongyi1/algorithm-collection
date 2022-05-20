package TestUtil.二分搜索.基本二分搜索;

public class Main {
    public static void main(String[] args) {
        System.out.println(123);
        System.out.println();
        System.out.println(binarySearch(new int[]{0, 1,4, 5, 6}, -1));
    }

    /**
     * 二分搜索目标值的索引
     * @param input
     * @param x
     * @return
     */
    public static int binarySearch(int[] input,int x){
        int left=0;
        int right=input.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(input[mid]==x){
                return mid;
            }else if(input[mid]>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    /**
     * 最左侧元素索引
     * @param input
     * @param x
     * @return
     */
    public static int leftSearch(int[] input,int x){
        int left=0;
        int right= input.length;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(input[mid]==x){
                right=mid-1;
            }else if(input[mid]>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        if(left>=input.length||input[left]!=x){
            return -1;
        }
        return left;
    }

    /**
     * 最右侧元素索引
     * @param input
     * @param x
     * @return
     */
    public static int rightSearch(int[] input ,int x){
        int left=0;
        int right=input.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(input[mid]==x){
                left=mid+1;
            }else if(input[mid]>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        if(input[left]!=x||right<=0){
            return -1;
        }
        return right;
    }

}
