package com.example.numberconverter.services;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.numberconverter.exception.NotSupportedOperationException;
import com.example.numberconverter.model.ConversionTypeEnum;

@Component
@Qualifier("decimalToRomanNumeralConverter")
public class DecimalToRomanNumeralConverter implements NumberConverter {

	private final Map<Integer, String> DECIMAL_TO_ROMAN_NUMERAL_MAP;

	public DecimalToRomanNumeralConverter() {
		DECIMAL_TO_ROMAN_NUMERAL_MAP = new LinkedHashMap<>();
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(1000, "M");
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(900, "CM");
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(500, "D");
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(400, "CD");
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(100, "C");
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(90, "XC");
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(50, "L");
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(40, "XL");
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(10, "X");
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(9, "IX");
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(5, "V");
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(4, "IV");
		DECIMAL_TO_ROMAN_NUMERAL_MAP.put(1, "I");
	}

	@Override
	public String convert(String input, ConversionTypeEnum from, ConversionTypeEnum to) {
		if (!ConversionTypeEnum.DECIMAL.equals(from)
				|| !ConversionTypeEnum.ROMAN.equals(to)) {
			throw new NotSupportedOperationException("Conversion not supported.");
		}

		int decimal = Integer.parseInt(input);
		StringBuilder roman = new StringBuilder();

		for (Map.Entry<Integer, String> entry : DECIMAL_TO_ROMAN_NUMERAL_MAP.entrySet()) {
			int num = entry.getKey();
			String numeral = entry.getValue();

			while (decimal >= num) {
				roman.append(numeral);
				decimal -= num;
			}
		}

		return roman.toString();
	}
}