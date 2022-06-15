package practice;

class Solution {

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carryOver = 0;
    ListNode answer = null;
    while (l1 != null || l2 != null) {
      int sum = 0;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      if (carryOver > 0) {
        sum += carryOver;
      }
      carryOver = sum / 10;
      answer = pushNewNode(answer, sum % 10);


    }

    if (carryOver > 0) {
      answer = pushNewNode(answer, carryOver);
    }
    return answer;

  }

  private ListNode pushNewNode(ListNode node, int data) {
    ListNode header = node;
    if (node == null) {
      return new ListNode(data);
    }
    while (node.next != null) {
      node = node.next;
    }
    node.next = new ListNode(data, null);
    return header;
  }
}
