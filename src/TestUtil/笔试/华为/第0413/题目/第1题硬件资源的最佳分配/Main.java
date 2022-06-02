package TestUtil.笔试.华为.第0413.题目.第1题硬件资源的最佳分配;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author:why
 * @create: 2022-06-01 22:02
 * @Description:
 */
public class Main {
    /*
                4
        0,2,200,0,1
        1,3,400,0,1
        2,3,400,1,0
        3,3,300,0,1
        3 1 3 200 0 1

        3 1 2

        6
        0,2,200,0,1
        1,4,330,2,1
        2,3,400,3,1
        3,3,310,1,1
        4,3,320,8,1
        5,3,330,0,1
        3 2 3 300 9 2
        3 3 4 5

        2
        0,2,200,1,0
        1,3,400,2,1
        2 2 3 300 3 2
        0
     */
    static class Server{
        private int id;
        private int cpuCount;
        private int memSize;
        private int cpuArch;
        private int supportNp;

        public Server(int id, int cpuCount, int memSize, int cpuArch, int supportNp) {
            this.id = id;
            this.cpuCount = cpuCount;
            this.memSize = memSize;
            this.cpuArch = cpuArch;
            this.supportNp = supportNp;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCpuCount() {
            return cpuCount;
        }

        public void setCpuCount(int cpuCount) {
            this.cpuCount = cpuCount;
        }

        public int getMemSize() {
            return memSize;
        }

        public void setMemSize(int memSize) {
            this.memSize = memSize;
        }

        public int getCpuArch() {
            return cpuArch;
        }

        public void setCpuArch(int cpuArch) {
            this.cpuArch = cpuArch;
        }

        public int getSupportNp() {
            return supportNp;
        }

        public void setSupportNp(int supportNp) {
            this.supportNp = supportNp;
        }

        @Override
        public String toString() {
            return "Server{" +
                    "id=" + id +
                    ", cpuCount=" + cpuCount +
                    ", memSize=" + memSize +
                    ", cpuArch=" + cpuArch +
                    ", supportNp=" + supportNp +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt();
        sc.nextLine();
        List<Server> resources=new ArrayList<>();
        for(int i=0;i<M;++i){
            String[] split = sc.nextLine().split(",");
            int id=Integer.parseInt(split[0]);
            int cpuCount=Integer.parseInt(split[1]);
            int memSize=Integer.parseInt(split[2]);
            int cpuArch=Integer.parseInt(split[3]);
            int supportNp=Integer.parseInt(split[4]);
            resources.add(new Server(id,cpuCount,memSize,cpuArch,supportNp));
        }
        String[] strings = sc.nextLine().split(" ");
        int N=Integer.parseInt(strings[0]);
        int strategy=Integer.parseInt(strings[1]);
        int cpuCount=Integer.parseInt(strings[2]);
        int memSize=Integer.parseInt(strings[3]);
        int cpuArch=Integer.parseInt(strings[4]);
        int supportNP=Integer.parseInt(strings[5]);
        if(strategy==1){
            resources.sort(new Comparator<Server>() {
                @Override
                public int compare(Server o1, Server o2) {
                    if(Math.abs(o1.getCpuCount()-cpuCount)!=Math.abs(o2.getCpuArch()-memSize)){
                        return Math.abs(o1.getCpuCount()-cpuCount)-Math.abs(o2.getCpuArch()-memSize);
                    }
                    if(Math.abs(o1.getMemSize()-memSize)!=Math.abs(o2.getMemSize()-memSize)){
                        return Math.abs(o1.getMemSize()-memSize)-Math.abs(o2.getMemSize()-memSize);
                    }
                    return o1.getId()-o2.getId();
                }
            });

        }else {
            resources.sort(new Comparator<Server>() {
                @Override
                public int compare(Server o1, Server o2) {
                    if(Math.abs(o1.getMemSize()-memSize)!=Math.abs(o2.getMemSize()-memSize)){
                        return Math.abs(o1.getMemSize()-memSize)-Math.abs(o2.getMemSize()-memSize);
                    }
                    if(Math.abs(o1.getCpuCount()-cpuCount)!=Math.abs(o2.getCpuArch()-memSize)){
                        return Math.abs(o1.getCpuCount()-cpuCount)-Math.abs(o2.getCpuArch()-memSize);
                    }
                    return o1.getId()-o2.getId();
                }
            });
        }
        List<Integer> res=new ArrayList<>();
        for (Server resource : resources) {
            if(resource.getCpuCount()>=cpuCount&&resource.getMemSize()>=memSize&&(resource.getCpuArch()==cpuArch||cpuArch==9)&&(resource.getSupportNp()==supportNP||supportNP==2)){
                res.add(resource.getId());
                if(res.size()==N){
                    break;
                }
            }
        }
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue()-o2.intValue();
            }
        });
        System.out.print(res.size()+" ");
        for (Integer re : res) {
            System.out.print(re+" ");
        }
    }
}
