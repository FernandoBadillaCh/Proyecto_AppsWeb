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
@Table(name="postre") //Especificar cual entidad

public class Postre {
    private static final long serialVersionUID = 1L; //Autoincremento en Java (Auto_Increment PrimaryKey)  
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="idPostre")
  
  private Long idPostre;
   private String DetalleD;
   private int PrecioD;
   private String ImagenD;
   private boolean ActivoD;

    public Postre() {
    }

    public Postre(Long idPostre, boolean ActivoD) {
        this.idPostre = idPostre;
        this.ActivoD = ActivoD;
    }
   
   
}

