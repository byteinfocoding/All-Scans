package top.byteinfo.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class leetcode1 {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if ((i != 0) && hashMap.containsKey(target - nums[i]))
                return new int[]{hashMap.get(target - nums[i]), i};
            hashMap.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }
}