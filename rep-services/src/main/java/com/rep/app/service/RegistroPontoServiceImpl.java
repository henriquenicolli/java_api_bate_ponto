package com.rep.app.service;

import com.rep.app.model.dto.RegistroPontoDTO;
import com.rep.app.repository.RegistroPontoRepository;
import com.rep.app.services.RegistroPontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroPontoServiceImpl implements RegistroPontoService {

    @Autowired
    private RegistroPontoRepository registroPontoRepository;

    @Override
    public RegistroPontoDTO salvarRegistroPonto(final RegistroPontoDTO registroPontoDTO) {
        return registroPontoRepository.salvarRegistroPonto(registroPontoDTO);
    }

    @Override
    public List<RegistroPontoDTO> findByMesMarcacaoPonto(int mes) {
        return registroPontoRepository.findByMesMarcacaoPonto(mes);
    }

    @Override
    public void updateRegistroPonto(RegistroPontoDTO registroAtualizado) {
        registroPontoRepository.updateRegistroPonto(registroAtualizado);
    }

    @Override
    public void deleteRegistroPonto(int numSeqRegistro) {
        registroPontoRepository.deleteRegistroPonto(numSeqRegistro);
    }

}
