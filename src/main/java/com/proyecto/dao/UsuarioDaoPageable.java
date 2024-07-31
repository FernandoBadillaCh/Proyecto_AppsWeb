package com.proyecto.dao;

import com.proyecto.domain.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioDaoPageable extends PagingAndSortingRepository<Usuario, Long> {

}
