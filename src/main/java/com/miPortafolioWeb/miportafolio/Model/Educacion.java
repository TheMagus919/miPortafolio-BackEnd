/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortafolioWeb.miportafolio.Model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author agust
 */
@Entity
@Getter @Setter
@Table(name = "educacion")
public class Educacion {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEducacion;
    
    private String universidad;
    private String carrera;
    private String fecha;
    private String imagen;
    
    //constructor
    public Educacion(int idEducacion, String universidad, String carrera, String fecha, String imagen) {
        this.idEducacion = idEducacion;
        this.universidad = universidad;
        this.carrera = carrera;
        this.fecha = fecha;
        this.imagen = imagen;
    }
    
    public Educacion(){}
    
}
