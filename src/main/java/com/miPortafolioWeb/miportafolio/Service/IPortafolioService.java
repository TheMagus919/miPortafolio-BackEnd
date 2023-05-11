/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miPortafolioWeb.miportafolio.Service;
import com.miPortafolioWeb.miportafolio.Model.Educacion;
import com.miPortafolioWeb.miportafolio.Model.Experiencias;
import com.miPortafolioWeb.miportafolio.Model.Habilidades;
import com.miPortafolioWeb.miportafolio.Model.Perfil;
import com.miPortafolioWeb.miportafolio.Model.Usuario;
import com.miPortafolioWeb.miportafolio.Model.Proyectos;
import java.util.List;
/**
 *
 * @author agust
 */
public interface IPortafolioService {
    public void cargarPerfil(Perfil perf);
    public Perfil verPerfil(int idPerfil);
    public void cambiarFoto(String imagen, int idPerfil);
    public void cambiarInfo(String info,int idPerfil);
    
    public List<Educacion> verEducacion();
    public void cargarEducacion(Educacion edu);
    public void eliminarEducacion(String idEducacion);
    //public void editarEducacion(Educacion edu);
    
    public List<Habilidades> verHabilidades();
    public void cargarHabilidad(Habilidades hab);
    public void eliminarHabilidad(String idHabilidades);
    //public void editarHabilidad(String idHabilidades);
    
    public List<Experiencias> verExperiencias();
    public void cargarExperiencias(Experiencias exp);
    public void eliminarExperiencia(String idExperiencas);
    //public void editarExperiencia(String idExperiencas);
    
    public List<Proyectos> verProyectos();
    public void cargarProyectos(Proyectos proy);
    public void eliminarProyecto(String idProyectos);
    //public void editarProyecto(String idProyectos);
    
    public List<Usuario> getUsuarios();
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
    public void registrarUsuario(Usuario user);
    public void eliminarUsuario(int idUsuario);
}
