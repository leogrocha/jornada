package com.challenge.jornada.dto;

import com.challenge.jornada.entities.Depoimento;

public record DepoimentoDTO(Long iddepoimento, String foto, String depoimento, String nome ) {
    
    public DepoimentoDTO(Depoimento entity) {
        this(entity.getIddepoimento(), entity.getFoto(), entity.getDepoimento(), entity.getNome());
    }
}
