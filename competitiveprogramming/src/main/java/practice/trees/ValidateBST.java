package practice.trees;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

  static boolean isValid = true;
  static Integer prev;

  public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(1);
    root.right = new Node(4);
    root.right.left = new Node(3);

    System.out.println(isValidBST(root));
  }


  public static boolean isValidBST(Node root) {

    helper(root);
    return isValid;
  }

  private static void helper(Node node) {
    if (node == null || !isValid) {
      return;
    }

    helper(node.left);
    if (null != prev && node.data <= prev) {
      isValid = false;
      return;
    }
    prev = node.data;
    helper(node.right);
    List<List<Integer>> x= new ArrayList<>();
    x.add(new ArrayList());
  }
}