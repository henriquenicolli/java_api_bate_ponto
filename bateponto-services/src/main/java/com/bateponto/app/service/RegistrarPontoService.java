package com.bateponto.app.service;

import com.bateponto.app.entity.RegistroPontoEntity;
import com.bateponto.app.model.dto.RegistroPontoAtualSnapshotDTO;
import com.bateponto.app.model.dto.RegistroPontoDTO;
import com.bateponto.app.repository.RegistroPontoRepository;
import com.bateponto.app.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrarPontoService {

    @Autowired
    private RegistroPontoRepository registroPontoRepository;

    public boolean registrarPonto(final RegistroPontoDTO registroPontoDTO) {
        final var registroPontoEntity = RegistroPontoEntity.builder()
                .dataHoraRegistroPonto(registroPontoDTO.getDataHoraRegistroPonto())
                .latitude(new BigDecimal(registroPontoDTO.getLatitude()))
                .longitude(new BigDecimal(registroPontoDTO.getLongitude()))
                //.tipoRegistro(registroPontoDTO.getTipoRegistro().getCodigo())
                .build();

        registroPontoRepository.save(registroPontoEntity);

        return true;
    }


    public List<RegistroPontoDTO> getEspelhoPontoMes(final String mes) {
        List<RegistroPontoDTO> registroPontoDTOS = new ArrayList<>();
        List<RegistroPontoEntity> entities = registroPontoRepository.findByMes(DateUtil.getMes(mes));

        entities.forEach(entity -> {
            final var registroPontoDto = RegistroPontoDTO.builder()
                    .dataHoraRegistroPonto(entity.getDataHoraRegistroPonto())
                    //.tipoRegistro(TipoRegistro.fromCodigo(entity.getTipoRegistro()))
                    .build();

            registroPontoDTOS.add(registroPontoDto);
        });

        return registroPontoDTOS;
    }


    public RegistroPontoAtualSnapshotDTO getRegistroPontoAtualSnapshot() {
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
            final var registroPontoDto = RegistroPontoDTO.builder()
                    .dataHoraRegistroPonto(entity.getDataHoraRegistroPonto())
                    //.tipoRegistro(TipoRegistro.fromCodigo(entity.getTipoRegistro()))
                    .build();

            registroPontoAtualSnapshotDTO.getRegistroPontoOntemList().add(registroPontoDto);
        });

        pontoDeHojeList.forEach(entity -> {
            final var registroPontoDto = RegistroPontoDTO.builder()
                    .dataHoraRegistroPonto(entity.getDataHoraRegistroPonto())
                    //.tipoRegistro(TipoRegistro.fromCodigo(entity.getTipoRegistro()))
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

        return registroPontoAtualSnapshotDTO;
    }

    public static Duration calcularDiferencaHorasMinutos(LocalDateTime inicio, LocalDateTime fim) {
        return Duration.between(inicio, fim);
    }

}
