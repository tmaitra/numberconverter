package com.example.numberconverter.model;

public class ConversionRequest {
	private String input;
	private ConversionTypeEnum from;
	private ConversionTypeEnum to;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public ConversionTypeEnum getFrom() {
		return from;
	}

	public void setFrom(ConversionTypeEnum from) {
		this.from = from;
	}

	public ConversionTypeEnum getTo() {
		return to;
	}

	public void setTo(ConversionTypeEnum to) {
		this.to = to;
	}

}
