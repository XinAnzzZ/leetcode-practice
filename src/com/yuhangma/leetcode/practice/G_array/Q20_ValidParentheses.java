//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


package com.yuhangma.leetcode.practice.G_array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Moore.Ma
 * @since 2020/06/27
 */
public class Q20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Q20_ValidParentheses().new Solution();
        System.out.println(solution.isValid("()"));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q20_ValidParentheses().new Solution();
    }

    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            Map<Character, Character> mapping = new HashMap<Character, Character>() {{
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }};
            for (char c : s.toCharArray()) {
                if (mapping.containsKey(c)) {
                    stack.push(c);
                } else if (stack.isEmpty()) {
                    return false;
                } else if (!mapping.get(stack.peek()).equals(c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }

}
