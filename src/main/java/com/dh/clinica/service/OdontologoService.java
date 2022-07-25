package com.dh.clinica.service;

import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.repository.impl.OdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class OdontologoService {

    private final OdontologoRepository odontologoRepository;
    final static Logger logger = Logger.getLogger(OdontologoService.class);

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        logger.debug("Guardando odontologo");
        return odontologoRepository.save(odontologo);

    }

    public void eliminar(Integer id) throws ResourceNotFoundException {
        logger.debug("Eliminando odontologo");
        odontologoRepository.deleteById(id);
    }

    public Optional<Odontologo> buscar(Integer id) {
        logger.debug("Buscando odontologo");
        return odontologoRepository.findById(id);
    }

    public List<Odontologo> buscarTodos() {
        logger.debug("Listado de odontolos activos");
        return odontologoRepository.findAll();
    }

    public Odontologo actualizar(Odontologo odontologo) {
        logger.debug("Se ha actualizado un odontologo");
        return odontologoRepository.save(odontologo);
    }
}
