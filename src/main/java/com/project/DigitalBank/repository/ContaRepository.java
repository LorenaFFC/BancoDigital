package com.project.DigitalBank.repository;

import com.project.DigitalBank.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository  extends JpaRepository<Conta, Long> {
}
