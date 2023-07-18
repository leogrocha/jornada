package com.challenge.jornada.dto;

import java.math.BigDecimal;

import com.challenge.jornada.entities.Destino;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DestinoDTO {
    
    @EqualsAndHashCode.Include
    private Long iddestino;
    @NotBlank(message = "Foto é obrigatório e não pode ser nulo ou em branco") private String foto1;
    @NotBlank(message = "Foto é obrigatório e não pode ser nulo ou em branco") private String foto2;
    @NotBlank(message = "Nome é obrigatório e não pode ser nulo ou em branco") private String nome;
    @NotBlank(message = "Meta é obrigatório e não pode ser nulo ou em branco") private String meta;
    private String textoDescritivo;
    @Positive
    private BigDecimal preco;

        
    public DestinoDTO(Destino entity) {
        iddestino = entity.getIddestino();
        foto1 = entity.getFoto1();
        foto2 = entity.getFoto2();
        nome = entity.getNome();
        meta = entity.getMeta();
        textoDescritivo = entity.getTextoDescritivo();
        preco = entity.getPreco();
     }       
        

}
