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
@Table(name = "habilidades")
public class Habilidades {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHabilidades;
    
    private String nombre;
    private int porcentaje;
    private String width;
    

    public Habilidades() {
    }

    public Habilidades(int idHabilidades, String nombre, int porcentaje, String width) {
        this.idHabilidades = idHabilidades;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.width = width;
    }
}