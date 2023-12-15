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
public class Empleado extends Persona{
    
    private int idEmpleado, idUsuario, idSucursal;
    private String codigo,puesto, nombreUsuario, contrasenia, rol;
    private Date fechaIngreso;
    private float salarioBruto;
    private int activo;
   

    public Empleado(int idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, String genero, String rfc, String curp, String domicilio, String codigoPostal, String ciudad, String estado, String telefono, String foto, Date fechaNacimiento,int idEmpleado, String codigo, String puesto, Date fechaIngreso, float salarioBruto, int activo,
    int idUsuario, String nombreUsuario, String contrasenia, String rol, int idSucursal) {
        super(idPersona, nombre, apellidoPaterno, apellidoMaterno, genero, rfc, curp, domicilio, codigoPostal, ciudad, estado, telefono, foto, fechaNacimiento);
        this.idEmpleado = idEmpleado;
        this.codigo = codigo;
        this.puesto = puesto;
        this.fechaIngreso = fechaIngreso;
        this.salarioBruto = salarioBruto;
        this.activo = activo;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.idSucursal = idSucursal;
    }

    
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public float getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", idUsuario=" + idUsuario + ", idSucursal=" + idSucursal + ", codigo=" + codigo + ", puesto=" + puesto + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + ", rol=" + rol + ", fechaIngreso=" + fechaIngreso + ", salarioBruto=" + salarioBruto + ", activo=" + activo + '}';
    }

    



    
    
}
