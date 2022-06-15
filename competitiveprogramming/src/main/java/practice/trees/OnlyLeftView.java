package practice.trees;

public class OnlyLeftView {

  private static int max_level = 0;

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.left.left = new Node(5);
    root.left.left.left.left = new Node(9);
    root.left.left.left.left.left = new Node(10);
    root.right.right = new Node(6);
    root.right.right.right = new Node(7);
    root.right.right.right.right = new Node(8);
    System.out.println("\n------------------Left View------------------");
    leftView(root, 1);
    System.out.println("\n------------------OUTLINE OF TREE------------------");
    treeOutline(root);
    System.out.println("\n------------------Right View------------------");
    max_level = 0;
    rightView(root, 1);
  }

  private static void treeOutline(Node root) {
    leftViewOutline(root);
    rightViewOutline(root.right);
  }

  private static void rightViewOutline(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    rightViewOutline(root.right);

  }

  private static void leftView(Node root, int level) {
    if (root == null) {
      return;
    }
    if (max_level < level) {
      System.out.print(root.data + " ");
      max_level = level;
    }
    leftView(root.left, level + 1);
    leftView(root.right, level + 1);
  }

  private static void leftViewOutline(Node root) {
    if (root == null) {
      return;
    }

    leftViewOutline(root.left);
    System.out.print(root.data + " ");
  }

  private static void rightView(Node root, int level) {
    if (root == null) {
      return;
    }
    if (max_level < level) {
      System.out.print(root.data + " ");
      max_level = level;
    }
    leftView(root.right, level + 1);
    leftView(root.left, level + 1);

  }
}
