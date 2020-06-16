//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学


package com.yuhangma.leetcode.practice.number;

/**
 * @author Moore.Ma
 * @since 2020/06/16
 */
public class Q7_ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Q7_ReverseInteger().new Solution();
        System.out.println(solution.reverse(1001011));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q7_ReverseInteger().new Solution();
    }

    class Solution {
        public int reverse(int x) {
            int res = 0;
            int max = Integer.MAX_VALUE / 10;
            int min = Integer.MIN_VALUE / 10;
            while (x != 0) {
                int pop = x % 10;
                if (res > max || (res == max && pop > 7)) {
                    return 0;
                }
                if (res < min || (res == min && pop <= -8)) {
                    return 0;
                }
                res = res * 10 + pop;
                x /= 10;
            }
            return res;
        }
    }

}