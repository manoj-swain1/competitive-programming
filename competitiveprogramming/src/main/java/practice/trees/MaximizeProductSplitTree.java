package practice.trees;

public class MaximizeProductSplitTree {
    private static Tree maxNode=null;
    public static int solve(Tree root) {
        maxNode = root;
        int[] sum = new int[1];
        splitTreeSum(root, sum);
        return (sum[0] - maxNode.val) * maxNode.val;
    }

    private static void splitTreeSum(Tree root, int[] sum) {
        if (root == null) return;

        sum[0] += root.val;
        if (root.val > maxNode.val) {
            maxNode = root;
        }
        splitTreeSum(root.left, sum);
        splitTreeSum(root.right, sum);
    }

    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(5);
        tree.right.left = new Tree(4);
        tree.right.right = new Tree(3);
        System.out.println(solve(tree));
    }
}
