package com.challenge.jornada.entities;

import com.challenge.jornada.dto.DepoimentoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_depoimentos")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Depoimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long iddepoimento;
    @Column(columnDefinition = "TEXT") private String foto;
    @Column(columnDefinition = "TEXT") private String depoimento;
    private String nome;

    public Depoimento(DepoimentoDTO dto) {
        foto = dto.foto();
        depoimento = dto.depoimento();
        nome = dto.nome();
    }

}
