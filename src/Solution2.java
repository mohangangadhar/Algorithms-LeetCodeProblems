
// Anagram

import java.util.*;

public class Solution2 {
    public static void main(String[] args){
        int i =0;
        String [] strVal = {"eat","bet","met","tae","ebt"};
        SortedMap<Integer,String> srMa = new TreeMap<>();
        srMa.put(5, "hello");
        srMa.put(4, "hello");
        srMa.put(2, "hello");
        srMa.put(0, "hello");
        srMa.put(1, "hello");

        srMa.entrySet().forEach(System.out::println);

        List<String> strVal1 = new ArrayList<String>();
        strVal1 = Arrays.asList(strVal);

        //System.out.println(strVal1.indexOf("bet"));

        Map<Integer, String> newArr = new HashMap<>();
        List<String> val = new ArrayList<>();

        for(String str: strVal){
            char [] ch = str.toCharArray();
            Arrays.sort(ch);
            newArr.put(i++, String.valueOf(ch));
            val.add(String.valueOf(ch));
        }


        //System.out.println(strVal.length);
        //System.out.println(Arrays.binarySearch(strVal,0 ,strVal.length -1 , "bet"));
        //newArr.entrySet().forEach(System.out::println);

        for(String va: val){

        }


    }

}
