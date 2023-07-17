package com.challenge.jornada.entities;

import com.challenge.jornada.dto.DestinoDTO;

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
@Table(name = "tb_destino")
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long iddestino;
    @Column(columnDefinition = "TEXT") private String foto1;
    @Column(columnDefinition = "TEXT") private String foto2;
    private String nome;
    @Column(columnDefinition = "VARCHAR(160)") private String meta;
    private String textoDescritivo;
    

    public Destino(DestinoDTO dto) {
        foto1 = dto.getFoto1();
        foto2 = dto.getFoto2();
        nome = dto.getNome();
        meta = dto.getMeta();
        textoDescritivo = dto.getTextoDescritivo();
    }

    public void atualizarInformacoes(DestinoDTO dados) {
        this.foto1 = dados.getFoto1() != null ? dados.getFoto1() : getFoto1();
        this.foto2 = dados.getFoto2() != null ? dados.getFoto2() : getFoto2();
        this.nome = dados.getNome() != null ? dados.getNome() : getNome();
        this.meta = dados.getMeta() != null ? dados.getMeta() : getMeta();
        this.textoDescritivo = dados.getTextoDescritivo() != null ? dados.getTextoDescritivo() : getTextoDescritivo();
    }
}
