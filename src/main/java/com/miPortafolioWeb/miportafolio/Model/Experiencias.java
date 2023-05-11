/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortafolioWeb.miportafolio.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author agust
 */
@Entity
@Getter @Setter
@Table(name = "experiencias")
public class Experiencias {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExperiencias;
    
    private String puesto;
    private String local;
    private String jornada;
    private String fecha;
    private String ciudad;
    private String imagen;
    
    //Constructor
    public Experiencias(int idExperiencias, String puesto, String local, String jornada, String fecha, String ciudad, String imagen) {
        this.idExperiencias = idExperiencias;
        this.puesto = puesto;
        this.local = local;
        this.jornada = jornada;
        this.fecha = fecha;
        this.ciudad = ciudad;
        this.imagen = imagen;
    }

    public Experiencias() {
    }
  
}
