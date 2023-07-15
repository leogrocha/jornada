package com.challenge.jornada.dto;

import java.math.BigDecimal;

import com.challenge.jornada.entities.Destino;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record DestinoDTO(
    Long iddestino,
    @NotBlank(message = "Foto é obrigatório e não pode ser nulo ou em branco") String foto,
    @NotBlank(message = "Nome é obrigatório e não pode ser nulo ou em branco") String nome,
    @Positive(message = "Preço precisa de ser positivo") BigDecimal preco) {
        
    public DestinoDTO(Destino entity) {
        this(entity.getIddestino(),entity.getFoto(), entity.getNome(), entity.getPreco());
     }       
        

}
