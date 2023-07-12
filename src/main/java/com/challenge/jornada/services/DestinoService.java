package com.challenge.jornada.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.jornada.config.exceptions.ControllerNotFoundException;
import com.challenge.jornada.dto.DestinoDTO;
import com.challenge.jornada.entities.Destino;
import com.challenge.jornada.repositories.DestinoRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DestinoService {

    private DestinoRepository repository;

    @Transactional(readOnly = true)
    public List<DestinoDTO> findAll() {
        return repository.findAll().stream().map(DestinoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public DestinoDTO findById(Long iddestino) {
        Destino destino = repository.findById(iddestino)
                .orElseThrow(() -> new ControllerNotFoundException("Recurso não encontrado"));
        return new DestinoDTO(destino);
    }

    @Transactional
    public DestinoDTO insert(DestinoDTO dto) {
        Destino destino = new Destino(dto);
        repository.save(destino);
        return new DestinoDTO(destino);
    }

    @Transactional
    public DestinoDTO update(Long iddestino, DestinoDTO destinoDTO) {
        Destino destino = repository.findById(iddestino)
                .orElseThrow(() -> new ControllerNotFoundException("Recurso não encontrado"));
        copiarObjeto(destinoDTO, destino);
        destino = repository.save(destino);
        return new DestinoDTO(destino);
    }
    
    @Transactional
    public void delete(Long iddestino) {
        if (repository.existsById(iddestino)) {
            repository.deleteById(iddestino);
        } else {
            throw new ControllerNotFoundException("Recurso não encontrado");
        }
    }

    public void copiarObjeto(DestinoDTO dto, Destino entity) {
        entity.setFoto(dto.foto());
        entity.setNome(dto.nome());
        entity.setPreco(dto.preco());
    }
    



    
}