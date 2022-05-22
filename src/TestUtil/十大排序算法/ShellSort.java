package TestUtil.十大排序算法;

import java.util.Arrays;

/**
 * @author:why
 * @create: 2022-05-22 21:00
 * @Description: 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] input=new int[]{1,2,5,6,3,5,2,1,4,3,2};
        shellSort(input);
        System.out.println(Arrays.toString(input));
    }
    public static void shellSort(int[] arr){
        for(int gap=arr.length/2;gap>0;gap=gap/2){
            for(int i=gap;i<arr.length;i++){
                int temp=arr[i];
                int j;
                for(j=i-gap;j>=0&&arr[j]>temp;j-=gap){
                    arr[j+gap]=arr[j];
                }
                arr[j+gap]=temp;
            }
        }
    }
}
