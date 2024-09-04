package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;

// @author Vitalii
// @project lect2JUnit4
// @class  ConverterTest
// @version  1.0.0
// @since 21.08.2024 - 00:05

public class ConverterTest {
    // Тести на вийнятки
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForZero() {
        RomanArabicConverter.arabicToRoman(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNegativeNumber() {
        RomanArabicConverter.arabicToRoman(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForOutOfRangeNumber() {
        RomanArabicConverter.arabicToRoman(4001);
    }

    // Тести на правильність конвертації
    @Test
    public void shouldConvertSmallestRomanNumeral() {
        String result = RomanArabicConverter.arabicToRoman(1);
        assertTrue("Expected 'I' but got " + result, result.equals("I"));
    }

    @Test
    public void shouldConvertLargestRomanNumeral() {
        String result = RomanArabicConverter.arabicToRoman(3999);
        assertTrue("Expected 'MMMCMXCIX' but got " + result, result.equals("MMMCMXCIX"));
    }

    @Test
    public void shouldConvertSingleSymbolNumerals() {
        assertEquals("V", RomanArabicConverter.arabicToRoman(5));
        assertEquals("X", RomanArabicConverter.arabicToRoman(10));
    }

    @Test
    public void shouldConvertMultipleSymbolNumerals() {
        assertEquals("VIII", RomanArabicConverter.arabicToRoman(8));
        assertEquals("XII", RomanArabicConverter.arabicToRoman(12));
    }

    @Test
    public void shouldConvertNumeralsWithSubtractiveNotation() {
        assertEquals("IV", RomanArabicConverter.arabicToRoman(4));
        assertEquals("IX", RomanArabicConverter.arabicToRoman(9));
        assertEquals("XL", RomanArabicConverter.arabicToRoman(40));
    }

    @Test
    public void shouldHandleRandomNumerals() {
        String result = RomanArabicConverter.arabicToRoman(1987);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void shouldReturnCorrectLengthForGivenNumbers() {
        assertEquals(1, RomanArabicConverter.arabicToRoman(5).length());
        assertEquals(2, RomanArabicConverter.arabicToRoman(20).length());
    }

    // Тести на перевірку валідності символівв
    @Test
    public void shouldContainCharacterMForThousands() {
        String result = RomanArabicConverter.arabicToRoman(3000);
        assertTrue(result.contains("MMM"));
    }

    @Test
    public void shouldContainCharacterCForHundreds() {
        String result = RomanArabicConverter.arabicToRoman(300);
        assertTrue(result.contains("CCC"));
    }

    @Test
    public void shouldContainCharacterXForTens() {
        String result = RomanArabicConverter.arabicToRoman(30);
        assertTrue(result.contains("XXX"));
    }

    @Test
    public void shouldContainCharacterIForUnits() {
        String result = RomanArabicConverter.arabicToRoman(3);
        assertTrue(result.contains("III"));
    }

    @Test
    public void shouldCorrectlyHandleComplexNumerals() {
        assertEquals("MCMXCIV", RomanArabicConverter.arabicToRoman(1994));
        assertEquals("CDXLIV", RomanArabicConverter.arabicToRoman(444));
    }

    @Test
    public void shouldNotContainInvalidCharacters() {
        String result = RomanArabicConverter.arabicToRoman(2489);
        assertFalse(result.contains("IIII"));
        assertFalse(result.contains("VV"));
    }

    @Test
    public void shouldWorkForAllSingleDigits() {
        for (int i = 1; i <= 9; i++) {
            assertNotNull(RomanArabicConverter.arabicToRoman(i));
        }
    }

    @Test
    public void shouldConvertCommonYears() {
        assertEquals("MMXXIV", RomanArabicConverter.arabicToRoman(2024));
        assertEquals("MM", RomanArabicConverter.arabicToRoman(2000));
    }

    @Test
    public void shouldMatchExpectedPattern() {
        String result = RomanArabicConverter.arabicToRoman(1066);
        assertTrue(result.matches("[MDCLXVI]+"));
    }

    // Інші специфічні тести
    @Test
    public void shouldHandleEdgeCaseValues() {
        assertEquals("MMMCMXCIX", RomanArabicConverter.arabicToRoman(3999));
        assertEquals("I", RomanArabicConverter.arabicToRoman(1));
    }

    @Test
    public void shouldConvertLowerBoundaryValue() {
        String result = RomanArabicConverter.arabicToRoman(1);
        assertTrue("Expected 'I' but got " + result, result.equals("I"));
    }

    @Test
    public void shouldConvertUpperBoundaryValue() {
        String result = RomanArabicConverter.arabicToRoman(3999);
        assertEquals("MMMCMXCIX", result);
    }

    @Test
    public void shouldConvertMultipleOfTen() {
        assertEquals("LXXX", RomanArabicConverter.arabicToRoman(80));
        assertEquals("CL", RomanArabicConverter.arabicToRoman(150));
    }

    @Test
    public void shouldConvertMultipleOfHundred() {
        assertEquals("C", RomanArabicConverter.arabicToRoman(100));
        assertEquals("D", RomanArabicConverter.arabicToRoman(500));
    }

    @Test
    public void shouldConvertMultipleOfThousand() {
        assertEquals("M", RomanArabicConverter.arabicToRoman(1000));
        assertEquals("MM", RomanArabicConverter.arabicToRoman(2000));
    }

    @Test
    public void shouldContainOnlyRomanCharacters() {
        String result = RomanArabicConverter.arabicToRoman(1776);
        assertTrue(result.matches("[MDCLXVI]+"));
    }

    @Test
    public void shouldReturnExpectedValue() {
        String result = RomanArabicConverter.arabicToRoman(1987);
        assertEquals("MCMLXXXVII", result);
    }

    @Test
    public void shouldConvertDoubleDigitNumbers() {
        assertEquals("XXII", RomanArabicConverter.arabicToRoman(22));
        assertEquals("LVI", RomanArabicConverter.arabicToRoman(56));
    }

    @Test
    public void shouldConvertTripleDigitNumbers() {
        assertEquals("CCCLXIX", RomanArabicConverter.arabicToRoman(369));
        assertEquals("DCCCXC", RomanArabicConverter.arabicToRoman(890));
    }

    @Test
    public void shouldConvertNumberWithSubtractiveCombination() {
        assertEquals("XCIV", RomanArabicConverter.arabicToRoman(94));
        assertEquals("CDXCIX", RomanArabicConverter.arabicToRoman(499));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForZeroLikeBehavior() {
        RomanArabicConverter.arabicToRoman(0);
    }

    @Test
    public void shouldReturnEmptyStringForZero() {
        String result = null;
        try {
            result = RomanArabicConverter.arabicToRoman(0);
        } catch (IllegalArgumentException e) {
            result = "";
        }
        assertEquals("", result);
    }

    @Test
    public void shouldNotContainMoreThanThreeConsecutiveSameSymbols() {
        String result = RomanArabicConverter.arabicToRoman(3);
        assertFalse(result.contains("IIII"));
    }

    @Test
    public void shouldCorrectlyHandleEdgeCaseFor3999() {
        assertEquals("MMMCMXCIX", RomanArabicConverter.arabicToRoman(3999));
    }

    @Test
    public void shouldCorrectlyConvertNumeralWithAllSymbols() {
        String result = RomanArabicConverter.arabicToRoman(3888);
        assertTrue(result.contains("MMMDCCCLXXXVIII"));
    }

    @Test
    public void shouldConvertHighValuesCloseTo4000() {
        assertEquals("MMCMXCIV", RomanArabicConverter.arabicToRoman(2994));
        assertEquals("MMMCMXC", RomanArabicConverter.arabicToRoman(3990));
    }

    @Test
    public void shouldHandleMidRangeValuesCorrectly() {
        assertEquals("MDCCLXXVI", RomanArabicConverter.arabicToRoman(1776));
    }

    @Test
    public void shouldWorkForYear1900() {
        assertEquals("MCM", RomanArabicConverter.arabicToRoman(1900));
    }

    @Test
    public void shouldWorkForYear2000() {
        assertEquals("MM", RomanArabicConverter.arabicToRoman(2000));
    }

    @Test
    public void shouldWorkForYear2019() {
        assertEquals("MMXIX", RomanArabicConverter.arabicToRoman(2019));
    }
}