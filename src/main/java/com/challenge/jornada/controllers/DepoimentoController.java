package com.challenge.jornada.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.jornada.dto.DepoimentoDTO;
import com.challenge.jornada.services.DepoimentoService;

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

}
