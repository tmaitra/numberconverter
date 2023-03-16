package com.example.numberconverter.services;

import com.example.numberconverter.model.ConversionTypeEnum;

public interface NumberConverter {
	
	String convert(String input, ConversionTypeEnum from, ConversionTypeEnum to);

}
