package com.proyecto.serviceimpl;

import com.proyecto.dao.PostreDao;
import com.proyecto.domain.Postre;
import com.proyecto.service.PostreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostreServiceImpl implements PostreService{
    @Autowired
    private PostreDao postreDao;

    @Override
    @Transactional(readOnly=true)
    public List<Postre> getPostres(boolean activos) {
        var lista=postreDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivoD());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Postre getPostre(Postre postre){
        return postreDao.findById(postre.getIdPostre()).orElse(null);
        
    }
    
    @Override
    @Transactional
    public void save(Postre postre){
        postreDao.save(postre); //Guardar o modificar el Id(categoria)
    }
    
    @Override
    @Transactional
    public void delete(Postre postre){
        postreDao.delete(postre); //Eliminar el id (categoria)
    }
    
}
