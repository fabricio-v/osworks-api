/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.osworks.domain.repository;

import com.algaworks.osworks.domain.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fabricio
 */

@Repository //define que essa interface seja um componente do Spring
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    List<Cliente> findByNome(String nome); //faz uma busca por nome
    List<Cliente> findByNomeContaining(String nome); //faz uma busca de cliente que contenha 
    Cliente findByEmail(String email);
    
}
