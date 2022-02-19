package com.niuniu.demo.algorithm;


/**
 * @author yanghua
 * @className Logarithm
 * @package com.niuniu.dmo.algorithm
 * @describe 对数器
 * @date 2022/2/16
 */
public class Logarithm {

    //返回一个数组arr，arr长度[0 ， maxLen-1]， arr中的每个值[0 ， maxValue -1]
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static boolean equalArrays(int[] oldArr, int[] newArr) {
        for (int i = 0; i < oldArr.length; i++) {
            if (oldArr[i] != newArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int maxLen = 50;
        int maxValue = 1000;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = lenRandomValueRandom(maxLen ,maxValue);
            int[] copyArray = copyArray(arr);
        }
    }
}
