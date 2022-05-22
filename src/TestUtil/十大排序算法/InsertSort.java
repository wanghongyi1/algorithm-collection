package TestUtil.十大排序算法;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] input=new int[]{1,2,5,6,3,5,2,1,4,3,2};
        insertSort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+",");
        }
    }
    public static void insertSort(int[] input){
        int j,value;
        for(int i=1;i<input.length;++i){
            value=input[i];
            for(j=i-1;j>=0&&value<input[j];--j){
                input[j+1]=input[j];
            }
            input[j+1]=value;
        }
    }
}
