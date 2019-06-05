// Input a day name and an integer, result should be the day name forwarded by the integer value

// ex :
// mon , 0   -> mon
// mon , 2   -> wed
// mon,  22  -> tue

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public static void main(String[] args){
        String val = "mon";
        Integer num = 22;
        String res = null;

        Map<String, Integer> dayMap = new HashMap<>();
        dayMap.put("mon", 0);
        dayMap.put("tue", 1);
        dayMap.put("wed", 2);
        dayMap.put("thu", 3);
        dayMap.put("fri", 4);
        dayMap.put("sat", 5);
        dayMap.put("sun", 6);

        Integer resVal = dayMap.get(val) + num % 7;
        for(Map.Entry<String,Integer> entry: dayMap.entrySet()){
            if(entry.getValue().equals(resVal)) {
                res = entry.getKey();
            }
        }

        System.out.println(res);

    }

}
