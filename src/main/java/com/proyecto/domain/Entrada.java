package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
@Data //Especificar que es una capa de datos
@Entity //Esta clase esta enlazada a una tabla en la base de datos
@Table(name="entrada") //Especificar cual entidad
public class Entrada implements Serializable {
     private static final long serialVersionUID = 1L; //Autoincremento en Java (Auto_Increment PrimaryKey)  
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="idEntrada")
   private Long idEntrada;
   private String DetalleE;
   private int PrecioE;
   private String ImagenE;
   private boolean ActivoE;

    public Entrada() {
    }

    public Entrada(Long idEntrada, boolean ActivoE) {
        this.idEntrada = idEntrada;
        this.ActivoE = ActivoE;
    }

    

    
   
   
}
