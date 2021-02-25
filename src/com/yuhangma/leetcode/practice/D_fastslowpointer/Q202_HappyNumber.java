//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。 
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。 
//
// 
//
// 示例： 
//
// 输入：19
//输出：true
//解释：
//1^2 + 9^2 = 82
//8^2 + 2^2 = 68
//6^2 + 8^2 = 100
//1^2 + 0^2 + 0^2 = 1
// 
// Related Topics 哈希表 数学


package com.yuhangma.leetcode.practice.D_fastslowpointer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Moore.Ma
 * @since 2020/06/11
 */
public class Q202_HappyNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(20));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Solution();
    }

    /**
     * 快慢指针
     */
    static class Solution {
        public boolean isHappy(int n) {
            int slower = n;
            int faster = calc(n);

            while (faster != 1 && slower != faster) {
                slower = calc(slower);
                faster = calc(calc(faster));
            }
            return faster == 1;
        }

        private int calc(int n) {
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                totalSum += d * d;
            }
            return totalSum;
        }
    }

    /**
     * 暴力
     */
    static class Solution2 {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            while (set.add(n)) {
                n = calc(n);
                if (n == 1) {
                    return true;
                }
            }
            return false;
        }

        private int calc(int n) {
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                totalSum += d * d;
            }
            return totalSum;
        }
    }

}