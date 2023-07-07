package com.challenge.jornada.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.challenge.jornada.dto.DepoimentoDTO;
import com.challenge.jornada.services.DepoimentoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/depoimentos")
@AllArgsConstructor
public class DepoimentoController {

    private DepoimentoService service;
    
    @GetMapping
    public ResponseEntity<List<DepoimentoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{iddepoimento}")
    public ResponseEntity<DepoimentoDTO> findById(@PathVariable Long iddepoimento) {
        return ResponseEntity.ok(service.findById(iddepoimento));
    }

    @PostMapping
    public ResponseEntity<DepoimentoDTO> insert(@Valid @RequestBody DepoimentoDTO depoimentoDTO) {
        depoimentoDTO = service.insert(depoimentoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand("/{id}").toUri();
        return ResponseEntity.created(uri).body(depoimentoDTO);
    }

    @PutMapping("/{iddepoimento}")
    public ResponseEntity<DepoimentoDTO> update(@PathVariable Long iddepoimento,@RequestBody DepoimentoDTO depoimentoDTO) {
        service.update(iddepoimento, depoimentoDTO);
        return ResponseEntity.ok(depoimentoDTO);
    }

    @DeleteMapping("/{iddepoimento}")
    public ResponseEntity<String> delete(@PathVariable Long iddepoimento) {
        service.delete(iddepoimento);
        return ResponseEntity.noContent().build();
    }

    

}
