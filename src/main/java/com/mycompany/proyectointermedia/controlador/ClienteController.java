package com.mycompany.proyectointermedia.controlador;

import com.mycompany.proyectointermedia.dao.ClienteDAO;
import com.mycompany.proyectointermedia.modelo.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    ClienteDAO cdao = new ClienteDAO();
    Cliente c = new Cliente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        String listar = "clientes.jsp";
        String add = "cliente_form.jsp"; // Crearemos este archivo en el paso 4
        
        if (accion == null) accion = "listar";
        
        switch (accion) {
            case "listar":
                List<Cliente> lista = cdao.listar();
                request.setAttribute("clientes", lista);
                request.getRequestDispatcher(listar).forward(request, response);
                break;
                
            case "nuevo":
                request.getRequestDispatcher(add).forward(request, response);
                break;
                
            case "Guardar":
                String dni = request.getParameter("txtDni");
                String nom = request.getParameter("txtNombres");
                String dir = request.getParameter("txtDireccion");
                String est = request.getParameter("txtEstado");
                c.setDni(dni);
                c.setNombres(nom);
                c.setDireccion(dir);
                c.setEstado(est);
                cdao.agregar(c);
                request.getRequestDispatcher("ClienteController?accion=listar").forward(request, response);
                break;
                
            case "editar":
                int id = Integer.parseInt(request.getParameter("id"));
                Cliente cli = cdao.listarId(id);
                request.setAttribute("cliente", cli);
                request.getRequestDispatcher(add).forward(request, response);
                break;
                
            case "Actualizar":
                int id1 = Integer.parseInt(request.getParameter("id"));
                String dni1 = request.getParameter("txtDni");
                String nom1 = request.getParameter("txtNombres");
                String dir1 = request.getParameter("txtDireccion");
                String est1 = request.getParameter("txtEstado");
                c.setId(id1);
                c.setDni(dni1);
                c.setNombres(nom1);
                c.setDireccion(dir1);
                c.setEstado(est1);
                cdao.actualizar(c);
                request.getRequestDispatcher("ClienteController?accion=listar").forward(request, response);
                break;
                
            case "eliminar":
                int id2 = Integer.parseInt(request.getParameter("id"));
                cdao.delete(id2);
                request.getRequestDispatcher("ClienteController?accion=listar").forward(request, response);
                break;
        }
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