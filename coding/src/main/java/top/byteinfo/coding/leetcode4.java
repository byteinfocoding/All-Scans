package top.byteinfo.coding;

public class leetcode4 {

    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};

//    String ss ="";
//    Character[] chars;
//
//        for (String str : strs) {
//            for (int i = 0; i < str.length(); i++) {
//                char c = str.charAt(0);
//
//
//            }
//
//
//        }
//        int k=0;
//        l1:
//        for (int i = 0; i < strs[0].length(); i++) {
//            for (int j = 0; j < strs.length; j++) {
//                boolean boola = strs[j].length() + 1 <i;
//                boolean boolb = strs[0].charAt(i) != strs[j].charAt(i);
//                boolean b = strs[j].length() + 1 < strs[0].length() && strs[0].charAt(i) != strs[j].charAt(i);
//
//
//                if (strs[j].length()+1<i||strs[0].charAt(i) != strs[j].charAt(i))
//                    break l1;
//            }
//            k=i;
//        }
//        System.out.println(strs[0].substring(0,k));
//        System.out.println(k);


        int k=-1;
        l1:
        for (int i = 0; i < strs[0].length(); i++) {

            for (int j =1;j < strs.length; j++) {
                if (strs[j].length() <=i||strs[0].charAt(i)!= strs[j].charAt(i) )
                    break l1;
            }
            ++k;
        }



//        return strs[0].substring(0,++k);
        System.out.println(k);


    }
}
