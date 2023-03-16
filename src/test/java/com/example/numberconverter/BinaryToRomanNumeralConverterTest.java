package com.example.numberconverter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import com.example.numberconverter.model.ConversionTypeEnum;
import com.example.numberconverter.services.BinaryToRomanNumeralConverter;
import com.example.numberconverter.services.DecimalToRomanNumeralConverter;
import com.example.numberconverter.services.NumberConverter;

@Component
public class BinaryToRomanNumeralConverterTest {

	private NumberConverter decimalToRomanNumeralConverter;

	private BinaryToRomanNumeralConverter converter;

	@BeforeEach
	void setup() {
		decimalToRomanNumeralConverter = mock(DecimalToRomanNumeralConverter.class);
		converter = new BinaryToRomanNumeralConverter(decimalToRomanNumeralConverter);
	}

	@Test
	void testConvert() {
		when(decimalToRomanNumeralConverter.convert("13", ConversionTypeEnum.DECIMAL, ConversionTypeEnum.ROMAN))
				.thenReturn("XIII");

		String result = converter.convert("1101", ConversionTypeEnum.BINARY, ConversionTypeEnum.ROMAN);
		assertEquals("XIII", result);
	}

	@Test
	void testConvertUnsupportedOperationException() {
		assertThrows(UnsupportedOperationException.class,
				() -> converter.convert("1101", ConversionTypeEnum.DECIMAL, ConversionTypeEnum.ROMAN));
	}

	@Test
	void testConvertNumberFormatException() {
		assertThrows(NumberFormatException.class,
				() -> converter.convert("123", ConversionTypeEnum.BINARY, ConversionTypeEnum.ROMAN));
	}

}