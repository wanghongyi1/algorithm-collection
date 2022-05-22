package TestUtil.十大排序算法;

import java.util.Arrays;

/**
 * @author:why
 * @create: 2022-05-22 20:49
 * @Description: 练习
 */
public class Main {
    public static void main(String[] args) {
        int[] input={1,2,3,4,5,6,2,4,5,2,4};
        heapSort(input);
        System.out.println(Arrays.toString(input));
    }
    public static void heapSort(int[] arr){
        for(int i=arr.length/2-1;i>=0;--i){
            adjustHeap(arr,i,arr.length);
        }
        for(int i=arr.length-1;i>0;--i){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            adjustHeap(arr,0, i);
        }
    }
    public static  void adjustHeap(int[] arr,int index,int end){
        int temp=arr[index];
        for(int i=2*index+1;i<end;i=2*i+1){
            if(i+1<end&&arr[i]<arr[i+1]){
                ++i;
            }
            if(temp>=arr[i]){
                break;
            }else {
                arr[index]=arr[i];
                index=i;
            }
        }
        arr[index]=temp;
    }
}
