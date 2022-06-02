package TestUtil.笔试.华为.第0406.第1题查找舆情热词语;

import java.util.*;

/**
 * @author:why
 * @create: 2022-06-02 15:21
 * @Description:
 */
public class Main {
    static class State{

        private int fre;
        private int freTopic;
        private int orderTopic;
        private int orderContent;

        public State( int fre,int freTopic,int orderTopic, int orderContent) {
            this.fre=fre;
            this.freTopic=freTopic;
            this.orderTopic = orderTopic;
            this.orderContent = orderContent;
        }
        public int getFreTopic() {
            return freTopic;
        }
        public void setFreTopic(int freTopic) {
            this.freTopic = freTopic;
        }
        public int getFre() {
            return fre;
        }
        public void setFre(int fre) {
            this.fre = fre;
        }
        public int getOrderTopic() {
            return orderTopic;
        }
        public void setOrderTopic(int orderTopic) {
            this.orderTopic = orderTopic;
        }
        public int getOrderContent() {
            return orderContent;
        }
        public void setOrderContent(int orderContent) {
            this.orderContent = orderContent;
        }
        @Override
        public String toString() {
            return "State{" +
                    "fre=" + fre +
                    ", freTopic=" + freTopic +
                    ", orderTopic=" + orderTopic +
                    ", orderContent=" + orderContent +
                    '}';
        }
    }
    /*
        3 2
        xinguan feiyan xinzeng bendi quezhen anli
        ju baodao chengdu xinzeng xinguan feiyan bendi quezhen anli yili shenzhen xinzeng bendi quezhen anli liangli yiqing zhengti kongzhi lianghao
        xinguan yimiao linchuang shiyan
        wuzhong xinguan yimiao tongguo sanqi linchuang shiyan xiaoguo lianghao

        xinguan xinzeng bendi

        3 2
        p b c a
        t y u i
        a b c
        o u n
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int topN=sc.nextInt();
        int M=sc.nextInt();
        Map<String,State> map=new HashMap<>();
        sc.nextLine();
        for(int i=0;i<M;++i){
            String topic=sc.nextLine();
            String[] topics = topic.split(" ");
            for (int j = 0; j < topics.length; j++) {
                State state = map.get(topics[j]);
                if(state==null){
                    map.put(topics[j],new State(3,1,j,Integer.MAX_VALUE));
                }else {
                    state.setFre(state.getFre()+3);
                    state.setFreTopic(state.getFreTopic()+1);
                    state.setOrderTopic(Math.min(j,state.getOrderTopic()));
                }
            }
            String content=sc.nextLine();
            String[] contents = content.split(" ");
            for (int j = 0; j < contents.length; j++) {
                State state = map.get(contents[j]);
                if(state==null){
                    map.put(contents[j],new State(1,0,Integer.MAX_VALUE,j));
                }else {
                    state.setFre(state.getFre()+1);
                    state.setOrderContent(Math.min(j,state.getOrderContent()));
                }
            }
        }
        Queue<Map.Entry<String,State>> pq=new PriorityQueue<>(new Comparator<Map.Entry<String, State>>(){
            @Override
            public int compare(Map.Entry<String, State> o1, Map.Entry<String, State> o2) {
                State s1=o1.getValue();
                State s2=o2.getValue();
                if(s1.getFre()!=s2.getFre()){
                    return s2.getFre()-s1.getFre();
                }
                if(s1.getFreTopic()!=s2.getFreTopic()){
                    return s2.getFreTopic()-s1.getFreTopic();
                }
                if(s1.getOrderTopic()!=s2.getOrderTopic()){
                    return s1.getOrderTopic()-s2.getOrderTopic();
                }
                return s1.getOrderContent()-s2.getOrderContent();
            }
        });
        Set<Map.Entry<String,State>> entrySet=map.entrySet();
        for(Map.Entry<String,State> entry : entrySet){
            pq.add(entry);
        }
        while(!pq.isEmpty()){
            Map.Entry<String, State> poll = pq.poll();
            System.out.println(poll.getKey()+":"+poll.getValue());
        }
        /*for(int i=0;i<topN;++i){
            System.out.print(pq.poll().getKey()+" ");
        }*/
    }
}
