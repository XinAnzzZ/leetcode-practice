package com.yuhangma.leetcode.practice.util;

import java.util.Random;

/**
 * @author Moore
 * @since 2020/06/06
 */
public class ArrayUtils {

    /**
     * 随机生成最大长度为 10，值在 0 - 10 之间的 int 数组
     *
     * @return 随机产生的数组
     */
    public static int[] genRandomArr() {
        return genRandomArr(10);
    }

    /**
     * 随机生成最大长度为 {@code maxLength}，值在 0 - 10 之间的 int 数组
     *
     * @param maxLength 要生成的数组的最大长度
     * @return 随机产生的数组
     */
    public static int[] genRandomArr(int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength);
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = random.nextInt(10);
        }
        return res;
    }

    /**
     * 判断两个数组是否不相等
     *
     * @param arr1 数组 1
     * @param arr2 数组 2
     * @return {@code true} when any elements is not equals.
     */
    public static boolean notEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return true;
            }
        }
        return false;
    }
}
