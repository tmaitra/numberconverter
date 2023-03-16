package com.example.numberconverter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.numberconverter.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {
}