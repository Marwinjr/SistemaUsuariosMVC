package com.mycompany.proyectointermedia.controlador;

import com.mycompany.proyectointermedia.dao.CargoDAO;
import com.mycompany.proyectointermedia.dao.UsuarioDAO;
import com.mycompany.proyectointermedia.modelo.Cargo;
import com.mycompany.proyectointermedia.modelo.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioController extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();
    CargoDAO cargoDao = new CargoDAO();
    Usuario u = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Recibimos la acción que viene del botón (ej: "listar", "guardar", "eliminar")
        String accion = request.getParameter("accion");
        
        // Rutas de las vistas
        String acceso = ""; 
        
        if (accion != null) {
            switch (accion) {
                case "listar":
                    List<Usuario> lista = dao.listar();
                    request.setAttribute("usuarios", lista);
                    acceso = "usuario_lista.jsp";
                    break;
                    
                case "nuevo":
                    // Cargamos los cargos para el ComboBox antes de ir al formulario
                    List<Cargo> listaCargos = cargoDao.listar();
                    request.setAttribute("cargos", listaCargos);
                    acceso = "usuario_form.jsp";
                    break;
                    
                case "Guardar":
                    String nom = request.getParameter("nombre");
                    String ape = request.getParameter("apellido");
                    String cel = request.getParameter("celular");
                    int idCargo = Integer.parseInt(request.getParameter("cboCargo")); // El valor del Select
                    
                    u.setNombre(nom);
                    u.setApellido(ape);
                    u.setCelular(cel);
                    u.setId_cargo(idCargo);
                    dao.add(u);
                    
                    // Volvemos a listar
                    acceso = "UsuarioController?accion=listar";
                    break;
                    
                case "editar":
                    request.setAttribute("iduser", request.getParameter("id"));
                    int id = Integer.parseInt(request.getParameter("id"));
                    Usuario usu = dao.list(id);
                    request.setAttribute("usuario", usu);
                    
                    // También necesitamos los cargos para el select
                    List<Cargo> listaCargosEdit = cargoDao.listar();
                    request.setAttribute("cargos", listaCargosEdit);
                    
                    acceso = "usuario_form.jsp";
                    break;
                    
                case "Actualizar":
                    int idUser = Integer.parseInt(request.getParameter("id"));
                    String nomU = request.getParameter("nombre");
                    String apeU = request.getParameter("apellido");
                    String celU = request.getParameter("celular");
                    int idCargoU = Integer.parseInt(request.getParameter("cboCargo"));
                    
                    u.setId(idUser);
                    u.setNombre(nomU);
                    u.setApellido(apeU);
                    u.setCelular(celU);
                    u.setId_cargo(idCargoU);
                    dao.edit(u);
                    acceso = "UsuarioController?accion=listar";
                    break;
                    
                case "eliminar":
                    int idDel = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(idDel);
                    acceso = "UsuarioController?accion=listar";
                    break;
            }
        }
        
        // Redireccionamos a la página que corresponda
        request.getRequestDispatcher(acceso).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}