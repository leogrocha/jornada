package com.challenge.jornada.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.jornada.entities.Depoimento;
import com.challenge.jornada.repositories.DepoimentoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepoimentoService {

    private DepoimentoRepository repository;

    @Transactional
    public List<Depoimento> findAll() {
        return repository.findAll();
    }
    
}
