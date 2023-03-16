package com.example.numberconverter.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.numberconverter.model.ConversionTypeEnum;

@Component
@Qualifier("binaryToRomanNumeralConverter")
public class BinaryToRomanNumeralConverter implements NumberConverter {

	private final NumberConverter decimalToRomanNumeralConverter;

	public BinaryToRomanNumeralConverter(
			@Qualifier("decimalToRomanNumeralConverter") NumberConverter decimalToRomanNumeralConverter) {
		this.decimalToRomanNumeralConverter = decimalToRomanNumeralConverter;
	}

	@Override
	public String convert(String input, ConversionTypeEnum from, ConversionTypeEnum to) {

		if (!ConversionTypeEnum.BINARY.equals(from) || !ConversionTypeEnum.ROMAN.equals(to)) {
			throw new UnsupportedOperationException("Conversion not supported.");
		}

		int decimal = Integer.parseInt(input, 2);

		return decimalToRomanNumeralConverter.convert(String.valueOf(decimal), ConversionTypeEnum.DECIMAL,
				ConversionTypeEnum.ROMAN);
	}
}
