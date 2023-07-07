package com.challenge.jornada.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.jornada.dto.DepoimentoDTO;
import com.challenge.jornada.entities.Depoimento;
import com.challenge.jornada.repositories.DepoimentoRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepoimentoService {

    private DepoimentoRepository repository;

    @Transactional(readOnly = true)
    public List<DepoimentoDTO> findAll() {
        return repository.findAll().stream().map(DepoimentoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public DepoimentoDTO findById(Long iddepoimento) {
        return repository.findById(iddepoimento).stream().map(DepoimentoDTO::new).findFirst().get();
    }

    @Transactional
    public DepoimentoDTO insert(DepoimentoDTO depoimentoDTO) {
        Depoimento depoimento = new Depoimento(depoimentoDTO);
        repository.save(depoimento);
        return new DepoimentoDTO(depoimento);
    }

    @Transactional
    public DepoimentoDTO update(Long iddepoimento, DepoimentoDTO depoimentoDTO) {
        Depoimento depoimento = repository.getReferenceById(iddepoimento);
        copiarObjeto(depoimentoDTO, depoimento);
        depoimento = repository.save(depoimento);

        return new DepoimentoDTO(depoimento);
    }

    @Transactional
    public void delete(Long iddepoimento) {
        repository.deleteById(iddepoimento);
    }


    
    public void copiarObjeto(DepoimentoDTO dto, Depoimento entity) {
        entity.setFoto(dto.foto());
        entity.setDepoimento(dto.depoimento());
        entity.setNome(dto.nome());
    }



    
    


    
}
