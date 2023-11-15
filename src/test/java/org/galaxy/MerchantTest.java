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

    @Test
    public void testFileParsing()  {
        Merchant merchant = new Merchant();

        String result = merchant.parseLine("glob is I");
        TestCase.assertEquals("glob is mapped to I (1)", result);

        result = merchant.parseLine("glob glob Silver is 34 Credits");
        TestCase.assertEquals("Silver is 17 credits", result);

        result = merchant.parseLine("how much wood could a woodchuck chuck if a woodchuck could chuck wood?");
        TestCase.assertEquals("I have no idea what you are talking about", result);

        result = merchant.parseLine("how much is pish tegj glob glob ?");
        TestCase.assertEquals("I have no idea what you are talking about", result);

        merchant.mapGalacticToRoman("pish", "X");
        merchant.mapGalacticToRoman("tegj", "L");
        result = merchant.parseLine("how much is pish tegj glob glob ?");
        TestCase.assertEquals("pish tegj glob glob is 42", result);

    }

}