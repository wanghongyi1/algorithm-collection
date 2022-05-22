package TestUtil.十大排序算法;

/**
 * 简单选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] input=new int[]{1,2,5,6,3,5,2,1,4,3,2};
        selectSort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+",");
        }
    }
    public static void selectSort(int[] input){
        for(int i=0;i<input.length;++i){
            int minIndex=i;
            for(int j=i+1;j<input.length;++j){
                if(input[j]<input[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                int temp=input[i];
                input[i]=input[minIndex];
                input[minIndex]=temp;
            }
        }
    }
}
