package TestUtil.十大排序算法;

/**
 * @author:why
 * @create: 2022-05-22 11:02
 * @Description: 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 5, 6, 3, 5, 2, 1, 4, 3, 2};
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ",");
        }
    }
    public static void quickSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(input, left, right);
        quickSort(input, left, pivot - 1);
        quickSort(input, pivot + 1, right);
    }
    public static int partition(int[] input, int left, int right) {
        int i = left;
        int j = right;
        int temp = input[left];
        while (i < j) {
            while (i < j && input[j] >= temp) --j;
            if (i < j) {
                input[i] = input[j];
            }
            while (i < j && input[i] <= temp) ++i;
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[i] = temp;
        return i;
    }
}
