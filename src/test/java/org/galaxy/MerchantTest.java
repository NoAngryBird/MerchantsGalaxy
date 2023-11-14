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

}