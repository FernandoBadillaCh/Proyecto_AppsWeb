
package com.proyecto.serviceimpl;

import com.proyecto.dao.PlatoFuerteDao;
import com.proyecto.domain.PlatoFuerte;
import com.proyecto.service.PlatoFuerteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlatoFuerteServiceImpl implements PlatoFuerteService {
    @Autowired
    private PlatoFuerteDao platoFuerteDao;

    @Override
    @Transactional(readOnly=true)
    public List<PlatoFuerte> getPlatosFuertes(boolean activos) {
        var lista=platoFuerteDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivoP());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public PlatoFuerte PlatoFuerte(PlatoFuerte platoFuerte){
        return platoFuerteDao.findById(platoFuerte.getIdPlatoFuerte()).orElse(null);
        
    }
    
    @Override
    @Transactional
    public void save(PlatoFuerte platoFuerte){
        platoFuerteDao.save(platoFuerte); //Guardar o modificar el Id(categoria)
    }
    
    @Override
    @Transactional
    public void delete(PlatoFuerte platoFuerte){
        platoFuerteDao.delete(platoFuerte); //Eliminar el id (categoria)
    }
}
