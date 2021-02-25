package com.yuhangma.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Moore
 * @since 2020/12/21
 */
public class Solution {

    /**
     * 给定一个数组，包含 n 个数字，求出所有的三个数组和为 0 的组合
     */
    public static void main(String[] args) {
        System.out.println(force(Arrays.asList(-1, 0, 1, 2, -1, -4)));

        System.out.println(encrypt("12345678901"));
    }

    private static List<List<Integer>> run(List<Integer> numbers) {

        return null;
    }

    /**
     * 将手机号码后八位加密,每位数字都加上6,
     * 然后用和除以10的余数代替该数字，
     * 再将第一位和最后一位交换，
     * 第二位和第七位交换,依次完成交换.
     */
    private static String encrypt(String phoneNo) {
        if (phoneNo.length() != 11) {
            throw new IllegalArgumentException("");
        }
        char[] chars = phoneNo.substring(3).toCharArray();

        char[] res = new char[8];
        for (int i = 0; i < chars.length; i++) {
            int num = (Character.getNumericValue(chars[i]) + 6) % 10;
            res[7 - i] = Character.forDigit(num, 10);
        }

        return phoneNo.substring(0, 3) + new String(res);
    }

    /**
     * 暴力求解
     */
    private static List<List<Integer>> force(List<Integer> numbers) {
        List<Integer> sortedNum = numbers.stream().sorted().collect(Collectors.toList());
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < sortedNum.size() - 2; i++) {
            Integer num1 = sortedNum.get(i);
            if (i != 0 && sortedNum.get(i - 1).equals(num1)) {
                continue;
            }
            for (int j = i + 1; j < sortedNum.size() - 1; j++) {
                Integer num2 = sortedNum.get(j);
                if (num1 + num2 < 0) {
                    for (int k = j + 1; k < sortedNum.size(); k++) {
                        Integer num4 = sortedNum.get(k);
                        if (num1 + num2 + num4 > 0) {
                            break;
                        }
                        if (num1 + num2 + num4 == 0) {
                            ArrayList<Integer> triplet = new ArrayList<Integer>(3) {{
                                add(num1);
                                add(num2);
                                add(num4);
                            }};
                            res.add(triplet);
                        }
                    }
                } else {
                    break;
                }
            }
            if (num1 > 0) {
                break;
            }
        }
        return res;
    }
}
/*

//评测题目:
1. Given an array S of n integers,
  are there elements a, b, c in S such that a + b + c = 0?
  Find all unique triplets in the array which gives the sum of zero.
•   Elements in a triplet (a,b,c) must be in non-descending order.
  (ie, a ≤ b ≤ c)
•   The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},
      A solution set is:     (-1, 0, 1)     (-1, -1, 2)



private static List<List<Integer>> force(List<Integer> numbers) {
      List<Integer> sortedNum = numbers.stream().sorted().collect(Collectors.toList());
      List<List<Integer>> res = new ArrayList<>();
      for (int i = 0; i < sortedNum.size() - 2; i++) {
          Integer num1 = sortedNum.get(i);
          if (i != 0 && sortedNum.get(i - 1).equals(num1)) {
              continue;
          }
          for (int j = i + 1; j < sortedNum.size() - 1; j++) {
              Integer num2 = sortedNum.get(j);
              if (num1 + num2 < 0) {
                  for (int k = j + 1; k < sortedNum.size(); k++) {
                      Integer num4 = sortedNum.get(k);
                      if (num1 + num2 + num4 > 0) {
                          break;
                      }
                      if (num1 + num2 + num4 == 0) {
                          ArrayList<Integer> triplet = new ArrayList<Integer>(3) {{
                              add(num1);
                              add(num2);
                              add(num4);
                          }};
                          res.add(triplet);
                      }
                  }
              } else {
                  break;
              }
          }
          if (num1 > 0) {
              break;
          }
      }
      return res;
  }




 2. 客户服务平台中涉及到的用户手机(11位的数字)需要加密传输,
加密规则如下:
将手机号码后八位加密,每位数字都加上6,
  然后用和除以10的余数代替该数字，
  再将第一位和最后一位交换，
  第二位和第七位交换,依次完成交换.

private static String encrypt(String phoneNo) {
      if (phoneNo.length() != 11) {
          throw new IllegalArgumentException("");
      }
      char[] chars = phoneNo.substring(3).toCharArray();

      char[] res = new char[8];
      for (int i = 0; i < chars.length; i++) {
          int num = (Character.getNumericValue(chars[i]) + 6) % 10;
          res[7 - i] = Character.forDigit(num, 10);
      }

      return phoneNo.substring(0, 3) + new String(res);
  }


* */
