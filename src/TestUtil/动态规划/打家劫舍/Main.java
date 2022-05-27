package TestUtil.动态规划.打家劫舍;

/**
 * @author:why
 * @create: 2022-05-24 14:12
 * @Description: 打家劫舍
 * 相邻元素不能选择的问题
 */
public class Main {
    /*
        198你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
        给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int a=nums[0];
        int b=Math.max(nums[0],nums[1]);
        int res=-1;
        for(int i=2;i<nums.length;++i){
            res=Math.max(a+nums[i],b);
            a=b;
            b=res;
        }
        return res;
    }
    /*
        213 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
        给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     */
    public int rob2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(rob2_1(nums, 0, nums.length-2),rob2_1(nums,1,nums.length-1));
    }
    public int rob2_1(int[] nums,int left,int right) {
        int[] dp=new int[nums.length];
        if(left==right){
            return nums[left];
        }
        dp[left]=nums[left];
        dp[left+1]=Math.max(nums[left],nums[left+1]);
        for(int i=left+2;i<=right;++i){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[right];
    }

    /*
        337小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
        除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
        给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] ints = subRob(root);
        return Math.max(ints[0],ints[1]);
    }

    private int[] subRob(TreeNode root) {
        int[] res=new int[2];
        if(root==null){
            return res;
        }
        int[] left=subRob(root.left);
        int[] right=subRob(root.right);
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1]=left[0]+right[0]+root.val;
        return res;
    }
}
