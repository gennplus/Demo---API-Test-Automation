package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void basicTest() {
        Assert.assertTrue(true, "This is just a basic test to verify the setup works");
        System.out.println("TestNG test ran successfully!");
    }

    @Test
    public void anotherBasicTest() {
        int expected = 2 + 2;
        int actual = 4;
        Assert.assertEquals(actual, expected, "Basic math should work");
    }
}