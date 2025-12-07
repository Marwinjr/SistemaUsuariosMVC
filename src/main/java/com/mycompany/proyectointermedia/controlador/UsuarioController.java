package com.mycompany.proyectointermedia.controlador;

import com.mycompany.proyectointermedia.dao.CargoDAO;
import com.mycompany.proyectointermedia.dao.UsuarioDAO;
import com.mycompany.proyectointermedia.modelo.Cargo;
import com.mycompany.proyectointermedia.modelo.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();
    CargoDAO cargoDao = new CargoDAO();
    Usuario u = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        String acceso = ""; 
        
        if (accion != null) {
            switch (accion) {
                case "listar":
                    List<Usuario> lista = dao.listar();
                    request.setAttribute("usuarios", lista);
                    acceso = "usuario_lista.jsp";
                    break;
                    
                case "nuevo":
                    List<Cargo> listaCargos = cargoDao.listar();
                    request.setAttribute("cargos", listaCargos);
                    acceso = "usuario_form.jsp";
                    break;
                    
                case "Guardar":
                    // Recibimos TODOS los datos, incluyendo los nuevos
                    String nom = request.getParameter("nombre");
                    String ape = request.getParameter("apellido");
                    String cor = request.getParameter("correo");      // <--- NUEVO
                    String pass = request.getParameter("password");   // <--- NUEVO
                    String cel = request.getParameter("celular");
                    int idCargo = Integer.parseInt(request.getParameter("cboCargo"));
                    
                    u.setNombre(nom);
                    u.setApellido(ape);
                    u.setCorreo(cor);      // <--- NUEVO
                    u.setPassword(pass);   // <--- NUEVO
                    u.setCelular(cel);
                    u.setId_cargo(idCargo);
                    
                    dao.add(u); // Ahora sí envía todo completo
                    acceso = "UsuarioController?accion=listar";
                    break;
                    
                case "editar":
                    request.setAttribute("iduser", request.getParameter("id"));
                    int id = Integer.parseInt(request.getParameter("id"));
                    Usuario usu = dao.list(id);
                    request.setAttribute("usuario", usu);
                    
                    List<Cargo> listaCargosEdit = cargoDao.listar();
                    request.setAttribute("cargos", listaCargosEdit);
                    
                    acceso = "usuario_form.jsp";
                    break;
                    
                case "Actualizar":
                    int idUser = Integer.parseInt(request.getParameter("id"));
                    String nomU = request.getParameter("nombre");
                    String apeU = request.getParameter("apellido");
                    String corU = request.getParameter("correo");     // <--- NUEVO
                    String passU = request.getParameter("password");  // <--- NUEVO
                    String celU = request.getParameter("celular");
                    int idCargoU = Integer.parseInt(request.getParameter("cboCargo"));
                    
                    u.setId(idUser);
                    u.setNombre(nomU);
                    u.setApellido(apeU);
                    u.setCorreo(corU);     // <--- NUEVO
                    u.setPassword(passU);  // <--- NUEVO
                    u.setCelular(celU);
                    u.setId_cargo(idCargoU);
                    
                    dao.edit(u); // Envía todo actualizado
                    acceso = "UsuarioController?accion=listar";
                    break;
                    
                case "eliminar":
                    int idDel = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(idDel);
                    acceso = "UsuarioController?accion=listar";
                    break;
            }
        }
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