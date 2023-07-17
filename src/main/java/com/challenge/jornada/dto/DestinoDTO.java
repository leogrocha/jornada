package com.challenge.jornada.dto;

import com.challenge.jornada.entities.Destino;
import jakarta.validation.constraints.NotBlank;

public record DestinoDTO(
    Long iddestino,
    @NotBlank(message = "Foto é obrigatório e não pode ser nulo ou em branco") String foto1,
    @NotBlank(message = "Foto é obrigatório e não pode ser nulo ou em branco") String foto2,
    @NotBlank(message = "Nome é obrigatório e não pode ser nulo ou em branco") String nome,
    @NotBlank(message = "Meta é obrigatório e não pode ser nulo ou em branco") String meta,
    String textoDescritivo){
        
    public DestinoDTO(Destino entity) {
        this(entity.getIddestino(),entity.getFoto1(), entity.getFoto2(),entity.getNome(), entity.getMeta(), entity.getTextoDescritivo());
     }       
        

}
