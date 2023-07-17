package com.challenge.jornada.services;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.challenge.jornada.dto.DepoimentoDTO;
import com.challenge.jornada.entities.Depoimento;
import com.challenge.jornada.config.exceptions.ControllerNotFoundException;
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
        Depoimento depoimento = repository.findById(iddepoimento)
                .orElseThrow(() -> new ControllerNotFoundException("Recurso não encontrado"));
        return new DepoimentoDTO(depoimento);
    }

    public Long retornaNumeroAleatorio() {
        return new Random().nextLong(repository.count());
    }

    @Transactional(readOnly = true)
    public Set<DepoimentoDTO> findRandom() {
        Set<DepoimentoDTO> depoimentosSorteados = new HashSet<>();

        final int maximoNumerosParaSeremSorteados = 3;
        while (depoimentosSorteados.size() < maximoNumerosParaSeremSorteados) {
            Long numberRandom = retornaNumeroAleatorio();
            if (repository.existsById(numberRandom)) {
                depoimentosSorteados.add(findById(numberRandom));
            }
        }

        return depoimentosSorteados;
    }

    @Transactional
    public DepoimentoDTO insert(DepoimentoDTO depoimentoDTO) {
        Depoimento depoimento = new Depoimento(depoimentoDTO);
        repository.save(depoimento);
        return new DepoimentoDTO(depoimento);
    }

    @Transactional
    public DepoimentoDTO update(Long iddepoimento, DepoimentoDTO depoimentoDTO) {
        Depoimento depoimento = repository.findById(iddepoimento)
                .orElseThrow(() -> new ControllerNotFoundException("Recurso não encontrado"));
        depoimentoDTO.setIddepoimento(iddepoimento);
        depoimento.atualizarInformacoes(depoimentoDTO);
        depoimento = repository.save(depoimento);
        return new DepoimentoDTO(depoimento);
    }

    @Transactional
    public void delete(Long iddepoimento) {
        if (repository.existsById(iddepoimento)) {
            repository.deleteById(iddepoimento);
        } else {
            throw new ControllerNotFoundException("Recurso não encontrado");
        }
    }

}
