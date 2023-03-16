package com.example.numberconverter.controller;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.numberconverter.exception.InvalidRequestFormatException;
import com.example.numberconverter.exception.NotSupportedOperationException;
import com.example.numberconverter.model.ConversionRequest;
import com.example.numberconverter.model.ConversionResponse;
import com.example.numberconverter.model.ConversionTypeEnum;
import com.example.numberconverter.services.AuditTrailService;
import com.example.numberconverter.services.NumberConverter;

@RestController
public class NumberConverterController {

	private final Map<ConversionTypeEnum, NumberConverter> converterMap;
	private final AuditTrailService auditTrailService;

	public NumberConverterController(
			@Qualifier("decimalToRomanNumeralConverter") NumberConverter decimalToRomanNumeralConverter,
			@Qualifier("binaryToRomanNumeralConverter") NumberConverter binaryToRomanNumeralConverter,AuditTrailService auditTrailService) {
		converterMap = new EnumMap<>(ConversionTypeEnum.class);
		converterMap.put(ConversionTypeEnum.DECIMAL, decimalToRomanNumeralConverter);
		converterMap.put(ConversionTypeEnum.BINARY, binaryToRomanNumeralConverter);
		this.auditTrailService = auditTrailService;
	}

	/**
	 * End point for converting a number from one format to another.
	 * 
	 * @param request The conversion request containing the input number and the
	 *                conversion types.
	 * @return The conversion response containing the converted number.
	 */

	@PostMapping(path = "/convert")
	public ResponseEntity<ConversionResponse> convert(@RequestBody ConversionRequest request) {
		String input = request.getInput();
		ConversionTypeEnum to;
		ConversionTypeEnum from;
		try {
			from = request.getFrom();
			to = request.getTo();
		} catch (Exception ex) {
			throw new InvalidRequestFormatException("Request format not correct or invalid ");
		}

		NumberConverter converter = converterMap.get(from);
		if (converter == null) {
			throw new NotSupportedOperationException("Conversion not supported");
		}

		String result = converter.convert(input, from, to);
		createAuditLog(input, from, to);

		return new ResponseEntity<>(new ConversionResponse(result), HttpStatus.OK);

	}

	private void createAuditLog(String input, ConversionTypeEnum from, ConversionTypeEnum to) {
		auditTrailService.addAuditRecord( input,  from,  to);

	}
}
