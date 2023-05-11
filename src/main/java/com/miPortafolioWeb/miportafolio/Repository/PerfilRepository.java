/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miPortafolioWeb.miportafolio.Repository;
import org.springframework.stereotype.Repository;
import com.miPortafolioWeb.miportafolio.Model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author agust
 */
@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer>{
    
}
