/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolioUno.ignacioDates.Repository;

import com.porfolioUno.ignacioDates.Entity.ExpLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nacho
 */
public interface IExpLaboralRepository extends JpaRepository<ExpLaboral, Integer>{
    public Optional<ExpLaboral> findByNombreExpLaboral(String nombreExpLaboral);
    public boolean existsByNombreExpLaboral(String nombreExpLaboral);
}
