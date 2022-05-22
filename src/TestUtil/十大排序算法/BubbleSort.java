package TestUtil.十大排序算法;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] input=new int[]{1,2,5,6,3,5,2,1,4,3,2};
        bubbleSort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+",");
        }

    }
    public static void bubbleSort(int[] input){
        for(int i=0;i<input.length-1;++i){
            boolean isSorted=true;
            for(int j=0;j<input.length-1-i;++j){
                if(input[j]>input[j+1]){
                    int temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                    isSorted=false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }
}
