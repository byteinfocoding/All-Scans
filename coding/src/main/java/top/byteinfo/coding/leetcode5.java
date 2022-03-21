package top.byteinfo.coding;

import java.util.HashSet;

public class leetcode5 {
    public static void main(String[] args) {
        int[] nums ={1,2,3,4};
        int[] ints= new int[nums.length];
        HashSet hashSet = new HashSet<>();
        int size =0;
        for (int i = 0,j=0; i < nums.length; i++) {
            hashSet.add(nums[i]);
            if (hashSet.size()>size)
                   ints[j++]=nums[i];
            
            size = hashSet.size();
            
        }




    }
    
    
    
}
