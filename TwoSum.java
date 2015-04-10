/**
 * Copyleft (C) KRT, 2015 by kiterunner_t
 */

/*
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 *
 * The function twoSum should return indices of the two numbers such that
 * they add up to the target, where index1 must be less than index2. Please
 * note that your returned answers (both index1 and index2) are not
 * zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

import java.util.HashMap;
import java.util.Map;


public class TwoSum {
  // O(N)
  public static int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> hash = new HashMap<Integer, Integer>(10000);
    for (int i = 0; i < numbers.length; ++i) {
      hash.put(numbers[i], i);
    }

    int[] index = new int[2];
    for (int i = 0; i < numbers.length; ++i) {
      int t = target - numbers[i];
      Integer v = hash.get(t);
      if (v!=null && v!=i) {
        index[0] = i + 1;
        index[1] = v + 1;
        break;
      }
    }

    return index;
  }


  public static void compare(int[] num1, int[] num2) {
    System.out.println("-------------------------------");
    if (num1.length != num2.length) {
      System.out.println("length is not equal");
    }

    boolean testResult = true;
    for (int i = 0; i < num1.length; i++) {
      if (num1[i] != num2[i]) {
        testResult = false;
        System.out.println("not equal in position " + i + "(" + num1[i] + ", " + num2[i] + ")");
        break;
      }
    }

    if (testResult != true) {
      System.out.println("NOT OK");
    } else {
      System.out.println("OK");
    }
    System.out.println("");
  }


  public static void main(String[] args) {
    int[] arr = new int[]{2, 7, 9, 11};
    int[] index = twoSum(arr, 9);
    compare(index, new int[]{1, 2});
  }
}

