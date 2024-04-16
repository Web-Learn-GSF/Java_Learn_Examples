class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        int index = getMaxValueIndex(nums, 0, len-1);
        TreeNode root = new TreeNode(nums[index]);
        dfs(root.left, nums, 0, index-1);
        dfs(root.right, nums, index+1, len-1);

        String s = new String("123");

        return root;

    }

    public void dfs(TreeNode root, int[] nums, int left_index, int right_index){
        if(left_index > right_index){
            root = null;
            return;
        }

        int index = getMaxValueIndex(nums, left_index, right_index);
        // 赋值
        root = new TreeNode(nums[index]);
        dfs(root.left, nums, left_index, index-1);
        dfs(root.right, nums, index+1, right_index);

    }

    public int getMaxValueIndex(int[] nums, int start, int end){
        int max_value = -Integer.MAX_VALUE;
        int max_value_index = -1;
        for(int i = start; i<=end; i++){
            if(nums[i] > max_value){
                max_value_index = i;
                max_value = nums[i];
            }
        }
        return max_value_index;
    }
}