package TestUtil.相邻交换;

import java.util.Scanner;

/**
 * @author:why
 * @create: 2022-05-25 10:55
 * @Description: 测试
 */
public class Demo {
    static int res = 0;

    public static void main(String[] args) {
        //----------------输入------------------//
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();

        System.out.println(exChangeTime(str, n));
    }

    public static int exChangeTime(String str, int n) {
        int c = 0;
        int j = 0;
        char[] chs = str.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chs[i] == 'C') {
                c++;
            } else {
                j++;
            }
        }
        int abs = c - j;
        if (abs == 0) {
            //说明两个一样多
            int pre = start_end(chs, n, 0, n - 1, 'J', 'C');
            int next = start_end(chs, n, 0, n - 1, 'C', 'J');
            return pre < next ? pre : next;
        } else if (abs == 1) {
            //说明C比J多
            return start_end(chs, n, 0, n - 1, 'C', 'C');
        } else if (abs == -1) {
            return start_end(chs, n, 0, n - 1, 'J', 'J');
        } else {
            return -1;
        }
    }

    public static int start_end(char[] chs, int n, int start, int end, char first, char last) {
        if (end - start <= 1) {
            return res;
        }
        for (int i = start; i <= end; i++) {
            if (chs[i] == first) {
                res = res + (i - start);
                //-----交换-------//
                char temp = chs[i];
                chs[i] = chs[start];
                chs[start] = temp;
                break;
            }
        }
        if (first == 'C') {
            first = 'J';
        } else {
            first = 'C';
        }

        for (int i = end; i >= start; i--) {
            if (chs[i] == last) {
                res = res + (end - i);
                //-----交换-------//
                char temp = chs[i];
                chs[i] = chs[end];
                chs[end] = temp;
                break;
            }
        }
        if (last == 'C') {
            last = 'J';
        } else {
            last = 'C';
        }
        return start_end(chs, n, start + 1, end - 1, first, last);
    }

}
