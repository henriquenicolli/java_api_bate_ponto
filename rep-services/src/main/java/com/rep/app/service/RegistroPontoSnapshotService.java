package com.rep.app.service;

import com.rep.app.entity.RegistroPontoEntity;
import com.rep.app.model.dto.RegistroPontoAtualSnapshotDTO;
import com.rep.app.model.dto.RegistroPontoDTO;
//import com.rep.app.repository.RegistroPontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.IntStream;

@Deprecated
@Service
public class RegistroPontoSnapshotService {

    //@Autowired
    //private RegistroPontoRepository registroPontoRepository;

    @Autowired
    private RegistroPontoService registroPontoService;

    private static final LocalTime CARGA_HORARIA_DIARIA = LocalTime.of(7, 15);

    public RegistroPontoAtualSnapshotDTO getRegistroPontoAtualSnapshot() {
        final RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO = new RegistroPontoAtualSnapshotDTO();

        //final List<RegistroPontoEntity> entities = registroPontoRepository.findByDataDeHojeEOntem();

        //popularRegistrosPonto(entities, registroPontoAtualSnapshotDTO);
        calculaHorasTrabalhasHoje(registroPontoAtualSnapshotDTO);
        calculaHorasTrabalhasOntem(registroPontoAtualSnapshotDTO);
        calculaHorasExtras(registroPontoAtualSnapshotDTO);

        return registroPontoAtualSnapshotDTO;
    }

    private void calculaHorasExtras(RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        //Duration duration = calcularDiferencaHorasMinutos(CARGA_HORARIA_DIARIA, registroPontoAtualSnapshotDTO.getHorasTrabalhadasHoje());
        //if (duration.isNegative()) {
            //registroPontoAtualSnapshotDTO.setHorasExtrasHoje(LocalTime.of(0, 0));
        //} else {
            //registroPontoAtualSnapshotDTO.setHorasExtrasHoje(durationToLocalTime(duration));
        //}
    }

    private void popularRegistrosPonto(List<RegistroPontoEntity> entities, RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        //List<RegistroPontoEntity> pontosDeOntemList = filterRegistroPontoListByLocalDateTime(entities, LocalDateTime.now().minusDays(1));
        //List<RegistroPontoEntity> pontoDeHojeList = filterRegistroPontoListByLocalDateTime(entities, LocalDateTime.now());

        //adicionaRegistroPonto(pontosDeOntemList, registroPontoAtualSnapshotDTO.getRegistroPontoOntemList());
        //adicionaRegistroPonto(pontoDeHojeList, registroPontoAtualSnapshotDTO.getRegistroPontoHojeList());
    }

    private List<RegistroPontoEntity> filterRegistroPontoListByLocalDateTime(List<RegistroPontoEntity> entities, LocalDateTime localDateTime) {
        //TODO FIX ME
        return entities.stream()
                //.filter(entity -> entity.getDataHoraRegistroPonto().toLocalDate().equals(localDateTime.toLocalDate()))
                .toList();
    }

    private void adicionaRegistroPonto(List<RegistroPontoEntity> registroPontoEntities, List<RegistroPontoDTO> registroPontoDTO) {
        // TODO FIX ME
        registroPontoEntities.forEach(entity -> {
            //final var registroPontoDto = RegistroPontoDTO.builder()
                    //.dataHoraRegistroPonto(entity.getDataHoraRegistroPonto())
                    //.tipoRegistro(TipoRegistro.fromCodigo(entity.getTipoRegistroPontoEntity().getIdTipoRegistroPonto()))
            //        .build();

            registroPontoDTO.add(null);
        });
    }

    private void calculaHorasTrabalhasOntem(RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        //registroPontoAtualSnapshotDTO.setHorasTrabalhadasOntem(
        //        calculaHorasTrabalhadas(registroPontoAtualSnapshotDTO.getRegistroPontoOntemList()
        //        ));
    }

    private void calculaHorasTrabalhasHoje(RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        //registroPontoAtualSnapshotDTO.setHorasTrabalhadasHoje(
        //        calculaHorasTrabalhadas(registroPontoAtualSnapshotDTO.getRegistroPontoHojeList()
        //        ));
    }

    private LocalTime calculaHorasTrabalhadas(List<RegistroPontoDTO> registroPontoList) {
        if (registroPontoList.isEmpty()) {
            return LocalTime.MIN;
        }

        //Duration totalDuration = IntStream.range(0, registroPontoList.size())
                //.filter(i -> i % 2 == 0 && i + 1 < registroPontoList.size())
                //.mapToObj(i -> calcularDiferencaHorasMinutos(
                        //registroPontoList.get(i).getDataHoraRegistroPonto(),
                       // registroPontoList.get(i + 1).getDataHoraRegistroPonto()))
                //.reduce(Duration.ZERO, Duration::plus);

        return durationToLocalTime(null);
    }

    private LocalTime durationToLocalTime(Duration duration) {
        return LocalTime.of((int) duration.toHoursPart(), duration.toMinutesPart());
    }

    public Duration calcularDiferencaHorasMinutos(LocalDateTime inicio, LocalDateTime fim) {
        return Duration.between(inicio, fim);
    }

    public Duration calcularDiferencaHorasMinutos(LocalTime inicio, LocalTime fim) {
        return Duration.between(inicio, fim);
    }

}
