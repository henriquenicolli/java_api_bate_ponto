package com.bateponto.app.repository;

import com.bateponto.app.entity.RegistroPontoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Repository
public interface RegistroPontoRepository extends JpaRepository<RegistroPontoEntity, Long> {

    @Query("SELECT entity " +
            "FROM tbl_registro_ponto entity " +
            "WHERE MONTH(entity.dataHoraRegistroPonto) = :mes")
    List<RegistroPontoEntity> findByMes(final int mes);

    @Query("SELECT rp FROM tbl_registro_ponto rp " +
            "WHERE rp.dataHoraRegistroPonto >= :dataInicio AND rp.dataHoraRegistroPonto < :dataFim")
    List<RegistroPontoEntity> findByDataDeHojeEOntem(LocalDateTime dataInicio, LocalDateTime dataFim);

    default List<RegistroPontoEntity> findByDataDeHojeEOntem() {

        final LocalDateTime fimHoje = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        final LocalDateTime inicioOntem = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN);

        return findByDataDeHojeEOntem(inicioOntem, fimHoje);
    }
}
