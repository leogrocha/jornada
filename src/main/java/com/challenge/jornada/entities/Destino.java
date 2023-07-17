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
        foto1 = dto.foto1();
        foto2 = dto.foto2();
        nome = dto.nome();
        meta = dto.meta();
        textoDescritivo = dto.textoDescritivo();
    }

    public void atualizarInformacoes(DestinoDTO dados) {
        this.foto1 = dados.foto1() != null ? dados.foto1() : getFoto1();
        this.foto2 = dados.foto2() != null ? dados.foto2() : getFoto2();
        this.nome = dados.nome() != null ? dados.nome() : getNome();
        this.meta = dados.meta() != null ? dados.meta() : getMeta();
        this.textoDescritivo = dados.textoDescritivo() != null ? dados.textoDescritivo() : getTextoDescritivo();
    }
}
