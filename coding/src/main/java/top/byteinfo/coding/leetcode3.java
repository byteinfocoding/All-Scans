package top.byteinfo.coding;

import java.util.HashMap;

public class leetcode3 {


    public static void main(String[] args) {
        String s = "MCMXCIV";

        String[] ss = {"I", "V", "X", "L", "C", "D", "M"};
        int[] ints = {1, 5, 10, 50, 100, 500, 1000};

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            hashMap.put(ss[i].charAt(0), ints[i]);
        }

        for (String i : ss) {
            System.out.println(hashMap.get(i.charAt(0)));
        }
        System.out.println("==================================");
        int result = 0;
        /**
         *
         * 1,3, 5,  7
         * 1,10,100,1000
         * 0,1,2,3
         *
         *
         * 2,4, 6
         * 5,50,500
         * 0,1,2
         */
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (j == 0) {
                result += hashMap.get(c);
                continue;
            }
            int k = j;
            if (hashMap.get(c) <= hashMap.get(s.charAt(--k))) {
                result += hashMap.get(c);
            } else {
                int h = j;
                result += -2 * hashMap.get(s.charAt(--h)) + hashMap.get(c);
            }
        }

        System.out.println(result);


//        System.out.println(c);

    }


}
