package com.challenge.jornada.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.challenge.jornada.dto.DepoimentoDTO;
import com.challenge.jornada.entities.Depoimento;
import com.challenge.jornada.repositories.DepoimentoRepository;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class DepoimentoServiceTests {
    
    @InjectMocks
    private DepoimentoService service;

    @Mock
    private DepoimentoRepository repository;

    @Test
    public void findByIdDeveRetornarUmDepoimentoDTOAoBuscarPorId() {
        Long iddepoimento = Long.valueOf(13);

        Depoimento depoimento = new Depoimento();
        depoimento.setIddepoimento(iddepoimento);
        depoimento.setFoto("fotoTeste");
        depoimento.setDepoimento("Depoimento de teste");
        depoimento.setNome("nome de teste");

        Mockito.when(repository.findById((Long) ArgumentMatchers.any())).thenReturn(Optional.of(depoimento));

        DepoimentoDTO depoimentoDTO = service.findById(iddepoimento);
        Assertions.assertNotNull(depoimentoDTO);

        
    }
}
