package TestUtil.十大排序算法;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] input=new int[]{1,2,5,6,3,5,2,1,4,3,2};
        mergeSort(input,0,input.length-1);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+",");
        }
    }
    public static void mergeSort(int[] input,int left,int right){
        if(left>=right){
            return;
        }
        int mid=(left+right)/2;
        mergeSort(input,left, mid);
        mergeSort(input,mid+1,right);
        merge(input,left,mid,right);
    }

    private static void merge(int[] input,int left,int mid,int right) {
        int[] newArr=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=right){
            if(input[i]<input[j]){
                newArr[k++]=input[i++];
            }else{
                newArr[k++]=input[j++];
            }
        }
        while (i<=mid){
            newArr[k++]=input[i++];
        }
        while(j<=right){
            newArr[k++]=input[j++];
        }
        for(int a=left;a<=right;++a){
            input[a]=newArr[a-left];
        }
    }
}
