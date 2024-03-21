package com.bateponto.app.service;

import com.bateponto.app.entity.FuncionarioEntity;
import com.bateponto.app.entity.RegistroPontoEntity;
import com.bateponto.app.entity.TipoRegistroPontoEntity;
import com.bateponto.app.model.dto.RegistroPontoAtualSnapshotDTO;
import com.bateponto.app.model.dto.RegistroPontoDTO;
import com.bateponto.app.model.enums.TipoRegistro;
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
                //mock funcionario
                .funcionarioEntity(FuncionarioEntity.builder()
                        .idFuncionario(1)
                        .build())
                .dataHoraRegistroPonto(registroPontoDTO.getDataHoraRegistroPonto())
                .latitude(new BigDecimal(registroPontoDTO.getLatitude()))
                .longitude(new BigDecimal(registroPontoDTO.getLongitude()))
                .tipoRegistroPontoEntity(TipoRegistroPontoEntity.builder()
                        .idTipoRegistroPonto(registroPontoDTO.getTipoRegistro().getCodigo())
                        .build())
                .build();

        registroPontoRepository.save(registroPontoEntity);

        return true;
    }

    public List<RegistroPontoDTO> getEspelhoPontoMes(final String mes) {
        List<RegistroPontoDTO> registroPontoDTOS = new ArrayList<>();
        List<RegistroPontoEntity> entities = registroPontoRepository.findByMes(DateUtil.getMes(mes));

        adicionaRegistroPonto(entities, registroPontoDTOS);

        return registroPontoDTOS;
    }


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

    private void calculaHorasTrabalhasOntem(RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        LocalTime horasTrabalhadasOntem = LocalTime.of(0, 0);
        for (int i = 1; i < registroPontoAtualSnapshotDTO.getRegistroPontoOntemList().size(); i++) {
            LocalDateTime dataAnterior = registroPontoAtualSnapshotDTO.getRegistroPontoOntemList().get(i - 1).getDataHoraRegistroPonto();
            LocalDateTime dataAtual = registroPontoAtualSnapshotDTO.getRegistroPontoOntemList().get(i).getDataHoraRegistroPonto();
            Duration diff = calcularDiferencaHorasMinutos(dataAnterior, dataAtual);
            System.out.println("Diferença entre " + dataAnterior + " e " + dataAtual + ": " +
                    diff.toHours() + " horas e " + (diff.toMinutesPart()) + " minutos.");
            horasTrabalhadasOntem = horasTrabalhadasOntem.plusHours(diff.toHours()).plusMinutes(diff.toMinutesPart());
        }
        registroPontoAtualSnapshotDTO.setHorasTrabalhadasOntem(horasTrabalhadasOntem);
    }

    private void calculaHorasTrabalhasHoje(RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO) {
        LocalTime horasTrabalhadasHoje = LocalTime.of(0, 0);
        for (int i = 1; i < registroPontoAtualSnapshotDTO.getRegistroPontoHojeList().size(); i++) {
            LocalDateTime dataAnterior = registroPontoAtualSnapshotDTO.getRegistroPontoHojeList().get(i - 1).getDataHoraRegistroPonto();
            LocalDateTime dataAtual = registroPontoAtualSnapshotDTO.getRegistroPontoHojeList().get(i).getDataHoraRegistroPonto();
            Duration diff = calcularDiferencaHorasMinutos(dataAnterior, dataAtual);
            System.out.println("Diferença entre " + dataAnterior + " e " + dataAtual + ": " +
                    diff.toHours() + " horas e " + (diff.toMinutesPart()) + " minutos.");
            horasTrabalhadasHoje = horasTrabalhadasHoje.plusHours(diff.toHours()).plusMinutes(diff.toMinutesPart());
        }
        registroPontoAtualSnapshotDTO.setHorasTrabalhadasHoje(horasTrabalhadasHoje);
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

    private List<RegistroPontoEntity> filterRegistroPontoList(List<RegistroPontoEntity> entities, LocalDateTime minusDays) {
        return entities.stream()
                .filter(entity -> entity.getDataHoraRegistroPonto()
                        .toLocalDate().equals(minusDays.toLocalDate()))
                .toList();
    }

    public Duration calcularDiferencaHorasMinutos(LocalDateTime inicio, LocalDateTime fim) {
        return Duration.between(inicio, fim);
    }

}
