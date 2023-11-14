package org.galaxy;

import java.util.Map;

public class Merchant {

    private final Map<String, Integer> romanToNumeralMap = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000);

    public int convertToNumeral(String roman) {
        int result = 0;
        int lastValue = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            int currentValue = romanToNumeralMap.get(String.valueOf(roman.charAt(i)));
            if (currentValue < lastValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            lastValue = currentValue;
        }
        return result;
    }
}
