package TestUtil.树.序列化.层次遍历序列化;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/*
    [3,9,20,null,null,15,7]
    [1,2,3,1,null,2,null,null,null,null,null,1,null,null,null]
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input = sc.next();
        System.out.println(deserialize(input));
        System.out.println(serialize(deserialize(input)));
    }
    static String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node!=null){
                    sb.append(node.val+",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else{
                    sb.append("null,");
                }
            }
        }
        return "["+sb.substring(0, sb.length()-1)+"]";
    }
    /**
     * 修改之后的层次遍历序列化
     * @param root
     * @return
     */
    static String serialize2(TreeNode root) {
        if(root==null) return "";
        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node!=null){
                    res.add(node.val+"");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else{
                    res.add("null");
                }
            }
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            if(res.get(i).equals("null")){
                res.remove(i);
            }else{
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (int i = 0; i < res.size(); i++) {
            if(i==res.size()-1){
                sb.append(res.get(i)+"]");
            }else{
                sb.append(res.get(i)+",");
            }
        }
        return sb.toString();
    }
    static TreeNode deserialize(String input) {

        String target=input.substring(1,input.lastIndexOf(']'));
        String[] strings = target.split(",");
        TreeNode[] treeArray=new TreeNode[strings.length];
        for(int i=0;i<strings.length;++i){
            if(strings[i].equals("null")){
                treeArray[i]=null;
            }else{
                treeArray[i]=new TreeNode(Integer.parseInt(strings[i]));
            }
        }
        TreeNode root=null;
        for(int i=0;2*i+2<treeArray.length;++i){
            if(i==0){
                root=treeArray[i];
            }
            if(treeArray[i]!=null){
                treeArray[i].left=treeArray[2*i+1];
                treeArray[i].right=treeArray[2*i+2];
            }
        }
        return root;
    }
}