package com.bateponto.app.service;

import com.bateponto.app.entity.RegistroPontoEntity;
import com.bateponto.app.model.dto.RegistroPontoAtualSnapshotDTO;
import com.bateponto.app.model.dto.RegistroPontoDTO;
import com.bateponto.app.model.enums.TipoRegistro;
import com.bateponto.app.repository.RegistroPontoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class RegistroPontoSnapshotService {

    @Autowired
    private RegistroPontoRepository registroPontoRepository;

    private static final Logger logger = LoggerFactory.getLogger(RegistrarPontoService.class);

    public RegistroPontoAtualSnapshotDTO getRegistroPontoAtualSnapshot() {
        final RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO = new RegistroPontoAtualSnapshotDTO();

        final List<RegistroPontoEntity> entities = registroPontoRepository.findByDataDeHojeEOntem();

        popularRegistrosPonto(entities, registroPontoAtualSnapshotDTO);
        calculaHorasTrabalhasHoje(registroPontoAtualSnapshotDTO);
        calculaHorasTrabalhasOntem(registroPontoAtualSnapshotDTO);

        //todo mock de horas extras e horas compensaveis
        registroPontoAtualSnapshotDTO.setHorasExtrasMes(LocalTime.of(1,25));
        registroPontoAtualSnapshotDTO.setHorasCompensaveisMes(LocalTime.of(4,30));

        return registroPontoAtualSnapshotDTO;
    }

    private void popularRegistrosPonto(List<RegistroPontoEntity> entities, RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        List<RegistroPontoEntity> pontosDeOntemList = filterRegistroPontoList(entities, LocalDateTime.now().minusDays(1));
        List<RegistroPontoEntity> pontoDeHojeList = filterRegistroPontoList(entities, LocalDateTime.now());

        adicionaRegistroPonto(pontosDeOntemList, registroPontoAtualSnapshotDTO.getRegistroPontoOntemList());
        adicionaRegistroPonto(pontoDeHojeList, registroPontoAtualSnapshotDTO.getRegistroPontoHojeList());
    }

    private List<RegistroPontoEntity> filterRegistroPontoList(List<RegistroPontoEntity> entities, LocalDateTime minusDays) {
        return entities.stream()
                .filter(entity -> entity.getDataHoraRegistroPonto().toLocalDate().equals(minusDays.toLocalDate()))
                .toList();
    }

    private void adicionaRegistroPonto(List<RegistroPontoEntity> registroPontoEntities, List<RegistroPontoDTO> registroPontoDTO) {
        registroPontoEntities.forEach(entity -> {
            final var registroPontoDto = RegistroPontoDTO.builder()
                    .dataHoraRegistroPonto(entity.getDataHoraRegistroPonto())
                    .tipoRegistro(TipoRegistro.fromCodigo(entity.getTipoRegistroPontoEntity().getIdTipoRegistroPonto()))
                    .build();

            registroPontoDTO.add(registroPontoDto);
        });
    }

    public void calculaHorasTrabalhasOntem(RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        registroPontoAtualSnapshotDTO.setHorasTrabalhadasOntem(
                calculaHorasTrabalhadas(registroPontoAtualSnapshotDTO.getRegistroPontoOntemList()
                ));
    }

    public void calculaHorasTrabalhasHoje(RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        registroPontoAtualSnapshotDTO.setHorasTrabalhadasHoje(
                calculaHorasTrabalhadas(registroPontoAtualSnapshotDTO.getRegistroPontoHojeList()
                ));
    }

    private LocalTime calculaHorasTrabalhadas(List<RegistroPontoDTO> registroPontoList) {

        if (registroPontoList.isEmpty()) {
            return LocalTime.MIN;
        }

        LocalTime horasTrabalhadas = LocalTime.MIN;
        for (int i = 1; i < registroPontoList.size(); i++) {
            LocalDateTime dataAnterior = registroPontoList.get(i - 1).getDataHoraRegistroPonto();
            LocalDateTime dataAtual = registroPontoList.get(i).getDataHoraRegistroPonto();
            Duration diff = calcularDiferencaHorasMinutos(dataAnterior, dataAtual);
            logger.info("Diferença entre {} e {}: {} horas e {} minutos.", dataAnterior, dataAtual, diff.toHours(), diff.toMinutesPart());
            horasTrabalhadas = horasTrabalhadas.plusHours(diff.toHours()).plusMinutes(diff.toMinutesPart());
        }
        return horasTrabalhadas;
    }

    public Duration calcularDiferencaHorasMinutos(LocalDateTime inicio, LocalDateTime fim) {
        return Duration.between(inicio, fim);
    }

}
