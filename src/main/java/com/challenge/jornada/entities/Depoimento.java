package com.challenge.jornada.entities;

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
@EqualsAndHashCode(of = { "idDepoimento" })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Depoimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) private Long idDepoimento;
    @Column(columnDefinition = "TEXT") private String foto;
    @Column(columnDefinition = "TEXT") private String depoimento;
    private String nome;

}
