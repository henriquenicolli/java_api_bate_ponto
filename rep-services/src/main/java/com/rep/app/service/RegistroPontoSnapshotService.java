package com.rep.app.service;

import com.rep.app.model.dto.RegistroPontoAtualSnapshotDTO;
import com.rep.app.model.dto.RegistroPontoDTO;
import com.rep.app.repository.RegistroPontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class RegistroPontoSnapshotService {

    @Autowired
    private RegistroPontoRepository registroPontoRepository;

    private static final LocalTime CARGA_HORARIA_DIARIA = LocalTime.of(7, 15);

    public RegistroPontoAtualSnapshotDTO getRegistroPontoAtualSnapshot() {
        final RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO = new RegistroPontoAtualSnapshotDTO();

        final LocalDate dataInicio = LocalDate.now().minusDays(1);
        final LocalDate dataFim = LocalDate.now();
        final List<RegistroPontoDTO> entities = registroPontoRepository.findByDataInicioAndDataFim(dataInicio, dataFim);

        popularSnapshot(entities, registroPontoAtualSnapshotDTO);
        calculaHorasTrabalhasHoje(registroPontoAtualSnapshotDTO);
        calculaHorasTrabalhasOntem(registroPontoAtualSnapshotDTO);
        calculaHorasExtras(registroPontoAtualSnapshotDTO);

        return registroPontoAtualSnapshotDTO;
    }

    private void popularSnapshot(List<RegistroPontoDTO> entities, RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        List<RegistroPontoDTO> pontosDeOntemList = filterRegistroPontoListByLocalDate(entities, LocalDate.now().minusDays(1));
        List<RegistroPontoDTO> pontoDeHojeList = filterRegistroPontoListByLocalDate(entities, LocalDate.now());

        registroPontoAtualSnapshotDTO.getRegistroPontoOntemList().addAll(pontosDeOntemList);
        registroPontoAtualSnapshotDTO.getRegistroPontoHojeList().addAll(pontoDeHojeList);
    }

    private List<RegistroPontoDTO> filterRegistroPontoListByLocalDate(List<RegistroPontoDTO> entities, LocalDate localDateTime) {
        return entities.stream()
                .filter(entity -> entity.getDataMarcacaoPonto().equals(localDateTime))
                .toList();
    }

    private void calculaHorasTrabalhasHoje(RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        registroPontoAtualSnapshotDTO.setHorasTrabalhadasHoje(
                calculaHorasTrabalhadas(registroPontoAtualSnapshotDTO.getRegistroPontoHojeList()
                ));
    }

    private void calculaHorasTrabalhasOntem(RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        registroPontoAtualSnapshotDTO.setHorasTrabalhadasOntem(
                calculaHorasTrabalhadas(registroPontoAtualSnapshotDTO.getRegistroPontoOntemList()
                ));
    }

    private LocalTime calculaHorasTrabalhadas(List<RegistroPontoDTO> registroPontoList) {
        if (registroPontoList.isEmpty()) {
            return LocalTime.MIN;
        }

        registroPontoList.sort(Comparator.comparing(RegistroPontoDTO::getNumSeqRegistro));

        Duration totalDuration = IntStream.range(0, registroPontoList.size())
                .filter(i -> i % 2 == 0 && i + 1 < registroPontoList.size())
                .mapToObj(i -> calcularDiferencaHorasMinutos(
                        registroPontoList.get(i).getHoraMarcacaoPonto(),
                        registroPontoList.get(i + 1).getHoraMarcacaoPonto()))
                .reduce(Duration.ZERO, Duration::plus);

        return durationToLocalTime(totalDuration);
    }

    public Duration calcularDiferencaHorasMinutos(LocalTime inicio, LocalTime fim) {
        return Duration.between(inicio, fim);
    }

    private LocalTime durationToLocalTime(Duration duration) {
        return LocalTime.of((int) duration.toHoursPart(), duration.toMinutesPart());
    }

    private void calculaHorasExtras(RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        // todo refactor para buscar horas extras do banco
        Duration duration = calcularDiferencaHorasMinutos(CARGA_HORARIA_DIARIA, registroPontoAtualSnapshotDTO.getHorasTrabalhadasHoje());
        if (duration.isNegative()) {
            registroPontoAtualSnapshotDTO.setHorasExtrasHoje(LocalTime.of(0, 0));
        } else {
            registroPontoAtualSnapshotDTO.setHorasExtrasHoje(durationToLocalTime(duration));
        }
    }

}
