package com.example.numberconverter.services;

import java.util.List;

import com.example.numberconverter.AuditLog;
import com.example.numberconverter.model.ConversionTypeEnum;

public interface AuditTrailService {

	void addAuditRecord(String input, ConversionTypeEnum from, ConversionTypeEnum to);

	List<AuditLog> getAuditRecords();

}
