package org.galaxy;

import java.util.HashMap;
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
    private final Map<String, String> galacticToRomanMap = new HashMap<>();

    public int convertToNumeral(String[] roman) {
        int result = 0;
        int lastValue = 0;
        for (int i = roman.length - 1; i >= 0; i--) {
            int currentValue = romanToNumeralMap.get(String.valueOf(roman[i]));
            if (currentValue < lastValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            lastValue = currentValue;
        }
        return result;
    }

    public void mapGalacticToRoman(String galactic, String roman){
        galacticToRomanMap.put(galactic, roman);
    }

    public String[] galactic2Roman(String[] galactic){
        String[] roman = new String[galactic.length];
        for (int i = 0; i < galactic.length; i++) {
            roman[i] = galacticToRomanMap.get(galactic[i]);
        }
        return roman;
    }
}
