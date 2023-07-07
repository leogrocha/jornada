package com.challenge.jornada.entities;

import com.challenge.jornada.dto.DepoimentoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_depoimentos")
@ToString
@EqualsAndHashCode(of = { "iddepoimento" })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Depoimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)  private Long iddepoimento;
    @Column(columnDefinition = "TEXT") private String foto;
    @Column(columnDefinition = "TEXT") private String depoimento;
    private String nome;

    public Depoimento(DepoimentoDTO dto) {
        foto = dto.foto();
        depoimento = dto.depoimento();
        nome = dto.nome();
    }

}
