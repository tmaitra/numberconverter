package com.example.numberconverter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.numberconverter.exception.NotSupportedOperationException;
import com.example.numberconverter.model.ConversionTypeEnum;
import com.example.numberconverter.services.DecimalToRomanNumeralConverter;

public class DecimalToRomanNumeralConverterTest {
    
	private final DecimalToRomanNumeralConverter converter = new DecimalToRomanNumeralConverter();

    @Test
    void testConvert() {
        // Valid input
        Assertions.assertEquals("III", converter.convert("3", ConversionTypeEnum.DECIMAL, ConversionTypeEnum.ROMAN));
        Assertions.assertEquals("MCMXCIV", converter.convert("1994", ConversionTypeEnum.DECIMAL, ConversionTypeEnum.ROMAN));
        Assertions.assertEquals("CDXCIX", converter.convert("499", ConversionTypeEnum.DECIMAL, ConversionTypeEnum.ROMAN));

        // Invalid input
        Assertions.assertThrows(NumberFormatException.class, () -> converter.convert("not a number", ConversionTypeEnum.DECIMAL, ConversionTypeEnum.ROMAN));
        Assertions.assertThrows(NotSupportedOperationException.class, () -> converter.convert("10", ConversionTypeEnum.ROMAN, ConversionTypeEnum.DECIMAL));
    }

    @Test
    void testConvertEdgeCases() {
        // Lower bound
        Assertions.assertEquals("I", converter.convert("1", ConversionTypeEnum.DECIMAL, ConversionTypeEnum.ROMAN));

        // Upper bound
        Assertions.assertEquals("MMMCMXCIX", converter.convert("3999", ConversionTypeEnum.DECIMAL, ConversionTypeEnum.ROMAN));

     }
}
