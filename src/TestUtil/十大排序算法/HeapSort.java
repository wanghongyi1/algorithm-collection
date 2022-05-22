package TestUtil.十大排序算法;

import java.util.Arrays;

/**
 * @author:why
 * @create: 2022-05-22 11:41
 * @Description: 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        System.out.println("排序前" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        for(int i=arr.length/2-1;i>=0;--i){
            adjustHeap(arr,i,arr.length);
        }
        for(int i=arr.length-1;i>0;--i){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            adjustHeap(arr,0,i);
        }

    }

    private static void adjustHeap(int[] arr, int index, int end) {
        int temp=arr[index];  //取出当前元素
        for(int i=2*index+1;i<end;i=2*i+1){ //i是index的左孩子
            if(i+1<end&&arr[i]<arr[i+1]){   //i指向较大的孩子
                ++i;
            }
            if(arr[i]<=temp){  //如果子节点大于父节点
                break;
            }else{
                arr[index]=arr[i];
                index=i;
            }
        }
        arr[index]=temp;  //temp放在最终位置
    }


}
