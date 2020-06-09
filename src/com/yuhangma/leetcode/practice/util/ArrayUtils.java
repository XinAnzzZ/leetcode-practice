package com.yuhangma.leetcode.practice.util;

import java.util.Random;

/**
 * @author Moore
 * @since 2020/06/06
 */
public class ArrayUtils {

    /**
     * 生成长度在 [0, 10] 区间，值在 [0, 10] 区间的随机数组
     *
     * @return 随机产生的数组
     */
    public static int[] genRandomArr() {
        return genRandomArr(10);
    }

    /**
     * 生成长度在 [0, {@code maxLength}] 区间，值在 [0, 10] 区间的随机数组
     *
     * @param maxLength 要生成的数组的最大长度
     * @return 随机产生的数组
     */
    public static int[] genRandomArr(int maxLength) {
        return genRandomArr(0, maxLength, 0, 10);
    }

    /**
     * 生成长度在 [0, 10] 区间，值在 [{@code minVal}, {@code maxVal}] 区间的随机数组
     *
     * @param minVal 数组元素最小值
     * @param maxVal 数组元素最大值
     * @return 随机数组
     */
    public static int[] genRandomArr(int minVal, int maxVal) {
        return genRandomArr(0, 10, minVal, maxVal);
    }

    /**
     * 生成长度在 [{@code minLength}, {@code maxLength}] 区间，值在 [{@code minVal}, {@code maxVal}] 区间的随机数组
     *
     * @param minLength 数组最小长度
     * @param maxLength 数组最大长度
     * @param minVal    数组元素最小值
     * @param maxVal    数组元素最大值
     * @return 随机数组
     */
    public static int[] genRandomArr(int minLength, int maxLength, int minVal, int maxVal) {
        Random random = new Random();
        int arrLength = -1;
        while (arrLength < minLength) {
            arrLength = random.nextInt(maxLength);
        }
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            int temp = Integer.MIN_VALUE;
            while (temp < minVal) {
                temp = random.nextInt(maxVal);
            }
            arr[i] = temp;
        }
        return arr;
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
