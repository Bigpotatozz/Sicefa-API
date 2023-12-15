/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import static jakarta.ws.rs.core.Response.status;
import java.sql.SQLException;
import java.util.ArrayList;
import org.utl.controlador.Controller_bd;
import org.utl.modelo.Cliente;
import org.utl.modelo.Empleado;
import org.utl.modelo.Producto;
import org.utl.modelo.Sucursal;

/**
 *
 * @author oscar
 */
@Path("db")
public class Rest extends Application {

    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response login(@QueryParam("user") @DefaultValue("") String user,
            @QueryParam("password") @DefaultValue("") String password) {
        String mensaje = null;
        if (user.equals("admin") && password.equals("root")) {
            mensaje = """
                            {"response":"Desea ingresar a SICEFA?"}
                        """;
        } else {
            mensaje = """
                            {"response":"null"}
                        """;
        }
        System.out.println("Datos:" + user + "-" + password);
        return Response.status(Response.Status.OK).entity(mensaje).build();
    }

    ///////////////////////////////CONSULTAR////////////////////////////////////////////
    @Path("productos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(@QueryParam("id") int productId) throws SQLException {

        String out = "";
        Controller_bd bd = new Controller_bd();
        ArrayList<Producto> productos = bd.getProducto(productId);

        Gson json = new Gson();
        out = json.toJson(productos);

        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("empleados")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees(@QueryParam("empleadoId") int empleadoId) throws SQLException {
        String out = "";
        Controller_bd bd = new Controller_bd();

        // Llama al método getEmpleado con el nuevo parámetro productId
        ArrayList<Empleado> empleados = bd.getEmpleado(empleadoId);

        Gson json = new Gson();
        out = json.toJson(empleados);

        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("sucursales")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSucursales(@QueryParam("sucursalId") int sucursalId) throws SQLException {
        String out = "";
        Controller_bd bd = new Controller_bd();

        // Llama al método getSucursal con el nuevo parámetro sucursalId
        ArrayList<Sucursal> sucursales = bd.getSucursal(sucursalId);

        Gson json = new Gson();
        out = json.toJson(sucursales);

        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("clientes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes(@QueryParam("clienteId") int clienteId) throws SQLException {
        String out = "";
        Controller_bd bd = new Controller_bd();

        // Llama al método getCliente con el nuevo parámetro clienteId
        ArrayList<Cliente> clientes = bd.getCliente(clienteId);

        Gson json = new Gson();
        out = json.toJson(clientes);

        return Response.status(Response.Status.OK).entity(out).build();
    }

    /////////////////////////////////////////INSERTAR//////////////////////////////////////////////////////////
    @Path("cliente/agregar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

    public Response postClientes(
            @FormParam("nombre") String nombre,
            @FormParam("paterno") String paterno,
            @FormParam("materno") String materno,
            @FormParam("genero") String genero,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("rfc") String rfc,
            @FormParam("curp") String curp,
            @FormParam("domicilio") String domicilio,
            @FormParam("cp") String cp,
            @FormParam("ciudad") String ciudad,
            @FormParam("estado") String estado,
            @FormParam("telefono") String telefono,
            @FormParam("foto") String foto,
            @FormParam("email") String email
    ) throws SQLException {

        String out = "Realizado con exito";

        Controller_bd controller = new Controller_bd();
        controller.insertarCliente(nombre, paterno, materno, genero, fechaNacimiento, rfc, curp, domicilio, cp, ciudad, estado, telefono, foto, email);
        return Response.status(Response.Status.OK).entity(out).build();

    }

    @Path("empleado/agregar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postEmpleado(
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("genero") String genero,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("rfc") String rfc,
            @FormParam("curp") String curp,
            @FormParam("domicilio") String domicilio,
            @FormParam("codigoPostal") String codigoPostal,
            @FormParam("ciudad") String ciudad,
            @FormParam("estado") String estado,
            @FormParam("telefono") String telefono,
            @FormParam("foto") String foto,
            @FormParam("idSucursal") int idSucursal,
            @FormParam("rol") String rol,
            @FormParam("puesto") String puesto,
            @FormParam("salarioBruto") float salarioBruto
    ) throws SQLException {

        String out = "Realizado con exito";

        Controller_bd controller = new Controller_bd();
        controller.insertarEmpleado(nombre, apellidoPaterno, apellidoMaterno, genero, fechaNacimiento, rfc, curp, domicilio, curp, ciudad, estado, telefono, foto, idSucursal, rol, puesto, salarioBruto);
        return Response.status(Response.Status.OK).entity(out).build();

    }

    @Path("sucursal/agregar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

    public Response postSucursal(
            @FormParam("nombre") String nombre,
            @FormParam("titular") String titular,
            @FormParam("rfc") String rfc,
            @FormParam("domicilio") String domicilio,
            @FormParam("colonia") String colonia,
            @FormParam("codigoPostal") String codigoPostal,
            @FormParam("ciudad") String ciudad,
            @FormParam("estado") String estado,
            @FormParam("telefono") String telefono,
            @FormParam("latitud") String latitud,
            @FormParam("longitud") String longitud
    ) throws SQLException {

        String out = "Realizado con exito";

        Controller_bd controller = new Controller_bd();
        controller.insertarSucursal(nombre, titular, rfc, domicilio, colonia, codigoPostal, ciudad, estado, telefono, latitud, longitud);
        return Response.status(Response.Status.OK).entity(out).build();

    }

    @Path("productos/agregar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

    public Response postProducto(
            @FormParam("nombre") String nombre,
            @FormParam("nombreGenerico") String nombreGenerico,
            @FormParam("formaFarmaceutica") String formaFarmaceutica,
            @FormParam("unidadMedida") String unidadMedida,
            @FormParam("presentacion") String presentacion,
            @FormParam("principalIndicacion") String principalIndicacion,
            @FormParam("contraindicaciones") String contraindicaciones,
            @FormParam("concentracion") String concentracion,
            @FormParam("unidadesEnvase") int unidadesEnvase,
            @FormParam("precioCompra") float precioCompra,
            @FormParam("precioVenta") float precioVenta,
            @FormParam("foto") String foto,
            @FormParam("rutaFoto") String rutaFoto,
            @FormParam("codigoBarras") String codigoBarras
    ) throws SQLException {

        String out = "Realizado con exito";

        Controller_bd controller = new Controller_bd();
        controller.insertarProducto(nombre, nombreGenerico, formaFarmaceutica, unidadMedida, presentacion, principalIndicacion, contraindicaciones, concentracion, unidadesEnvase, precioCompra, precioVenta, foto, rutaFoto, codigoBarras);
        return Response.status(Response.Status.OK).entity(out).build();

    }

    /////////////////////////////////ELIMINAR////////////////////////////////////////////////////////////////
    @Path("producto/eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response deleteProducto(@FormParam("idProducto") int idProducto) throws SQLException, Exception {

        String out = "Eliminado con exito";
        Controller_bd controller = new Controller_bd();
        controller.deleteProducto(idProducto);
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("sucursal/eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response deleteSucursal(@FormParam("idSucursal") int idSucursal) throws SQLException {

        String out = "Eliminado con exito";
        Controller_bd controller = new Controller_bd();
        controller.deleteSucursal(idSucursal);
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("empleado/eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response deleteEmpleado(@FormParam("idEmpleado") int idEmpleado) throws SQLException {

        String out = "Eliminado con exito";
        Controller_bd controller = new Controller_bd();
        controller.deleteEmpleado(idEmpleado);
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("cliente/eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response deleteCliente(@FormParam("idCliente") int idCliente) throws SQLException {

        String out = "Eliminado with exito";
        Controller_bd controller = new Controller_bd();
        controller.deleteCliente(idCliente);
        return Response.status(Response.Status.OK).entity(out).build();
    }

    //////////////////////////////////MODIFICAR////////////////////////////////////////////
    @Path("producto/modificar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response modificarProducto(
            @FormParam("idProducto") int idProducto,
            @FormParam("nombre") String nombre,
            @FormParam("nombreGenerico") String nombreGenerico,
            @FormParam("formaFarmaceutica") String formaFarmaceutica,
            @FormParam("unidadMedida") String unidadMedida,
            @FormParam("principalIndicacion") String principalIndicacion,
            @FormParam("presentacion") String presentacion,
            @FormParam("contraindicaciones") String contraindicaciones,
            @FormParam("concentracion") String concentracion,
            @FormParam("unidadesEnvase") int unidadesEnvase,
            @FormParam("precioCompra") float precioCompra,
            @FormParam("precioVenta") float precioVenta,
            @FormParam("foto") String foto,
            @FormParam("rutaFoto") String rutaFoto,
            @FormParam("codigoBarras") String codigoBarras) throws Exception {

        String out = "Modificado con exito";
        Controller_bd controller = new Controller_bd();
        controller.modifyProducto(idProducto, nombre, nombreGenerico, formaFarmaceutica, unidadMedida, presentacion, principalIndicacion, contraindicaciones, concentracion, unidadesEnvase, precioCompra, precioVenta, foto, rutaFoto, codigoBarras);
        return Response.status(Response.Status.OK).entity(out).build();

    }

    @Path("empleado/modificar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response modificarEmpleado(
            @FormParam("idEmpleado") int idEmpleado,
            @FormParam("nombre") String nombre,
            @FormParam("paterno") String paterno,
            @FormParam("materno") String materno,
            @FormParam("genero") String genero,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("rfc") String rfc,
            @FormParam("curp") String curp,
            @FormParam("domicilio") String domicilio,
            @FormParam("codigoPostal") String codigoPostal,
            @FormParam("ciudad") String ciudad,
            @FormParam("estado") String estado,
            @FormParam("telefono") String telefono,
            @FormParam("foto") String foto,
            @FormParam("idSucursal") int idSucursal,
            @FormParam("rol") String rol,
            @FormParam("nombreUsuario") String nombreUsuario,
            @FormParam("contrasenia") String contrasenia,
            @FormParam("puesto") String puesto,
            @FormParam("salarioBruto") float salarioBruto
    ) throws Exception {

        String out = "Modificado con exito";
        Controller_bd controller = new Controller_bd();
        controller.modifyEmpleado(idEmpleado, nombre, paterno, materno, genero, fechaNacimiento, rfc, curp, domicilio, codigoPostal, ciudad, estado, telefono, foto, idSucursal, rol, nombreUsuario, contrasenia, puesto, salarioBruto);
        return Response.status(Response.Status.OK).entity(out).build();

    }

    @Path("sucursal/modificar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

    public Response modificarSucursal(
            @FormParam("idSucursal") int idSucursal,
            @FormParam("nombre") String nombre,
            @FormParam("titular") String titular,
            @FormParam("rfc") String rfc,
            @FormParam("domicilio") String domicilio,
            @FormParam("colonia") String colonia,
            @FormParam("codigoPostal") String codigoPostal,
            @FormParam("ciudad") String ciudad,
            @FormParam("estado") String estado,
            @FormParam("telefono") String telefono,
            @FormParam("latitud") String latitud,
            @FormParam("longitud") String longitud
            ) throws Exception {

        String out = "Modificado con exito";
        Controller_bd controller = new Controller_bd();
        controller.modifySucursal(idSucursal, nombre, titular, rfc, domicilio, colonia, codigoPostal, ciudad, estado, telefono, latitud, longitud);
        return Response.status(Response.Status.OK).entity(out).build();

    }
    
    
        @Path("cliente/modificar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

    public Response modificarCliente(
            @FormParam("idCliente") int idCliente,
            @FormParam("nombre") String nombre,
            @FormParam("paterno") String paterno,
            @FormParam("materno") String materno,
            @FormParam("genero") String genero,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("rfc") String rfc,
            @FormParam("curp") String curp,
            @FormParam("domicilio") String domicilio,
            @FormParam("codigoPostal") String codigoPostal,
            @FormParam("ciudad") String ciudad,
            @FormParam("estado") String estado,
            @FormParam("telefono") String telefono,
            @FormParam("foto") String foto,
            @FormParam("email") String email
            ) throws Exception {

        String out = "Modificado con exito";
        Controller_bd controller = new Controller_bd();
        controller.modifyCliente(idCliente, nombre, paterno, materno, genero, fechaNacimiento, rfc, curp, domicilio, codigoPostal, ciudad, estado, telefono, foto, email);
        return Response.status(Response.Status.OK).entity(out).build();

    }

}
