package com.project.DigitalBank.repository;

import com.project.DigitalBank.domain.Endereco;
import com.project.DigitalBank.domain.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropostaRepositorty extends JpaRepository<Proposta, Long> {
}
