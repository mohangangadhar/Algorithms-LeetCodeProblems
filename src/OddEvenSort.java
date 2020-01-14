//Description :
//        Write a program that, given two sorted array of integers, will produce a sorted array containing all elements of both.
//        There is a special requirement:
//        Sorting must consider all even numbers to be grater than odd numbers.
//
//        Input:
//        Two comma-separated arrays of integers.
//        The two arrays are separated by a semicolon.
//
//        For example:
//        1,5,7,4:3,7,2
//
//        Output
//        The merged and sorted array formatted as comma-separated series of values. The sorting must treat all even numbers as greater than odd numbers.
//        1,3,5,7,7,2,4


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OddEvenSort {
    public static void main(String... args) {
        String s1 = "1,5,7,4:3,7,2";
        String[] ch1 = s1.split(":");
        String[] array1 = ch1[0].split(",");
        String[] array2 = ch1[1].split(",");
        List<Integer> intArr1 = new ArrayList<>();
        List<Integer> intArr2 = new ArrayList<>();

        List<Integer> oddArr = new ArrayList<>();
        List<Integer> eveArr = new ArrayList<>();

        for (String s : array1) {
            intArr1.add(Integer.parseInt(s));
        }
        for (String s : array2) {
            intArr2.add(Integer.parseInt(s));
        }

        for(int i =0 ; i < intArr1.size(); i++){
            if(intArr1.get(i) % 2 == 0){
                eveArr.add(intArr1.get(i));
            }else{
                oddArr.add(intArr1.get(i));
            }
        }

        for(int i =0 ; i < intArr2.size(); i++){
            if(intArr2.get(i) % 2 == 0){
                eveArr.add(intArr2.get(i));
            }else{
                oddArr.add(intArr2.get(i));
            }
        }

        Collections.sort(eveArr);
        Collections.sort(oddArr);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i< oddArr.size(); i++) {
            stringBuilder.append(oddArr.get(i));
            stringBuilder.append(',');
        }
        for(int i = 0; i< eveArr.size(); i++) {
            stringBuilder.append(eveArr.get(i));
            if(i != eveArr.size() -1)
                stringBuilder.append(',');
        }

        validate("1,3,5,7,7,2,4",stringBuilder.toString());
    }

    static void validate(String s1, String s2) {
        if (s1.equals(s2)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}
