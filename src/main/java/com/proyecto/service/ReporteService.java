package com.proyecto.service;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ReporteService {
     public ResponseEntity<Resource>
            generaReporte(
                    String reporte, //El nombre del archivo llamado .jasper 
                    Map<String, Object> parametros, //Los parametros del reporte, si tiene reporte 
                    String tipo //El tipo de reportes como csv, pdf, excel, txt 
            )throws IOException;
}
