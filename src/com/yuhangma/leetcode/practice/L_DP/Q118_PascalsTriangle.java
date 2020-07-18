//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组


package com.yuhangma.leetcode.practice.L_DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Moore.Ma
 * @since 2020/07/18
 */
public class Q118_PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new Q118_PascalsTriangle().new Solution();
        System.out.println(solution.generate(5));
        testCase();
    }

    private static void testCase() {
        Solution solution = new Q118_PascalsTriangle().new Solution();
    }

    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            if (numRows == 0) {
                return res;
            }

            ArrayList<Integer> no1 = new ArrayList<Integer>() {{
                add(1);
            }};
            res.add(no1);
            for (int i = 2; i <= numRows; i++) {
                List<Integer> list = new ArrayList<>();
                List<Integer> prevList = res.get(i - 2);
                list.add(1);

                for (int j = 1; j < i - 1; j++) {
                    list.add(prevList.get(j - 1) + prevList.get(j));
                }

                list.add(1);
                res.add(list);
            }
            return res;
        }
    }

}
