
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.modelo;

/**
 *
 * @author oscar
 */


public class Producto {
    private int id, unidades_envase,estatus;
    private  String nombre, nombre_generico,forma_farmaceutica,unidad_medida,presentacion,principal_indicacion,contra_indicaciones,concentracion,ruta_foto,codigo_barras;
    private String foto;
    private float precio_compra,precio_venta;

    public Producto(int id, int unidades_envase, int estatus, String nombre, String nombre_generico, String forma_farmaceutica, String unidad_medida, String presentacion, String principal_indicacion, String contra_indicaciones, String concentracion, String foto, String ruta_foto, String codigo_barras, float precio_compra, float precio_venta) {
        this.id = id;
        this.unidades_envase = unidades_envase;
        this.estatus = estatus;
        this.nombre = nombre;
        this.nombre_generico = nombre_generico;
        this.forma_farmaceutica = forma_farmaceutica;
        this.unidad_medida = unidad_medida;
        this.presentacion = presentacion;
        this.principal_indicacion = principal_indicacion;
        this.contra_indicaciones = contra_indicaciones;
        this.concentracion = concentracion;
        this.foto = foto;
        this.ruta_foto = ruta_foto;
        this.codigo_barras = codigo_barras;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnidades_envase() {
        return unidades_envase;
    }

    public void setUnidades_envase(int unidades_envase) {
        this.unidades_envase = unidades_envase;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_generico() {
        return nombre_generico;
    }

    public void setNombre_generico(String nombre_generico) {
        this.nombre_generico = nombre_generico;
    }

    public String getForma_farmaceutica() {
        return forma_farmaceutica;
    }

    public void setForma_farmaceutica(String forma_farmaceutica) {
        this.forma_farmaceutica = forma_farmaceutica;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getPrincipal_indicacion() {
        return principal_indicacion;
    }

    public void setPrincipal_indicacion(String principal_indicacion) {
        this.principal_indicacion = principal_indicacion;
    }

    public String getContra_indicaciones() {
        return contra_indicaciones;
    }

    public void setContra_indicaciones(String contra_indicaciones) {
        this.contra_indicaciones = contra_indicaciones;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getRuta_foto() {
        return ruta_foto;
    }

    public void setRuta_foto(String ruta_foto) {
        this.ruta_foto = ruta_foto;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", unidades_envase=" + unidades_envase + ", estatus=" + estatus + ", nombre=" + nombre + ", nombre_generico=" + nombre_generico + ", forma_farmaceutica=" + forma_farmaceutica + ", unidad_medida=" + unidad_medida + ", presentacion=" + presentacion + ", principal_indicacion=" + principal_indicacion + ", contra_indicaciones=" + contra_indicaciones + ", concentracion=" + concentracion + ", foto=" + foto + ", ruta_foto=" + ruta_foto + ", codigo_barras=" + codigo_barras + ", precio_compra=" + precio_compra + ", precio_venta=" + precio_venta + '}';
    }
    
    
    
    
}
