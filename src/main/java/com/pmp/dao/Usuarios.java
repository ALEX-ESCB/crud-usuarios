/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

/**
 *
 * @author alex-escb
 */
public class Usuarios {

    public Usuarios(){
        
    }
    
       public Usuarios(int codigo, String Nombre, String Email, String Estado, String Password, String Avatar, String FchIngreso){
        this.codigo = codigo;
       this.Nombre = Nombre;
        this.Email = Email;
        this.Estado = Estado;
        this.Password = Password;
        this.Avatar = Avatar;
        this.FchIngreso = FchIngreso;
        
    }
       
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Avatar
     */
    public String getAvatar() {
        return Avatar;
    }

    /**
     * @param Avatar the Avatar to set
     */
    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    /**
     * @return the FchIngreso
     */
    public String getFchIngreso() {
        return FchIngreso;
    }

    /**
     * @param FchIngreso the FchIngreso to set
     */
    public void setFchIngreso(String FchIngreso) {
        this.FchIngreso = FchIngreso;
    }
    
    public String printString(){
        return String.valueOf(codigo) + '\t' + Nombre  + '\t' + Email  + '\t' + Estado +  '\t' + Password +  '\t' + Avatar + '\t' + FchIngreso;
    }
    
    private int codigo;
    private String Nombre;
    private String Email;
    private String Estado;
    private String Password;
    private String Avatar;
    private String FchIngreso;
}
