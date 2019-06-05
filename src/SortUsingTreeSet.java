// Sort and remove duplicates

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUsingTreeSet {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,2,3,33,8,4,9);
        Set<Integer> treeSet = new TreeSet<>(list);
        //list.forEach(System.out::println);
        treeSet.forEach(System.out::println);
    }

}
