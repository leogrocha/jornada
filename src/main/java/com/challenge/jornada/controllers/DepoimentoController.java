package com.challenge.jornada.controllers;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.challenge.jornada.dto.DepoimentoDTO;
import com.challenge.jornada.services.DepoimentoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class DepoimentoController {

    private DepoimentoService service;
    
    @GetMapping("/depoimentos")
    public ResponseEntity<List<DepoimentoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("depoimentos/{iddepoimento}")
    public ResponseEntity<DepoimentoDTO> findById(@PathVariable Long iddepoimento) {
        return ResponseEntity.ok(service.findById(iddepoimento));
    }

    @GetMapping(("/depoimentos-home"))
    public ResponseEntity<Set<DepoimentoDTO>> findRandom() {
        return ResponseEntity.ok(service.findRandom());
    }

    @PostMapping("/depoimentos")
    public ResponseEntity<DepoimentoDTO> insert(@RequestBody @Valid DepoimentoDTO depoimentoDTO) {
        depoimentoDTO = service.insert(depoimentoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand("/{id}").toUri();
        return ResponseEntity.created(uri).body(depoimentoDTO);
    }

    @PutMapping("depoimentos/{iddepoimento}")
    public ResponseEntity<DepoimentoDTO> update(@PathVariable Long iddepoimento,@RequestBody DepoimentoDTO depoimentoDTO) {
        service.update(iddepoimento, depoimentoDTO);
        return ResponseEntity.ok(depoimentoDTO);
    }

    @DeleteMapping("depoimentos/{iddepoimento}")
    public ResponseEntity<?> delete(@PathVariable Long iddepoimento) {
        service.delete(iddepoimento);
        return ResponseEntity.noContent().build();
    }

    

}
