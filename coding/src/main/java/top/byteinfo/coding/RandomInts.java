package top.byteinfo.coding;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomInts {

    public static int[] RandomInts(int min ,int max, int limit ){
        Random random =new Random();

        int[] nums = random.ints(min,max).limit(limit).toArray();
        int[] nums1 = random.ints(min,max).limit(limit).map(i->i++).toArray();
        return nums;

    }

    public static int RandomInt(int max){
        Random random =new Random(11);
        return random.nextInt(max);
    }

//    public static IntStream f(int i){
//        IntStream.
//        return
//    }
}
