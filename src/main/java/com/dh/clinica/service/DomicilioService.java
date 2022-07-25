package com.dh.clinica.service;


import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Domicilio;
import com.dh.clinica.repository.impl.DomicilioRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class DomicilioService {
    private final DomicilioRepository domicilioRepository;
    final static Logger logger = Logger.getLogger(DomicilioService.class);

    @Autowired
    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public Domicilio guardar(Domicilio d){
        logger.debug("Guardando domicilio");
        domicilioRepository.save(d);
        return d;
    }
    public Optional<Domicilio> buscar(Integer id) throws ResourceNotFoundException {
        logger.debug("Buscando domicilio");
        return Optional.of(domicilioRepository.getOne(Long.valueOf(id)));
    }
    public List<Domicilio> buscarTodos(){
        logger.debug("Listado de domicilios activos");
        return domicilioRepository.findAll();
    }
    public void eliminar(Integer id) throws ResourceNotFoundException{
        logger.debug("Eliminando domicilio");
        domicilioRepository.deleteById(Long.valueOf(id));
    }
    public Domicilio actualizar(Domicilio d){
        logger.debug("Se ha actualizado un domicilio");
        return domicilioRepository.save(d);
    }

}
