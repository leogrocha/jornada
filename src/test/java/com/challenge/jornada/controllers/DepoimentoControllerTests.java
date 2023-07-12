package com.challenge.jornada.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.challenge.jornada.dto.DepoimentoDTO;
import com.challenge.jornada.services.DepoimentoService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepoimentoController.class)
public class DepoimentoControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DepoimentoService depoimentoService;

    @Test
    public void findByIdDeveRetornarDepoimentoDTOCasoIdExista() throws Exception{
        Long iddepoimento = Long.valueOf(13);

        DepoimentoDTO depoimentoDTO = new DepoimentoDTO(iddepoimento,"fotoTeste", "DepoimentoTeste", "nome de teste");
        
        
        Mockito.when(depoimentoService.findById(iddepoimento)).thenReturn(depoimentoDTO);
        ResultActions result = mockMvc
                .perform(get("/depoimentos/{iddepoimento}", iddepoimento).accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
    }
    
}
