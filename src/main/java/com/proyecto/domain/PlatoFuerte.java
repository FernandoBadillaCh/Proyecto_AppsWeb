
package com.proyecto.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
@Data //Especificar que es una capa de datos
@Entity //Esta clase esta enlazada a una tabla en la base de datos
@Table(name="platofuerte") //Especificar cual entidad
public class PlatoFuerte implements Serializable {
     private static final long serialVersionUID = 1L; //Autoincremento en Java (Auto_Increment PrimaryKey)  
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="idPlatoFuerte")
   private Long idPlatoFuerte;
   private String DetalleP;
   private int PrecioP;
   private String ImagenP;
   private boolean ActivoP;

    public PlatoFuerte() {
    }

    public PlatoFuerte(Long idPlatoFuerte, boolean ActivoP) {
        this.idPlatoFuerte = idPlatoFuerte;
        this.ActivoP = ActivoP;
    }
}
