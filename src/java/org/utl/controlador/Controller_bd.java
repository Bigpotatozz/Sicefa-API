/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.controlador;

import java.util.ArrayList;
import org.utl.modelo.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.utl.dsm.conexion.Conexion_sql;
import org.utl.modelo.Cliente;
import org.utl.modelo.Empleado;
import org.utl.modelo.Sucursal;

/**
 *
 * @author oscar
 */
public class Controller_bd {

    ///////////////////CONSULTAR////////////////////////////////////////////////
    public ArrayList<Producto> getProducto(int productId) throws SQLException {

        ArrayList<Producto> products = new ArrayList<>();
        String query = "SELECT * FROM producto";

        if (productId > 0) {
            query += " WHERE idProducto = ?";
        }

        Conexion_sql conexion = new Conexion_sql();
        Connection conn = conexion.open();
        PreparedStatement pstm = conn.prepareStatement(query);

        if (productId > 0) {
            pstm.setInt(1, productId);
        }

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {

            int id = rs.getInt("idProducto");
            String nombre = rs.getString("nombre");
            String nombre_generico = rs.getString("nombreGenerico");
            String forma_farmaceutica = rs.getString("formaFarmaceutica");
            String unidad_medida = rs.getString("unidadMedida");
            String presentacion = rs.getString("presentacion");
            String principal_indicacion = rs.getString("principalIndicacion");
            String contraindicaciones = rs.getString("contraindicaciones");
            String concentracion = rs.getString("concentracion");
            int unidades_envase = rs.getInt("unidadesEnvase");
            float precio_compra = rs.getFloat("precioCompra");
            float precio_venta = rs.getFloat("precioVenta");
            String foto = rs.getString("foto");
            String ruta_foto = rs.getString("rutaFoto");
            String codigo_barras = rs.getString("codigoBarras");
            int estatus = rs.getInt("estatus");

            Producto product = new Producto(id, unidades_envase, estatus, nombre, nombre_generico, forma_farmaceutica, unidad_medida, presentacion, principal_indicacion, contraindicaciones, concentracion, foto, ruta_foto, codigo_barras, precio_compra, precio_venta);
            products.add(product);

        }

        rs.close();
        pstm.close();
        conexion.close();

        return products;

    }

    public ArrayList<Empleado> getEmpleado(int empleadoId) throws SQLException {
        ArrayList<Empleado> employes = new ArrayList<>();
        String query = "SELECT * FROM empleado INNER JOIN persona ON persona.idPersona = empleado.idPersona INNER JOIN usuario ON empleado.idUsuario = usuario.idUsuario";

        if (empleadoId > 0) {
            // Agrega la condición para el filtro de getProducto
            query += " WHERE empleado.idEmpleado = ?";
        }

        Conexion_sql conexion = new Conexion_sql();
        Connection conn = conexion.open();
        PreparedStatement pstm = conn.prepareStatement(query);

        if (empleadoId > 0) {
            pstm.setInt(1, empleadoId);
        }

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {

            int id = rs.getInt("idEmpleado");
            String codigo = rs.getString("codigo");
            Date fechaIngreso = rs.getDate("fechaIngreso");
            String puesto = rs.getString("puesto");
            float salario_bruto = rs.getFloat("salarioBruto");
            int activo = rs.getInt("activo");
            int idPersona = rs.getInt("idPersona");
            int idUsuario = rs.getInt("idUsuario");
            int idSucursal = rs.getInt("idSucursal");
            String nombre = rs.getString("nombre");
            String paterno = rs.getString("apellidoPaterno");
            String materno = rs.getString("apellidoMaterno");
            String genero = rs.getString("genero");
            Date fechaNacimiento = rs.getDate("fechaNacimiento");
            String rfc = rs.getString("rfc");
            String curp = rs.getString("curp");
            String domicilio = rs.getString("domicilio");
            String codigoPostal = rs.getString("codigoPostal");
            String ciudad = rs.getString("ciudad");
            String estado = rs.getString("estado");
            String telefono = rs.getString("telefono");
            String foto = rs.getString("foto");
            String rol = rs.getString("rol");
            String nombreUsuario = rs.getString("nombreUsuario");
            String contrasenia = rs.getString("contrasenia");

            Empleado empleado = new Empleado(idPersona, nombre, paterno, materno, genero, rfc, curp, domicilio, codigoPostal, ciudad, estado, telefono, foto, fechaNacimiento, id, codigo, puesto, fechaIngreso, salario_bruto, activo, idUsuario, nombreUsuario, contrasenia, rol, idSucursal);
            employes.add(empleado);
        }

        rs.close();
        pstm.close();
        conexion.close();

        return employes;
    }

    public ArrayList<Sucursal> getSucursal(int sucursalId) throws SQLException {
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        String query = "SELECT * FROM sucursal";

        if (sucursalId > 0) {
            query += " WHERE idSucursal = ?";
        }

        Conexion_sql conexion = new Conexion_sql();
        Connection conn = conexion.open();
        PreparedStatement pstm = conn.prepareStatement(query);

        if (sucursalId > 0) {
            pstm.setInt(1, sucursalId);
        }

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {

            int id = rs.getInt("idSucursal");
            String nombre = rs.getString("nombre");
            String titular = rs.getString("titular");
            String rfc = rs.getString("rfc");
            String domicilio = rs.getString("domicilio");
            String colonia = rs.getString("colonia");
            String codigoPostal = rs.getString("codigoPostal");
            String ciudad = rs.getString("ciudad");
            String estado = rs.getString("estado");
            String telefono = rs.getString("telefono");
            String latitud = rs.getString("latitud");
            String longitud = rs.getString("longitud");
            int estatus = rs.getInt("estatus");
            Sucursal sucursal = new Sucursal(id, estatus, nombre, titular, rfc, domicilio, colonia, codigoPostal, ciudad, estado, telefono, latitud, longitud);
            sucursales.add(sucursal);

        }

        rs.close();
        pstm.close();
        conexion.close();

        return sucursales;
    }

 public ArrayList<Cliente> getCliente(int clienteId) throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM cliente INNER JOIN persona ON cliente.idPersona = persona.idPersona";

        if (clienteId > 0) {
            query += " WHERE idCliente = ?";
        }

        Conexion_sql conexion = new Conexion_sql();
        Connection conn = conexion.open();
        PreparedStatement pstm = conn.prepareStatement(query);

        if (clienteId > 0) {
            pstm.setInt(1, clienteId);
        }

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("idCliente");
            String email = rs.getString("email");
            Date fechaRegistro = rs.getDate("fechaRegistro");
            int estatus = rs.getInt("estatus");
            int idPersona = rs.getInt("idPersona");
            String nombre = rs.getString("nombre");
            String apellidoPaterno = rs.getString("apellidoPaterno");
            String apellidoMaterno = rs.getString("apellidoMaterno");
            String genero = rs.getString("genero");
            Date fechaNacimiento = rs.getDate("fechaNacimiento");
            String rfc = rs.getString("rfc");
            String curp = rs.getString("curp");
            String domicilio = rs.getString("domicilio");
            String codigoPostal = rs.getString("codigoPostal");
            String ciudad = rs.getString("ciudad");
            String estado = rs.getString("estado");
            String telefono = rs.getString("telefono");
            String foto = rs.getString("foto");

            Cliente cliente = new Cliente(idPersona, nombre, apellidoPaterno, apellidoMaterno, genero, rfc, curp, domicilio, codigoPostal, ciudad, estado, telefono, foto, fechaNacimiento, id, estatus, email, fechaRegistro);
            clientes.add(cliente);

        }

        rs.close();
        pstm.close();
        conexion.close();

        return clientes;
    }

    public void insertarCliente(String nombre, String paterno, String materno, String genero, String fechaNacimiento, String rfc, String curp, String domicilio, String cp, String ciudad, String estado, String telefono, String foto, String email) throws SQLException {

        String query = String.format("""
                                        CALL insertarCliente(
                                        "%s",
                                        "%s",
                                        "%s",
                                        "%s",
                                        "%s",
                                        "%s",
                                        "%s",
                                        "%s",
                                        "%s",
                                        "%s",
                                        "%s",
                                        "%s",
                                        "%s",
                                        "%s",
                                        @var_idPersona
                                        );
                                         """, nombre, paterno, materno, genero, fechaNacimiento, rfc, curp, domicilio, cp, ciudad, estado, telefono, foto, email);

        try {
            Conexion_sql conexion = new Conexion_sql();
            Connection conn = conexion.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            conexion.close();

        } catch (Exception e) {
            throw e;
        }
    }

    public void insertarEmpleado(String nombre, String paterno, String materno, String genero, String fechaNacimiento, String rfc, String curp, String domicilio, String cp, String ciudad, String estado, String telefono, String foto, int idSucursal, String rol, String puesto, float salarioBruto) throws SQLException {

        String query = String.format("""
                                  CALL insertarEmpleado(
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%d",
                                  "%s",
                                  "%s",
                                  "%.2f",
                                  @var_idPersona,
                                  @var_idUsuario,
                                  @var_idEmpleado,
                                  @var_codigoEmpleado
                                  );
                                         """, nombre, paterno, materno, genero, fechaNacimiento, rfc, curp, domicilio, cp, ciudad, estado, telefono, foto, idSucursal, rol, puesto, salarioBruto);

        try {
            Conexion_sql conexion = new Conexion_sql();
            Connection conn = conexion.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            conexion.close();

        } catch (Exception e) {
            throw e;
        }
    }

    public void insertarSucursal(String nombre, String titular, String rfc, String domicilio, String colonia, String codigoPostal, String ciudad, String estado, String telefono, String latitud, String longitud) throws SQLException {

        String query = String.format("""
                                            CALL insertarSucursal(
                                            "%s",
                                            "%s",
                                            "%s",
                                            "%s",
                                            "%s",
                                            "%s",
                                            "%s",
                                            "%s",
                                            "%s",
                                            "%s",
                                            "%s",
                                            @var_idSucursal,
                                            @var_idPersona,
                                            @var_idUsuario ,
                                            @var_idEmpleado ,  
                                            @var_codigoEmpleado ,
                                            @var_nombreUsuario,
                                            @var_contrasenia    
                                            );
                                         """, nombre, titular, rfc, domicilio, colonia, codigoPostal, ciudad, estado, telefono, latitud, longitud);

        try {
            Conexion_sql conexion = new Conexion_sql();
            Connection conn = conexion.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            conexion.close();

        } catch (Exception e) {
            throw e;
        }
    }

    public void insertarProducto(String nombre, String nombreGenerico, String formaFarmaceutica, String unidadMedida, String presentacion, String principalIndicacion, String contraindicaciones, String concentracion, int unidadesEnvase, float precioCompra, float precioVenta, String foto, String rutaFoto, String codigoBarras) throws SQLException {

        String query = String.format("""
    INSERT INTO producto(nombre, nombreGenerico, formaFarmaceutica, unidadMedida, presentacion, principalIndicacion, contraindicaciones, concentracion, unidadesEnvase, precioCompra, precioVenta, foto, rutaFoto, codigoBarras) 
    VALUES("%s","%s","%s","%s","%s","%s","%s","%s","%d","%.2f","%.2f","%s","%s","%s");
""", nombre, nombreGenerico, formaFarmaceutica, unidadMedida, presentacion, principalIndicacion, contraindicaciones, concentracion, unidadesEnvase, precioCompra, precioVenta, foto, rutaFoto, codigoBarras);
        try {
            Conexion_sql conexion = new Conexion_sql();
            Connection conn = conexion.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            conexion.close();

        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteProducto(int idProducto) throws Exception {

        String query = String.format("""
                            CALL eliminarProducto(%d);
            """, idProducto);
        try {
            Conexion_sql conexion = new Conexion_sql();
            Connection conn = conexion.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            conexion.close();

        } catch (Exception e) {
            throw e;
        }

    }

    public void deleteSucursal(int idSucursal) throws SQLException {

        String query = String.format("""
                               CALL eliminarSucursal(%d);
            """, idSucursal);
        try {
            Conexion_sql conexion = new Conexion_sql();
            Connection conn = conexion.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            conexion.close();

        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteEmpleado(int idEmpleado) throws SQLException {

        String query = String.format("""
                             CALL eliminarEmpleado("%d");
            """, idEmpleado);
        try {
            Conexion_sql conexion = new Conexion_sql();
            Connection conn = conexion.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            conexion.close();

        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteCliente(int idCliente) throws SQLException {

        String query = String.format("""
                             CALL eliminarCliente("%d");
            """, idCliente);
        try {
            Conexion_sql conexion = new Conexion_sql();
            Connection conn = conexion.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            conexion.close();

        } catch (Exception e) {
            throw e;
        }
    }

    /////////////////////////////////MODIFICAR///////////////////////////////////////////
    public void modifyProducto(int idProducto, String nombre, String nombreGenerico, String formaFarmaceutica, String unidadMedida, String presentacion, String principalIndicacion, String contraindicaciones, String concentracion, int unidadesEnvase, float precioCompra, float precioVenta, String foto, String rutaFoto, String codigoBarras) throws Exception {
        String query = String.format("""
        CALL modificarProducto( "%d",
                                              "%s",
                                              "%s",
                                              "%s",
                                              "%s",
                                              "%s",
                                              "%s",
                                              "%s",
                                              "%s",
                                              "%d",
                                              "%.2f",
                                               "%.2f",
                                               "%s",
                                               "%s",
                                               "%s"
                                                );
       """, idProducto, nombre, nombreGenerico, formaFarmaceutica, unidadMedida, presentacion, principalIndicacion, contraindicaciones, concentracion, unidadesEnvase, precioCompra, precioVenta, foto, rutaFoto, codigoBarras);

        try {
            Conexion_sql conexion = new Conexion_sql();
            Connection conn = conexion.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            conexion.close();

        } catch (Exception e) {
            throw e;
        }
    }

    public void modifyEmpleado(int idEmpleado, String nombre, String paterno, String materno, String genero, String fechaNacimiento, String rfc, String curp, String domicilio, String codigoPostal, String ciudad, String estado, String telefono, String foto, int idSucursal, String rol, String nombreUsuario, String contrasenia, String puesto, float salarioBruto) throws Exception {
        String query = String.format("""
                                    CALL modificarEmpleado(
                                  "%d",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%d",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%s",
                                  "%.2f"
                                    );                       
       """, idEmpleado, nombre, paterno, materno, genero, fechaNacimiento, rfc, curp, domicilio, codigoPostal, ciudad, estado, telefono, foto, idSucursal, rol, nombreUsuario, contrasenia, puesto, salarioBruto);

        try {
            Conexion_sql conexion = new Conexion_sql();
            Connection conn = conexion.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            conexion.close();

        } catch (Exception e) {
            throw e;
        }
    }

    public void modifySucursal(int idSucursal, String nombre, String titular, String rfc, String domicilio, String colonia, String codigoPostal, String ciudad, String estado, String telefono, String latitud, String longitud) throws Exception {
        String query = String.format("""
                                 CALL modificarSucursal(%d,"%s", "%s","%s","%s","%s","%s","%s","%s","%s","%s","%s");
                                                          
       """, idSucursal, nombre, titular, rfc, domicilio, colonia, codigoPostal, ciudad, estado, telefono, latitud, longitud);

        try {
            Conexion_sql conexion = new Conexion_sql();
            Connection conn = conexion.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            conexion.close();

        } catch (Exception e) {
            throw e;
        }
    }

    public void modifyCliente(int idCliente, String nombre, String paterno, String materno, String genero, String fechaNacimiento, String rfc, String curp, String domicilio, String codigoPostal, String ciudad, String estado, String telefono, String foto, String email) throws Exception {
        String query = String.format("""
                             CALL modificarCliente(
                             "%d",
                             "%s",
                             "%s",
                             "%s",
                             "%s",
                             "%s",
                             "%s",
                             "%s",
                             "%s",
                             "%s",
                             "%s",
                             "%s",
                             "%s",
                             "%s",
                             "%s"
                             );
                                                          
       """, idCliente, nombre, paterno, materno, genero, fechaNacimiento, rfc, curp, domicilio, codigoPostal, ciudad, estado, telefono, foto, email);

        try {
            Conexion_sql conexion = new Conexion_sql();
            Connection conn = conexion.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            conexion.close();

        } catch (Exception e) {
            throw e;
        }
    }

}

