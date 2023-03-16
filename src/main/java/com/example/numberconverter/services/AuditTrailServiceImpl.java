package com.example.numberconverter.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.numberconverter.AuditLog;
import com.example.numberconverter.model.ConversionTypeEnum;
import com.example.numberconverter.repository.AuditLogRepository;

@Service
public class AuditTrailServiceImpl implements AuditTrailService {

	private final AuditLogRepository auditLogRepository;

	public AuditTrailServiceImpl(AuditLogRepository auditLogRepository) {
		this.auditLogRepository = auditLogRepository;
	}

	@Override
	public void addAuditRecord(String input, ConversionTypeEnum from, ConversionTypeEnum to) {
		AuditLog log = new AuditLog();
		log.setFromType(from.name());
		log.setToType(to.name());
		log.setInput(input);
		log.setCreatedOn(new Date());
		auditLogRepository.save(log);
	}

	@Override
	public List<AuditLog> getAuditRecords() {
		return auditLogRepository.findAll();
	}
}
