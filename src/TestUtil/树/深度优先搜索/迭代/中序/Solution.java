package TestUtil.树.深度优先搜索.迭代.中序;

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

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return null;
        }
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode p=root;
        while(!stack.isEmpty()||p!=null){
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            TreeNode pop=stack.pop();
            res.add(pop.val);
            if(pop.right!=null){
                p=pop.right;
            }
        }
        return res;
    }
}