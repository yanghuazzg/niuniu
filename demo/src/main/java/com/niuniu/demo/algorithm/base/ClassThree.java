package com.niuniu.demo.algorithm.base;

/**
 * @author yanghua
 * @className ClassThree
 * @package com.niuniu.dmo.algorithm.base
 * @describe 新手班第三节课笔记代码
 * @date 2022/2/16
 */
public class ClassThree {
    /*
     二分法
     有序数组中找到num
     有序数组中找到>=num最左的位置
     有序数组中找到<=num最右的位置
     局部最小值问题
     */

    public static boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        // 左边界
        int L = 0;
        // 右边界
        int R = arr.length - 1;
        while (L <= R) {
            // 中点位置
            int mid = (L + R) / 2;
            if (arr[mid] == num) {
                return true;
                // 如果不满足条件 L = 中点位置 +1 | R = 中点位置 -1 继续二分
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 左边界
        int L = 0;
        // 右边界
        int R = arr.length;
        // 给最后值赋默认值
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    /**
     * arr 整体无序
     * arr 任意两个相邻的数不相等
     * 1.[0] < [1] 0最小
     * 2.[N-2] > [N-1] N-1 最小
     * 3.左 > i <右 i  最小
     */
    public static int oneMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        if (N == 1) {
            return 0;
        }
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 0;
        int R = N - 1;
        int ans = -1;
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                ans = mid;
                break;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[maxLen];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxLen);
            for (int i = 0; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxLen);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    public static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left < 0 || arr[left] > arr[minIndex];
        boolean rightBigger = right >= arr.length || arr[right] > arr[minIndex];
        return leftBigger && rightBigger;
    }
}
