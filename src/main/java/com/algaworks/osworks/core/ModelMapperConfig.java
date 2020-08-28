/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.osworks.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Fabricio
 */
@Configuration //informa que essa é uma classe de configuração
public class ModelMapperConfig {

    @Bean //conigura um bean do tipo ModelMapper que será gerenciado pelo Spring, assim sendo disponibilizado para injeção nas outras classes
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
