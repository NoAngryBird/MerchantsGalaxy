package org.galaxy;

import java.util.HashMap;
import java.util.Map;

public class Merchant {

    private final Map<String, Integer> romanToNumeralMap = new HashMap<>();

    public Merchant(){
        romanToNumeralMap.put("I", 1);
        romanToNumeralMap.put("V", 5);
        romanToNumeralMap.put("X", 10);
        romanToNumeralMap.put("L", 50);
        romanToNumeralMap.put("C", 100);
        romanToNumeralMap.put("D", 500);
        romanToNumeralMap.put("M", 1000);
    }

}
