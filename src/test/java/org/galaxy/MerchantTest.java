package org.galaxy;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MerchantTest{

    @Test
    public void listTestFileDetails() throws IOException {
        List<String> list = Files.readAllLines(Paths.get("src/test/resources/input.txt"));

        list.forEach(System.out::println);

        assertTrue( true );
    }

    @Test
    public void testRomanToNumeric(){
        Merchant merchant = new Merchant();
        int result = merchant.convertToNumeral("MCMXLIV".split(""));
        TestCase.assertEquals(1944, result);

        result = merchant.convertToNumeral("MMVI".split(""));
        TestCase.assertEquals(2006, result);

        result = merchant.convertToNumeral("MCMIII".split(""));
        TestCase.assertEquals(1903, result);

        result = merchant.convertToNumeral("II".split(""));
        TestCase.assertEquals(2, result);

        result = merchant.convertToNumeral("XLII".split(""));
        TestCase.assertEquals(42, result);
    }

    @Test
    public void testGalacticToNumeric(){
        Merchant merchant = new Merchant();
        merchant.mapGalacticToRoman("glob", "I");
        merchant.mapGalacticToRoman("prok", "V");
        merchant.mapGalacticToRoman("pish", "X");
        merchant.mapGalacticToRoman("tegj", "L");

        int result = merchant.convertToNumeral(merchant.galactic2Roman("glob glob".split(" ")));
        TestCase.assertEquals(2, result);

        result = merchant.convertToNumeral(merchant.galactic2Roman("glob prok".split(" ")));
        TestCase.assertEquals(4, result);

        result = merchant.convertToNumeral(merchant.galactic2Roman("pish pish".split(" ")));
        TestCase.assertEquals(20, result);

        result = merchant.convertToNumeral(merchant.galactic2Roman("pish tegj glob glob".split(" ")));
        TestCase.assertEquals(42, result);

    }



}