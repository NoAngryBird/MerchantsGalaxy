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
        int result = merchant.convertToNumeral("MCMXLIV");
        TestCase.assertEquals(1944, result);

        result = merchant.convertToNumeral("MMVI");
        TestCase.assertEquals(2006, result);

        result = merchant.convertToNumeral("MCMIII");
        TestCase.assertEquals(1903, result);
    }

}