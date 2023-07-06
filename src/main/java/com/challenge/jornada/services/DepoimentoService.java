package com.challenge.jornada.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.jornada.dto.DepoimentoDTO;
import com.challenge.jornada.repositories.DepoimentoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepoimentoService {

    private DepoimentoRepository repository;

    public List<DepoimentoDTO> findAll() {
        return repository.findAll().stream().map(DepoimentoDTO::new).toList();
    }


    
}
