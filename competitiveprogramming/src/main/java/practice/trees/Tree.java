package practice.trees;

public class Tree {
    int val;
    Tree left;
    Tree right;
Tree(){

}
    Tree(int item) {
        val = item;
        left = right = null;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
