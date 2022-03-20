package top.byteinfo.coding;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class leetcode2 {
    public static void main(String[] args) {
        int x = 121;
        boolean palindrome = isPalindrome(x);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        if (x==-1)
            return false;
        if (x==0)
        return false;

        if (x%10==0)
            return false;

        int tempInt = 0;
        int anInt =x;
        do {
            tempInt=10*tempInt +anInt % 10;
            anInt/=10;
        } while (anInt >= 1);
        return (x==tempInt);

    }
}
