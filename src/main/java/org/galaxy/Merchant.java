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
    private final Map<String, Double> metalToCreditMap = new HashMap<>();


    public int convertToNumeral(String[] roman) {
        int result = 0;
        int lastValue = 0;
        for (int i = roman.length - 1; i >= 0; i--) {
            if(!romanToNumeralMap.containsKey(String.valueOf(roman[i]))){
                return -1;
            }
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

    public String parseLine(String line) {
        String[] words = line.split(" ");

        if ("is".equals(words[1])) {
            mapGalacticToRoman(words[0], words[2]);
            return String.format("%s is mapped to %s (%d)", words[0], words[2], romanToNumeralMap.get(words[2]));
        } else if("Credits".equals(words[words.length-1])) {
            String[] galactic = new String[words.length - 4];
            System.arraycopy(words, 0, galactic, 0, words.length - 4);
            int value = convertToNumeral(galactic2Roman(galactic));
            String metal = words[words.length - 4];
            int credit = Integer.parseInt(words[words.length - 2]);
            metalToCreditMap.put(metal, (double) credit / value);

            return String.format("%s is %d credits", metal, metalToCreditMap.get(metal).intValue());
        }
        else if(line.startsWith("how much is")){
            String[] galactic = new String[words.length-4];
            System.arraycopy(words, 3, galactic, 0, words.length-4);
            int value = convertToNumeral(galactic2Roman(galactic));
            if(value < 0 ){
                return "I have no idea what you are talking about";
            }

            return String.join(" ", galactic) + " is " + value;
        }
        else if(line.startsWith("how many Credits is")){
            String[] galactic = new String[words.length-6];
            System.arraycopy(words, 4, galactic, 0, words.length-6);
            int value = convertToNumeral(galactic2Roman(galactic));

            if(!metalToCreditMap.containsKey(words[words.length - 2])){
                return "I have no idea what you are talking about";
            }
            double credit = value * metalToCreditMap.get(words[words.length-2]);

            return String.join(" ", galactic) + " " + words[words.length-2]+ " is " + (int)credit + " Credits";
        }
        else {
            return "I have no idea what you are talking about";
        }
    }
}
