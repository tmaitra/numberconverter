package com.example.numberconverter.model;

public class ConversionResponse {

	private String result;

	public ConversionResponse(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ConversionResponse [result=" + result + "]";
	}

}
