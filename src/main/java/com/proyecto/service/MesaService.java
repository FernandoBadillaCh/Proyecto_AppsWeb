package com.proyecto.service;

import com.proyecto.domain.Mesa;
import com.proyecto.domain.Reserva;
import com.proyecto.domain.Usuario;

import java.util.List;

public interface MesaService {

	List<Mesa> obtenerMesas();

	Mesa obtenerMesaPorId(Long idMesa);

	Mesa guardarMesa(Mesa mesa);

	void eliminarMesa(Long idMesa);
}
