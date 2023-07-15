package com.challenge.jornada.entities;

import java.math.BigDecimal;

import com.challenge.jornada.dto.DestinoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "tb_destino")
@ToString
@EqualsAndHashCode(of = { "iddestino" })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddestino;
    @Column(columnDefinition = "TEXT") private String foto;
    private String nome;
    private BigDecimal preco;

    public Destino(DestinoDTO dto) {
        iddestino = dto.iddestino();
        foto = dto.foto();
        nome = dto.nome();
        preco = dto.preco();
    }
}
