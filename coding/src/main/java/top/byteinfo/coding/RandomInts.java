package top.byteinfo.coding;

import java.util.Random;

public class RandomInts {

    public static int[] RandomInts(int min ,int max, int limit ){
        Random random =new Random();

        int[] nums = random.ints(min,max).limit(limit).toArray();
        return nums;

    }

    public static int RandomInt(int max){
        Random random =new Random(11);
        return random.nextInt(max);
    }

}
