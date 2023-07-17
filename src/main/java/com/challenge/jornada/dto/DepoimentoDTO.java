package com.challenge.jornada.dto;

import com.challenge.jornada.entities.Depoimento;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DepoimentoDTO{

    @EqualsAndHashCode.Include private Long iddepoimento;
    @NotBlank(message = "Foto é obrigatório e não pode ser nulo ou vazia")
    private String foto;
    @NotBlank(message = "Depoimento é obrigatório e não pode ser nulo ou vazio")
    private String depoimento;
    @NotBlank(message = "Nome é obrigatório e não pode ser nulo ou vazio") 
    private String nome;

    public DepoimentoDTO(Depoimento entity) {
        iddepoimento = entity.getIddepoimento();
        foto = entity.getFoto();
        depoimento = entity.getDepoimento();
        nome = entity.getNome();
    }
}
