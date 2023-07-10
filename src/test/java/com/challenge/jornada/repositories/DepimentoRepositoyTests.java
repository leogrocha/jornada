package com.challenge.jornada.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.challenge.jornada.entities.Depoimento;

@DataJpaTest
public class DepimentoRepositoyTests {

    @Autowired
    private DepoimentoRepository repository;

    @Test
    public void findByIdDeveRetornarObjetoCasoIdExista() {
        Optional<Depoimento> result = repository.findById(Long.valueOf(13));
        Assertions.assertTrue(result.isPresent());
    }
    
}
