package com.rep.app.controller;

import com.rep.app.response.HoraAtualResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin
@RestController
@RequestMapping("/v1/rep/horaAtual")
public class HoraAtualController {

    @GetMapping
    public ResponseEntity<HoraAtualResponse> getHoraAtual() {
        LocalDateTime now = LocalDateTime.now();
        return ResponseEntity.ok(HoraAtualResponse.builder()
                .horaAtual(now.format(DateTimeFormatter.ISO_LOCAL_TIME))
                .build());
    }

}
