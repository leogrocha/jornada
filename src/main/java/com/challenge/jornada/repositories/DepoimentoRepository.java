package com.challenge.jornada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.jornada.entities.Depoimento;

public interface DepoimentoRepository extends JpaRepository<Depoimento, Long>{
    
}
