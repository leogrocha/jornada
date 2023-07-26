package com.challenge.jornada.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.jornada.entities.Destino;

public interface DestinoRepository extends JpaRepository<Destino, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM TB_DESTINO WHERE nome ilike %:nome%")
    List<Destino> searchByList(String nome);

    // List<Destino> findByNomeIlikDestinos(String nome);
}
