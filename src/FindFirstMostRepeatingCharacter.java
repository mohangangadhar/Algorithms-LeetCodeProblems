import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FindFirstMostRepeatingCharacter {
    public static void main (String[] args){
        String input = "ABABABAAAABABABBBBCCCCCCCCCBAAACCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        System.out.println(LocalDateTime.now());
        Map<String,Integer> sm = new LinkedHashMap<>();
        char[] chars = input.toCharArray();


        for(char c: chars){

            sm.merge(String.valueOf(c), 1, Integer::sum);
        }

        // Sort by values in descending order and create a new linkedHashMap

        LinkedHashMap<String,Integer> descOrderedMap = sm.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (oldVal, newVal) -> oldVal,LinkedHashMap::new ));

        // Sort by values in ascending order and create a new linkedHashMap

        LinkedHashMap<String,Integer> ascOrderedMap = sm.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (o,n) -> o, LinkedHashMap::new));


        System.out.println(sm.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)));

        System.out.println(LocalDateTime.now());
        System.out.println(ascOrderedMap);
        System.out.println("====================");
        descOrderedMap.entrySet().forEach(System.out::println);
    }
}
