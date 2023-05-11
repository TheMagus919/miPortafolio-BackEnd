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
@Table(name = "perfil")
public class Perfil {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerfil;
    
    private String nombre;
    private String profesion;
    private String ciudad;
    private String universidad;
    private String fotouniversidad;
    private String info;
    private String foto;
    
    //Constructor
    public Perfil(){}
    
    public Perfil(int idPerfil, String nombre, String profesion, String ciudad, String universidad, String fotouniversidad, String info, String foto) {
        this.idPerfil = idPerfil;
        this.nombre = nombre;
        this.profesion = profesion;
        this.ciudad = ciudad;
        this.universidad = universidad;
        this.fotouniversidad = fotouniversidad;
        this.info = info;
        this.foto = foto;
    }

    
}
