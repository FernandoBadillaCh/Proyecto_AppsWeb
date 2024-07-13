package com.proyecto.serviceimpl;

import com.proyecto.dao.EntradaDao;
import com.proyecto.domain.Entrada;
import com.proyecto.service.EntradaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntradaServiceImpl implements EntradaService {
    @Autowired
    private EntradaDao entradaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Entrada> getEntradas(boolean activos) {
        var lista=entradaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivoE());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Entrada getEntrada(Entrada entrada){
        return entradaDao.findById(entrada.getIdEntrada()).orElse(null);
        
    }    
    @Override
    @Transactional
    public void save(Entrada entrada){
        entradaDao.save(entrada); //Guardar o modificar el Id(categoria)
    }
    
    @Override
    @Transactional
    public void delete(Entrada entrada){
        entradaDao.delete(entrada); //Eliminar el id (categoria)
    }
    
}
