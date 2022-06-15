package practice.trees;

public class ListToBST {
    public Tree solve(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private Tree construct(int[] nums, int l, int r) {
        if (l > r) return null;
        int k = l + (r-l) / 2;
        Tree tree = new Tree();
        tree.val = nums[k];
        tree.left = construct(nums, l, k - 1);
        tree.right = construct(nums, k + 1, r);
        return tree;
    }

    public static void main(String[] args) {
        ListToBST listToBST = new ListToBST();
        int[] nums = {0, 1, 2, 3, 4};
        Tree root = listToBST.solve(nums);
        System.out.println(root);
    }
}
