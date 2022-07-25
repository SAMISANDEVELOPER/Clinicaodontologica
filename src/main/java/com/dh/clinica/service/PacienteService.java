package com.dh.clinica.service;


import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.repository.impl.PacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    final static Logger logger = Logger.getLogger(PacienteService.class);

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {

        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar(Paciente p) {
       logger.debug("Guardando nuevo paciente");
        return pacienteRepository.save(p);
    }

    public Optional<Paciente> buscar(Integer id) throws ResourceNotFoundException {
        logger.debug("Buscando paciente");
        return pacienteRepository.findById(id);
    }

    public List<Paciente> buscarTodos() {
        logger.debug("Listado de pacientes activos");
        return pacienteRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException{
        logger.debug("Eliminando paciente");
        pacienteRepository.deleteById(id);
    }

    public Paciente actualizar(Paciente p) {
        logger.debug("Se actualizo un paciente");
        return pacienteRepository.save(p);
    }
}
