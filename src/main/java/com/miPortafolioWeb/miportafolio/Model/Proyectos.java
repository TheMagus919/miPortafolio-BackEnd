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
@Table(name = "proyectos")
public class Proyectos {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProyectos;
    
    private String titulo;
    private String descripcion;
    private String url;
    private String pagina;
    
    //Constructor

    public Proyectos(int idProyectos, String titulo, String descripcion, String url, String pagina) {
        this.idProyectos = idProyectos;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.pagina = pagina;
    }

    public Proyectos(int idProyectos, String titulo, String descripcion, String url) {
        this.idProyectos = idProyectos;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
    }
    
    public Proyectos(){}
}
