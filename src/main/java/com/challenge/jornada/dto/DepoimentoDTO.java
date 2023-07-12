package com.challenge.jornada.dto;

import com.challenge.jornada.entities.Depoimento;

import jakarta.validation.constraints.NotBlank;



public record DepoimentoDTO(

    Long iddepoimento,
    @NotBlank(message = "Foto é obrigatório e não pode ser nulo ou vazia") String foto,
    @NotBlank(message = "Depoimento é obrigatório e não pode ser nulo ou vazio") String depoimento,
    @NotBlank(message = "Nome é obrigatório e não pode ser nulo ou vazio") String nome) {

    public DepoimentoDTO(Depoimento entity) {
        this(entity.getIddepoimento(), entity.getFoto(), entity.getDepoimento(), entity.getNome());
    }
}
