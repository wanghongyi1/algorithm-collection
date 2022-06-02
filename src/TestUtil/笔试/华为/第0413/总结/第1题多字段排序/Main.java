package TestUtil.笔试.华为.第0413.总结.第1题多字段排序;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = Integer.parseInt(scanner.nextLine());
 
        int[][] service = new int[M][5];
        for (int i = 0; i < M; i++) {
            String[] str = scanner.nextLine().split(",");
            for (int j = 0; j < 5; j++) {
                service[i][j] = Integer.parseInt(str[j]);
            }
        }
        int N = scanner.nextInt();
        int strategy = scanner.nextInt();
        int cpuCount = scanner.nextInt();
        int memSize = scanner.nextInt();
        int cpuArch = scanner.nextInt();
        int supportNP = scanner.nextInt();
 
        PriorityQueue<int[]> queue = null;
        if (strategy == 1) {
            queue = new PriorityQueue<>((o1, o2) -> {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    if (o1[2] != o2[2]) {
                        return o1[2] - o2[2];
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            });
        }
        if (strategy == 2) {
            queue = new PriorityQueue<>((o1, o2) -> {
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                } else {
                    if (o1[1] != o2[1]) {
                        return o1[1] - o2[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            });
        }
        for (int i = 0; i < M; i++) {
            if (service[i][1] >= cpuCount && service[i][2] >= memSize
                    && (service[i][3] == cpuArch || cpuArch == 9)
                    && (service[i][4] == supportNP || supportNP == 2)) {
                queue.add(service[i]);
            }
        }
        int resCount = Math.min(queue.size(), N);
        int[] res = new int[resCount];
        for (int i = 0; i < resCount; i++) {
            res[i] = queue.poll()[0];
        }
        Arrays.sort(res);
        System.out.print(resCount);
        for (int i = 0; i < resCount; i++) {
            System.out.print(" " + res[i]);
        }
    }
}