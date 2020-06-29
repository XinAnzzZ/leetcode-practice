//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["Q155_MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//Q155_MinStack minStack = new Q155_MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计


package com.yuhangma.leetcode.practice.H_stack;

import java.util.ArrayDeque;

/**
 * @author Moore.Ma
 * @since 2020/06/
 */
public class Q155_MinStack {
    public static void main(String[] args) {
        testCase();
    }

    private static void testCase() {

    }

    class MinStack {

        private ArrayDeque<Integer> stack;

        private ArrayDeque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int x) {
            if (stack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
            stack.push(x);
        }

        public void pop() {
            Integer pop = stack.pop();
            if (pop.equals(minStack.peek())) {
                minStack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new RuntimeException();
            }
            return stack.peek();
        }

        public int getMin() {
            if (stack.isEmpty()) {
                throw new RuntimeException();
            }
            return minStack.peek();
        }
    }

}
