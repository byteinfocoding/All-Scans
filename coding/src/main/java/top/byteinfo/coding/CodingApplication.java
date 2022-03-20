package top.byteinfo.coding;

import java.util.Arrays;

//@SpringBootApplication
public class CodingApplication {

    public static void main(String[] args) {
        int[] nums = RandomInts.RandomInts(1, 10, 10);
        int anInt = RandomInts.RandomInt(20);

        int[] twoSum = leetcode1.twoSum(nums, anInt);

        System.out.println(Arrays.toString(nums));
        System.out.println(anInt);
        System.out.println(Arrays.toString(twoSum));


    }

}
