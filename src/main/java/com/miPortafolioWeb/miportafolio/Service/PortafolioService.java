/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortafolioWeb.miportafolio.Service;
import com.miPortafolioWeb.miportafolio.Model.Educacion;
import com.miPortafolioWeb.miportafolio.Model.Experiencias;
import com.miPortafolioWeb.miportafolio.Model.Habilidades;
import com.miPortafolioWeb.miportafolio.Model.Perfil;
import com.miPortafolioWeb.miportafolio.Model.Proyectos;
import com.miPortafolioWeb.miportafolio.Model.Usuario;
import com.miPortafolioWeb.miportafolio.Repository.EducacionRepository;
import com.miPortafolioWeb.miportafolio.Repository.ExperienciasRepository;
import com.miPortafolioWeb.miportafolio.Repository.HabilidadesRepository;
import com.miPortafolioWeb.miportafolio.Repository.PerfilRepository;
import com.miPortafolioWeb.miportafolio.Repository.ProyectosRepository;
import com.miPortafolioWeb.miportafolio.Repository.UsuarioRepository;
import com.miPortafolioWeb.miportafolio.Utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author agust
 */
@Service
public class PortafolioService implements IPortafolioService{
    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired
    public EducacionRepository educacionRepo;
    
    @Autowired
    public ExperienciasRepository experienciasRepo;
    
    @Autowired
    public HabilidadesRepository habilidadesRepo;
    
    @Autowired
    public PerfilRepository perfilRepo;
    
    @Autowired
    public ProyectosRepository proyectosRepo;

    @Autowired
    public UsuarioRepository usuarioRepo;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }
    
    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE user = :user";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("user", usuario.getUser())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getPassword())) {
            return lista.get(0);
        }
        return null;
    }
        
    @Override
    public void eliminarUsuario(int idUsuario) {
        usuarioRepo.deleteById(idUsuario);
    }
    
    @Override
    public void cambiarFoto(String imagen,int idPerfil){
        Perfil perff = perfilRepo.getReferenceById(idPerfil);
        perff.setFoto(imagen);
        perfilRepo.save(perff);
    }
    
    @Override
    public void cambiarInfo(String info,int idPerfil){
        Perfil perff = perfilRepo.getReferenceById(idPerfil);
        perff.setInfo(info);
        perfilRepo.save(perff);
    }
    
    @Override
    public void cargarPerfil(Perfil perf) {
        perfilRepo.save(perf);
    }
    
    @Override
    public void registrarUsuario(Usuario user) {
        usuarioRepo.save(user);
    }
    
    @Override
    public Perfil verPerfil(int idPerfil) {
        return perfilRepo.findById(idPerfil).orElse(null);
    }

    @Override
    public List<Educacion> verEducacion() {
        return educacionRepo.findAll();
    }

    @Override
    public List<Habilidades> verHabilidades() {
        return habilidadesRepo.findAll();
    }

    @Override
    public List<Experiencias> verExperiencias() {
        return experienciasRepo.findAll();
    }

    @Override
    public List<Proyectos> verProyectos() {
        return proyectosRepo.findAll();
    }

    @Override
    public void cargarEducacion(Educacion edu) {
        educacionRepo.save(edu);
    }

    @Override
    public void eliminarEducacion(String idEducacion) {
        educacionRepo.deleteById(idEducacion);
    }

    @Override
    public void cargarHabilidad(Habilidades hab) {
        habilidadesRepo.save(hab);
    }

    @Override
    public void eliminarHabilidad(String idHabilidades) {
        habilidadesRepo.deleteById(idHabilidades);
    }

    @Override
    public void cargarExperiencias(Experiencias exp) {
        experienciasRepo.save(exp);
    }

    @Override
    public void eliminarExperiencia(String idExperiencias) {
        experienciasRepo.deleteById(idExperiencias);    
    }

    @Override
    public void cargarProyectos(Proyectos proy) {
        proyectosRepo.save(proy);
    }

    @Override
    public void eliminarProyecto(String idProyectos) {
        proyectosRepo.deleteById(idProyectos);
    }

}
