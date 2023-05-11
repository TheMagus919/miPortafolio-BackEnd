/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortafolioWeb.miportafolio.Controller;
import com.miPortafolioWeb.miportafolio.Model.Educacion;
import com.miPortafolioWeb.miportafolio.Model.Experiencias;
import com.miPortafolioWeb.miportafolio.Model.Habilidades;
import com.miPortafolioWeb.miportafolio.Model.Usuario;
import com.miPortafolioWeb.miportafolio.Model.Perfil;
import com.miPortafolioWeb.miportafolio.Model.Proyectos;
import com.miPortafolioWeb.miportafolio.Service.IPortafolioService;
import com.miPortafolioWeb.miportafolio.Utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class Controller {
    @Autowired
    public IPortafolioService portaServ;
    
    @Autowired
    private JWTUtil jwtUtil;
    
    //CONTROLLER USUARIO
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioLogueado = portaServ.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getIdUsuario()), usuarioLogueado.getUser());
            return tokenJwt;
        }
        return "FAIL";
    }
    
    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }

        return portaServ.getUsuarios();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
    
    //CONTROLLER EDUCACION
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/educacion")
    @ResponseBody
    public List<Educacion> mostrarEstudios(){
        return portaServ.verEducacion();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/educacion/agregar")
    public void cargarEstudio(@RequestBody Educacion edu){
        portaServ.cargarEducacion(edu);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/educacion/editar")
    public void editarEducacion(@RequestBody Educacion estu){
        cargarEstudio(estu);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/educacion/eliminar/{id}")
    public void eliminarEstudio(@PathVariable String id){
        portaServ.eliminarEducacion(id);
    }
    
    //CONTROLLER PERFIL
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/perfil/{idPerfil}")
    @ResponseBody
    public Perfil mostrarPerfil(@PathVariable int idPerfil){
        return portaServ.verPerfil(idPerfil);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/perfil/cambiarfoto/{idPerfil}")
    @ResponseBody
    public void cambiarFoto(@RequestBody String imagen, @PathVariable int idPerfil){
        portaServ.cambiarFoto(imagen, idPerfil);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/perfil/cambiarinfo/{idPerfil}")
    @ResponseBody
    public void cambiarInfo(@RequestBody String info, @PathVariable int idPerfil){
        portaServ.cambiarInfo(info, idPerfil);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/perfil/editar")
    @ResponseBody
    public void cargarPerfil(@RequestBody Perfil perf){   
        portaServ.cargarPerfil(perf);

    }
    
    //CONTROLLER HABILIDADES
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/habilidades")
    @ResponseBody
    public List<Habilidades> mostrarHabilidades(){
        return portaServ.verHabilidades();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/habilidades/agregar")
    public void cargarHabilidad(@RequestBody Habilidades hab){
        portaServ.cargarHabilidad(hab);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/habilidades/editar")
    public void editarHabilidad(@RequestBody Habilidades hab){
        cargarHabilidad(hab);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/habilidades/eliminar/{id}")
    public void eliminarHabilidad(@PathVariable String id){
        portaServ.eliminarHabilidad(id);
    }
    
    //CONTROLLER EXPERIENCIAS
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/experiencias")
    @ResponseBody
    public List<Experiencias> mostrarExperiencias(){
        return portaServ.verExperiencias();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/experiencias/agregar")
    public void cargarExperiencias(@RequestBody Experiencias exp){
        portaServ.cargarExperiencias(exp);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/experiencias/editar")
    public void editarExperiencias(@RequestBody Experiencias exp){
        cargarExperiencias(exp);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/experiencias/eliminar/{id}")
    public void eliminarExperiencia(@PathVariable String id){
        portaServ.eliminarExperiencia(id);
    }
    
    //CONTROLLER PROYECTOS
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/proyectos")
    @ResponseBody
    public List<Proyectos> mostrarProyectos(){
        return portaServ.verProyectos();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/proyectos/agregar")
    public void cargarProyectos(@RequestBody Proyectos proy){   
        portaServ.cargarProyectos(proy);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/proyectos/editar")
    public void editarProyecto(@RequestBody Proyectos proy){  
        cargarProyectos(proy);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/proyectos/eliminar/{id}")
    public void eliminarProyecto(@PathVariable String id){
        portaServ.eliminarProyecto(id);
    } 
    
}
