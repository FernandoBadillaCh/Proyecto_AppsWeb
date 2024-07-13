package com.proyecto.serviceimpl;

import com.proyecto.dao.BebidaDao;
import com.proyecto.domain.Bebida;
import com.proyecto.service.BebidaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BebidaServiceImpl implements BebidaService {
    @Autowired
    private BebidaDao bebidaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Bebida> getBebidas(boolean activos) {
        var lista=bebidaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivoB());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Bebida getBebida(Bebida bebida){
        return bebidaDao.findById(bebida.getIdBebida()).orElse(null);
        
    }
    
    @Override
    @Transactional
    public void save(Bebida bebida){
        bebidaDao.save(bebida); //Guardar o modificar el Id(categoria)
    }
    
    @Override
    @Transactional
    public void delete(Bebida bebida){
        bebidaDao.delete(bebida); //Eliminar el id (categoria)
    }
}
