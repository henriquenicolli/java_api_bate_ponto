package com.api.app.bateponto.controller;

import com.api.app.bateponto.model.dto.ControlePontoDTO;
import com.api.app.bateponto.model.dto.RegistroPontoAtualSnapshotDTO;
import com.api.app.bateponto.model.entity.RegistroPontoEntity;
import com.api.app.bateponto.model.enums.TipoRegistro;
import com.api.app.bateponto.repository.RegistroPontoRepository;
import com.api.app.bateponto.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/bateponto")
public class ControlePontoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControlePontoController.class);

    @Autowired
    private RegistroPontoRepository registroPontoRepository;

    @PostMapping(value = "/registrar")
    public ResponseEntity<String> registrarPonto(@RequestBody ControlePontoDTO controlePontoDTO) {

        System.out.println(controlePontoDTO);

        final var registroPontoEntity = RegistroPontoEntity.builder()
                .dataHoraRegistroPonto(controlePontoDTO.getDataHoraRegistroPonto())
                .latitude(controlePontoDTO.getLatitude())
                .longitude(controlePontoDTO.getLongitude())
                .tipoRegistro(controlePontoDTO.getTipoRegistro().getCodigo())
                .build();

        registroPontoRepository.save(registroPontoEntity);

        return ResponseEntity.accepted().build();
    }


    @GetMapping(value = "/registros/{mesSelecionado}")
    public ResponseEntity<List<ControlePontoDTO>> getEspelhoPontoByMes(@PathVariable String mesSelecionado) {

        List<RegistroPontoEntity> entities = registroPontoRepository.findByMes(DateUtil.getMes(mesSelecionado));

        List<ControlePontoDTO> controlePontoDTOS = new ArrayList<>();
        entities.forEach(entity -> {
            final var registroPontoDto = ControlePontoDTO.builder()
                    .dataHoraRegistroPonto(entity.getDataHoraRegistroPonto())
                    .tipoRegistro(TipoRegistro.fromCodigo(entity.getTipoRegistro()))
                    .build();

            controlePontoDTOS.add(registroPontoDto);
        });

        System.out.println("sucesso " + entities);

        return ResponseEntity.ok(controlePontoDTOS);
    }

    @GetMapping(value = "/registros/atual/snapshot")
    public ResponseEntity<RegistroPontoAtualSnapshotDTO> getRegistroPontoAtualSnapshot() {
        RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO = new RegistroPontoAtualSnapshotDTO();

        List<RegistroPontoEntity> entities = registroPontoRepository.findByDataDeHojeEOntem();

        List<RegistroPontoEntity> pontosDeOntemList = entities.stream()
                .filter(entity -> entity.getDataHoraRegistroPonto()
                        .toLocalDate().equals(LocalDateTime.now().minusDays(1).toLocalDate()))
                .toList();

        List<RegistroPontoEntity> pontoDeHojeList = entities.stream()
                .filter(entity -> entity.getDataHoraRegistroPonto().toLocalDate().equals(LocalDateTime.now().toLocalDate()))
                .toList();

        pontosDeOntemList.forEach(entity -> {
            final var registroPontoDto = ControlePontoDTO.builder()
                    .dataHoraRegistroPonto(entity.getDataHoraRegistroPonto())
                    .tipoRegistro(TipoRegistro.fromCodigo(entity.getTipoRegistro()))
                    .build();

            registroPontoAtualSnapshotDTO.getRegistroPontoOntemList().add(registroPontoDto);
        });

        pontoDeHojeList.forEach(entity -> {
            final var registroPontoDto = ControlePontoDTO.builder()
                    .dataHoraRegistroPonto(entity.getDataHoraRegistroPonto())
                    .tipoRegistro(TipoRegistro.fromCodigo(entity.getTipoRegistro()))
                    .build();

            registroPontoAtualSnapshotDTO.getRegistroPontoHojeList().add(registroPontoDto);
        });

        registroPontoAtualSnapshotDTO.setHorasExtrasMes(LocalTime.of(1,25));
        registroPontoAtualSnapshotDTO.setHorasCompensaveisMes(LocalTime.of(4,30));


        // horas trabalhadas de hoje
        LocalTime horasTrabalhadasHoje = LocalTime.of(0, 0);
        for (int i = 1; i < registroPontoAtualSnapshotDTO.getRegistroPontoHojeList().size(); i++) {
            LocalDateTime dataAnterior = registroPontoAtualSnapshotDTO.getRegistroPontoHojeList().get(i - 1).getDataHoraRegistroPonto();
            LocalDateTime dataAtual = registroPontoAtualSnapshotDTO.getRegistroPontoHojeList().get(i).getDataHoraRegistroPonto();
            Duration diff = calcularDiferencaHorasMinutos(dataAnterior, dataAtual);
            System.out.println("Diferença entre " + dataAnterior + " e " + dataAtual + ": " +
                    diff.toHours() + " horas e " + (diff.toMinutesPart()) + " minutos.");
            horasTrabalhadasHoje = horasTrabalhadasHoje.plusHours(diff.toHours()).plusMinutes(diff.toMinutesPart());
        }

        // horas trabalhadas de ontem
        LocalTime horasTrabalhadasOntem = LocalTime.of(0, 0);
        for (int i = 1; i < registroPontoAtualSnapshotDTO.getRegistroPontoOntemList().size(); i++) {
            LocalDateTime dataAnterior = registroPontoAtualSnapshotDTO.getRegistroPontoOntemList().get(i - 1).getDataHoraRegistroPonto();
            LocalDateTime dataAtual = registroPontoAtualSnapshotDTO.getRegistroPontoOntemList().get(i).getDataHoraRegistroPonto();
            Duration diff = calcularDiferencaHorasMinutos(dataAnterior, dataAtual);
            System.out.println("Diferença entre " + dataAnterior + " e " + dataAtual + ": " +
                    diff.toHours() + " horas e " + (diff.toMinutesPart()) + " minutos.");
            horasTrabalhadasOntem = horasTrabalhadasOntem.plusHours(diff.toHours()).plusMinutes(diff.toMinutesPart());
        }

        registroPontoAtualSnapshotDTO.setHorasTrabalhadasHoje(horasTrabalhadasHoje);
        registroPontoAtualSnapshotDTO.setHorasTrabalhadasOntem(horasTrabalhadasOntem);

        return ResponseEntity.ok(registroPontoAtualSnapshotDTO);
    }

    public static Duration calcularDiferencaHorasMinutos(LocalDateTime inicio, LocalDateTime fim) {
        return Duration.between(inicio, fim);
    }

}
