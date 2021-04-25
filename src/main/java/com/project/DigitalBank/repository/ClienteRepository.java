package com.project.DigitalBank.repository;

import com.project.DigitalBank.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
