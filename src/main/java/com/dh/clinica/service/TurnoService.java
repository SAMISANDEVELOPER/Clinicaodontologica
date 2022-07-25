package com.dh.clinica.service;

import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Turno;
import com.dh.clinica.repository.impl.TurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;
    final static Logger logger = Logger.getLogger(TurnoService.class);

    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {

        this.turnoRepository = turnoRepository;
    }

    public Turno registrarTurno(Turno turno) {
        logger.debug("Se ha creado un nuevo turno");
        return turnoRepository.save(turno);
    }

    public List<Turno> listar() {
        logger.debug("Listado de turnos");
        return turnoRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {
        logger.debug("Eliminando turno");
        turnoRepository.deleteById(id);
    }

    public Turno actualizar(Turno turno) {
        logger.debug("Se ha actualizado un turno");
        return turnoRepository.save(turno);
    }

    public Optional<Turno> buscar(Integer id) throws ResourceNotFoundException{
        logger.debug("Se ha modificado un turno");
        return turnoRepository.findById(id);
    }

}
