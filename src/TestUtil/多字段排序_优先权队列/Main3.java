package TestUtil.多字段排序_优先权队列;

import java.util.*;

class Field {
    //频率
    int i;
    //标题0 or 正文1
    int j;
    //先后顺序（0。。）
    int k;

    public Field() {
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public Field(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int topN = sc.nextInt();
        int M=sc.nextInt();
        sc.nextLine();
        Map<String,Field> map=new HashMap<>();
        for(int i=0;i<M;++i){
            String[] topic=sc.nextLine().split(" ");
            String[] content=sc.nextLine().split(" ");
            for (int i1 = 0; i1 < topic.length; i1++) {
                Field field = map.get(topic[i1]);
                if(field==null){
                    field=new Field(3,0,i1);
                    map.put(topic[i1],field);
                }else{
                    field.setI(field.getI()+3);
                }
            }
            for (int i1 = 0; i1 < content.length; i1++) {
                Field field = map.get(content[i1]);
                if(field==null){
                    field=new Field(1,1,i1);
                    map.put(content[i1],field);
                }else{
                    field.setI(field.getI()+1);
                }
            }
        }
        PriorityQueue<Map.Entry<String,Field>> pq=new PriorityQueue<>(new Comparator<Map.Entry<String, Field>>() {
            @Override
            public int compare(Map.Entry<String, Field> o1, Map.Entry<String, Field> o2) {
                Field value1 = o1.getValue();
                Field value2 = o2.getValue();
                if(value1.i!=value2.i){
                    return value2.i-value1.i;
                }
                if(value1.j!=value2.j){
                    return value1.j-value2.j;
                }
                return value1.k-value2.k;
            }
        });
        Set<Map.Entry<String, Field>> entrySet = map.entrySet();
        for (Map.Entry<String, Field> stringFieldEntry : entrySet) {
            pq.add(stringFieldEntry);
        }
        for(int i=0;i<topN;++i){
            if(i==topN-1){
                System.out.print(pq.poll().getKey());
            }else{
                System.out.print(pq.poll().getKey()+" ");
            }
        }
    }
}
