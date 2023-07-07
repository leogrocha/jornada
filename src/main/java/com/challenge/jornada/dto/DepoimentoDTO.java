package com.challenge.jornada.dto;

import com.challenge.jornada.entities.Depoimento;

public record DepoimentoDTO(String foto, String depoimento, String nome ) {
    
    public DepoimentoDTO(Depoimento entity) {
        this(entity.getFoto(), entity.getDepoimento(), entity.getNome());
    }
}
