package com.davidbharrison.restfun.num_to_english.service;

import com.davidbharrison.restfun.num_to_english.model.NumToEnglishResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NumToEnglishServiceTest {

    NumToEnglishService cut;

    @BeforeEach
    public void setup() {
        cut = new NumToEnglishService();
    }

    @Test
    public void oneTest() {
        NumToEnglishResponse resp = cut.converNumToEnglish("1");
        Assertions.assertEquals("one", resp.getNumInEnglish());
    }

    @Test
    public void twoTest() {
        NumToEnglishResponse resp = cut.converNumToEnglish("2");
        Assertions.assertEquals("two", resp.getNumInEnglish());
    }

    @Test
    public void tenTest() {
        NumToEnglishResponse resp = cut.converNumToEnglish("10");
        Assertions.assertEquals("ten", resp.getNumInEnglish());
    }

    @Test
    public void elevenTest() {
        Assertions.assertEquals("eleven",
                cut.converNumToEnglish("11").getNumInEnglish());
    }

    @Test
    public void twentyTest() {
        Assertions.assertEquals(
                "twenty",
                cut.converNumToEnglish("20").getNumInEnglish());
    }


    @Test
    public void twentyOneTest() {
        Assertions.assertEquals(
                "twenty one",
                cut.converNumToEnglish("21").getNumInEnglish());
    }

    @Test
    public void thirtyFiveTest() {
        Assertions.assertEquals(
                "thirty five",
                cut.converNumToEnglish("35").getNumInEnglish());
    }

    @Test
    public void hundredTest() {
        Assertions.assertEquals(
                "one hundred",
                cut.converNumToEnglish("100").getNumInEnglish());
    }

    @Test
    public void hundredOneTest() {
        Assertions.assertEquals(
                "one hundred one",
                cut.converNumToEnglish("101").getNumInEnglish());
    }


    @Test
    public void zeroTest() {
        Assertions.assertEquals(
                "zero",
                cut.converNumToEnglish("0").getNumInEnglish());
    }

    @Test
    public void oneThousandOneHundredTenTest() {
        Assertions.assertEquals(
                "one thousand one hundred ten",
                cut.converNumToEnglish("1110").getNumInEnglish());
    }

    @Test
    public void tenThousandTest() {
        Assertions.assertEquals(
                "ten thousand",
                cut.converNumToEnglish("10000").getNumInEnglish());
    }

    @Test
    public void oneMillionTest() {
        Assertions.assertEquals(
                "one million",
                cut.converNumToEnglish("1000000").getNumInEnglish());
    }

    @Test
    public void oneBillionTest() {
        Assertions.assertEquals(
                "one billion",
                cut.converNumToEnglish("1000000000").getNumInEnglish());
    }

    @Test
    public void wifesRandomNumberTest() {
        Assertions.assertEquals(
                "one million three hundred forty five thousand nine hundred sixty three",
                cut.converNumToEnglish("1345963").getNumInEnglish());
    }

    @Test
    public void invalid1Test() {
        Assertions.assertTrue(cut.converNumToEnglish("ABC").getStatus().startsWith("error"));
    }

    @Test
    public void invalid2Test() {
        Assertions.assertTrue(cut.converNumToEnglish("0,1").getStatus().startsWith("error"));
    }

}
