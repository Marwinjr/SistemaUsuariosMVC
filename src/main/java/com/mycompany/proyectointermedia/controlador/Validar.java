package com.mycompany.proyectointermedia.controlador;

import com.mycompany.proyectointermedia.dao.UsuarioDAO;
import com.mycompany.proyectointermedia.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; // <--- AGREGA ESTO
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// AGREGA ESTA LÍNEA EXACTA AQUÍ ABAJO:
@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();
    Usuario u = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ... (El resto del código queda igual, no hace falta cambiarlo)
        String accion = request.getParameter("accion");
        
        if (accion.equalsIgnoreCase("Ingresar")) {
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            
            u = dao.validar(user, pass);
            
            if (u.getCorreo() != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", u);
                session.setAttribute("nombre", u.getNombre());
                session.setAttribute("correo", u.getCorreo());
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}