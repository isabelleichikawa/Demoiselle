/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author alexandrelerario
 */
@ManagedBean
@RequestScoped
public class JsfRole {

    /**
     * Creates a new instance of JsfRole
     */
    private int idrole;
    private String nome;
    private String descricao;
  
    
    public JsfRole() {
        
    }
    
   
    public void persist(){
       br.data.entity.Role rol = new br.data.entity.Role();
       rol.setIdrole(idrole);
       rol.setNome(nome);
       rol.setDescricao(descricao);
       new br.data.crud.CrudRole().persist(rol);
       this.idrole=0;
       this.nome="";
    }
    
    public void remove(br.data.entity.Role role){
        new br.data.crud.CrudRole().remove(role);
    }
    
    public java.util.Collection<br.data.entity.Role> getAll(){
        return new br.data.crud.CrudRole().getAll();
    }

    public String update(br.data.entity.Role role){
        this.idrole = role.getIdrole();
        this.nome = role.getNome();
        this.descricao = role.getDescricao();
        return "merge.xhtml";
    }
    
    public void merge(){
        br.data.entity.Role teste;
        teste = new br.data.crud.CrudRole().find(this.idrole);
        teste.setNome(this.nome);
        teste.setDescricao(this.descricao);
        new br.data.crud.CrudRole().merge(teste);
        this.nome="";
        this.descricao="";
        this.idrole=0;  
    }
    
    
    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
