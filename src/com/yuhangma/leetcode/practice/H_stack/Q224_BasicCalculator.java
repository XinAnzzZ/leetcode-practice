package com.yuhangma.leetcode.practice.H_stack;

import java.util.ArrayDeque;

/**
 * @author Moore.Ma
 * @since 2020/06/30
 */
public class Q224_BasicCalculator {

    public static void main(String[] args) {
        Solution solution = new Q224_BasicCalculator().new Solution();
    }

    class Solution {

        public int evaluateExpr(ArrayDeque<Object> stack) {
            int res = 0;
            if (!stack.isEmpty()) {
                res = (int) stack.pop();
            }

            while (!stack.isEmpty() && !((char) stack.peek() == ')')) {
                char sign = (char) stack.pop();
                if (sign == '+') {
                    res += (int) stack.pop();
                } else {
                    res -= (int) stack.pop();
                }
            }
            return res;
        }

        public int calculate(String s) {
            int operand = 0;
            int n = 0;
            ArrayDeque<Object> stack = new ArrayDeque<>();

            for (int i = s.length() - 1; i >= 0; i--) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    operand = (int) Math.pow(10, n) * (ch - '0') + operand;
                    n += 1;
                } else if (ch != ' ') {
                    if (n != 0) {
                        stack.push(operand);
                        n = 0;
                        operand = 0;
                    }
                    if (ch == '(') {

                        int res = evaluateExpr(stack);
                        stack.pop();
                        stack.push(res);
                    } else {
                        stack.push(ch);
                    }
                }
            }
            if (n != 0) {
                stack.push(operand);
            }
            return evaluateExpr(stack);
        }
    }
}
