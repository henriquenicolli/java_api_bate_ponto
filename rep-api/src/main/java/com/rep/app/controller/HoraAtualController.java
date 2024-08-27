package com.rep.app.controller;

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
    public String getHoraAtual() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

}
