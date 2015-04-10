/**
 * Copyleft (C) KRT, 2015 by kiterunner_t
 */

/*
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */


public class AddTwoNumbers {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, 0, null);
  }


  private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry, ListNode result) {
    if (l1==null && l2==null) {
      if (carry != 0) {
        ListNode n = new ListNode(carry);
        if (result != null) {
          result.next = n;
        }
        return n;
      }
      return null;
    }

    int v1 = (l1!=null) ? l1.val : 0;
    int v2 = (l2!=null) ? l2.val : 0;
    int v = v1 + v2 + carry;
    int newCarry = v / 10;
    v = v % 10;
    ListNode n = new ListNode(v);
    if (result != null) {
      result.next = n;
    }

    addTwoNumbers((l1!=null) ? l1.next : null, (l2!=null) ? l2.next : null, newCarry, n);
    return n;
  }


  public ListNode create(int[] numbers) {
    ListNode l = null;
    ListNode prev = null;
    ListNode current = null;
    for (int n: numbers) {
      current = new ListNode(n);
      if (prev == null) {
        l = current;
      } else {
        prev.next = current;
      }
      prev = current;
    }

    return l;
  }


  public static void compare(ListNode src, ListNode dst) {
    System.out.println("---------------------------");
    ListNode d = dst;
    ListNode l = src;
    boolean testResult = true;
    for ( ; l!=null && d!=null; l = l.next, d = d.next) {
      if (l.val != d.val) {
        testResult = false;
        System.out.println("not equal: " + l.val + " -> " + d.val);
        break;
      }
    }

    if (d!=null || l!=null || testResult==false) {
      System.out.println("NOT OK");
    } else {
      System.out.println("OK");
    }
    System.out.println("");
  }
  

  public static void main(String[] args) {
    AddTwoNumbers t = new AddTwoNumbers();

    ListNode l1 = t.create(new int[]{2, 4});
    ListNode l2 = t.create(new int[]{5, 6, 4});
    ListNode result = t.addTwoNumbers(l1, l2);
    compare(result, t.create(new int[]{7, 0, 5}));

    l1 = t.create(new int[]{2, 4, 3});
    l2 = t.create(new int[]{5, 6, 4});
    result = t.addTwoNumbers(l1, l2);
    compare(result, t.create(new int[]{7, 0, 8}));

    l1 = t.create(new int[]{5});
    result = t.addTwoNumbers(l1, l1);
    compare(result, t.create(new int[]{0, 1}));
  }
}

