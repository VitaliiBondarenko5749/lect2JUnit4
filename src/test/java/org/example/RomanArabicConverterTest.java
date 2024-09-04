package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// @author Vitalii
// @project lect2JUnit4
// @class  RomanArabicConverterTest
// @version  1.0.0
// @since 04.09.2024 - 15:20

public class RomanArabicConverterTest {

    // Test 1: Просте перетворення
    @Test
    public void testBasicConversion() {
        assertEquals(10, RomanArabicConverter.romanToArabic("X"));
    }

    // Test 2: Перетворення символу нижнього реєстру
    @Test
    public void testLowercaseInput() {
        assertEquals(50, RomanArabicConverter.romanToArabic("l"));
    }

    // Test 3: Змішаний реєстр
    @Test
    public void testMixedCaseInput() {
        assertEquals(15, RomanArabicConverter.romanToArabic("xV"));
    }

    // Test 4: Складне число
    @Test
    public void testComplexNumeralWithSubtractiveNotation() {
        assertEquals(94, RomanArabicConverter.romanToArabic("XCIV"));
    }

    // Test 5: Перевірка валідності повторювальних символів
    @Test
    public void testValidInputRepeatingNumerals() {
        assertEquals(3, RomanArabicConverter.romanToArabic("III"));
    }

    // Test 6: Неправильні вхідні дані
    @Test
    public void testInvalidInputNonRomanCharacters() {
        assertThrows(IllegalArgumentException.class, () -> RomanArabicConverter.romanToArabic("ABC"));
    }

    // Test 7: Найбільша римська цифра
    @Test
    public void testLargestValidRomanNumeral() {
        assertEquals(3999, RomanArabicConverter.romanToArabic("MMMCMXCIX"));
    }

    // Test 8: Найменша римська цифра
    @Test
    public void testSmallestValidRomanNumeral() {
        assertEquals(1, RomanArabicConverter.romanToArabic("I"));
    }

    // Test 9: Пустий рядок
    @Test
    public void testEmptyStringInputReturnsZero() {
        assertEquals(0, RomanArabicConverter.romanToArabic(""));
    }

    // Test 10: Input with Multiple Subtractive Notations
    @Test
    public void testMultipleSubtractiveNotations() {
        assertEquals(1944, RomanArabicConverter.romanToArabic("MCMXLIV"));
    }
}