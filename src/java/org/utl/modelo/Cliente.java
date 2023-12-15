/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.modelo;

import java.sql.Date;

/**
 *
 * @author oscar
 */
public class Cliente extends Persona {
    
    private int idCliente, estatus;
    private String email;
    private Date fechaRegistro;

    public Cliente(int idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, String genero, String rfc, String curp, String domicilio, String codigoPostal, String ciudad, String estado, String telefono, String foto, Date fechaNacimiento, int idCliente, int estatus,String email, Date fechaRegistro) {
        super(idPersona, nombre, apellidoPaterno, apellidoMaterno, genero, rfc, curp, domicilio, codigoPostal, ciudad, estado, telefono, foto, fechaNacimiento);
        this.idCliente = idCliente;
        this.estatus = estatus;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", estatus=" + estatus + ", email=" + email + ", fechaIngreso=" + '}';
    }
    
    
    
    
}
