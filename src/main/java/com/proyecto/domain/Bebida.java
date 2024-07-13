package com.proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data //Especificar que es una capa de datos
@Entity //Esta clase esta enlazada a una tabla en la base de datos
@Table(name="bebida") //Especificar cual entidad
public class Bebida {
    private static final long serialVersionUID = 1L; //Autoincremento en Java (Auto_Increment PrimaryKey)  
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="idBebida")
   private Long idBebida;
   private String DetalleB;
   private int PrecioB;
   private String ImagenB;
   private boolean ActivoB;

    public Bebida() {
    }

    public Bebida(Long idBebida, boolean ActivoB) {
        this.idBebida = idBebida;
        this.ActivoB = ActivoB;
    }

   
}
