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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.challenge.jornada.dto.DestinoDTO;
import com.challenge.jornada.services.DestinoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/destinos")
@AllArgsConstructor
public class DestinoController {

    private DestinoService service;

    
    @GetMapping
    public ResponseEntity<List<DestinoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping("/{iddestino}")
    public ResponseEntity<DestinoDTO> findById(@PathVariable Long iddestino) {
        return ResponseEntity.ok(service.findById(iddestino));
    }
    
    @GetMapping(params = "nome")
    public ResponseEntity<?> searchByList(@RequestParam(name = "nome") String nome) {
        Object searchList = service.searchByList(nome);
        return ResponseEntity.ok(searchList);
    }

    @PostMapping
    public ResponseEntity<DestinoDTO> insert(@RequestBody @Valid DestinoDTO destinoDTO) {
        destinoDTO = service.insert(destinoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand("/{id}").toUri();
        return ResponseEntity.created(uri).body(destinoDTO);
    }
    
    @PutMapping("/{iddestino}")
    public ResponseEntity<DestinoDTO> update(@PathVariable Long iddestino,@RequestBody DestinoDTO destinoDTO) {
        service.update(iddestino, destinoDTO);
        return ResponseEntity.ok(destinoDTO);
    }

    @DeleteMapping("/{iddestino}")
    public ResponseEntity<?> delete(@PathVariable Long iddestino) {
        service.delete(iddestino);
        return ResponseEntity.noContent().build();
    }


}
