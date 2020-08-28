/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.osworks.domain.model;

import com.algaworks.osworks.domain.ValidationGroups;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Fabricio
 */
@Entity
public class Cliente {

    @Id
    @NotNull(groups = ValidationGroups.ClienteId.class) //informa que a validação dessa propiedade pertence ao grupo de validação  ValidationGroups.ClienteId.class
    @GeneratedValue(strategy = GenerationType.IDENTITY) //usa a forma nativa do BD
    private Long id;

    @NotBlank //nao aceita valor null, em branco ou apenas espaços
    @Size(max = 60) //tamanho maximo
    private String nome;
    
    @NotBlank
    @Email // verifica se tem um formato de email valido
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "fone") //nome da coluna no BD (caso o nome do atributo seja igual, nao precisa informar essa notação)
    private String telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
