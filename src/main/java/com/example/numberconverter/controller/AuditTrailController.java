package com.example.numberconverter.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.numberconverter.AuditLog;
import com.example.numberconverter.services.AuditTrailService;

@RestController
public class AuditTrailController {

	private final AuditTrailService auditTrailService;

	public AuditTrailController(AuditTrailService auditTrailService) {
		this.auditTrailService = auditTrailService;
	}

	@GetMapping(path = "/audit")
	public ResponseEntity<List<AuditLog>> getAuditTrail() {
		List<AuditLog> auditRecords = auditTrailService.getAuditRecords();
		return ResponseEntity.ok(auditRecords);
	}
}
