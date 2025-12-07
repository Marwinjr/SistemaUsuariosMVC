package com.mycompany.proyectointermedia.controlador;

import com.mycompany.proyectointermedia.dao.ProductoDAO;
import com.mycompany.proyectointermedia.modelo.Producto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

    ProductoDAO pdao = new ProductoDAO();
    Producto p = new Producto();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        // Rutas de las vistas
        String listar = "productos.jsp";
        String add = "producto_form.jsp"; // Creamos este archivo en el paso 4
        
        // Si no hay acción, por defecto listamos
        if (accion == null) accion = "listar";
        
        switch (accion) {
            case "listar":
                List<Producto> lista = pdao.listar();
                request.setAttribute("productos", lista);
                request.getRequestDispatcher(listar).forward(request, response);
                break;
                
            case "nuevo":
                request.getRequestDispatcher(add).forward(request, response);
                break;
                
            case "Guardar":
                String nom = request.getParameter("txtNombres");
                double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                int stock = Integer.parseInt(request.getParameter("txtStock"));
                String estado = request.getParameter("txtEstado");
                p.setNom(nom);
                p.setPrecio(precio);
                p.setStock(stock);
                p.setEstado(estado);
                pdao.agregar(p);
                // Volvemos a listar
                request.getRequestDispatcher("ProductoController?accion=listar").forward(request, response);
                break;
                
            case "editar":
                int id = Integer.parseInt(request.getParameter("id"));
                Producto pro = pdao.listarId(id);
                request.setAttribute("producto", pro);
                request.getRequestDispatcher(add).forward(request, response);
                break;
                
            case "Actualizar":
                int id1 = Integer.parseInt(request.getParameter("id"));
                String nom1 = request.getParameter("txtNombres");
                double precio1 = Double.parseDouble(request.getParameter("txtPrecio"));
                int stock1 = Integer.parseInt(request.getParameter("txtStock"));
                String estado1 = request.getParameter("txtEstado");
                p.setId(id1);
                p.setNom(nom1);
                p.setPrecio(precio1);
                p.setStock(stock1);
                p.setEstado(estado1);
                pdao.actualizar(p);
                request.getRequestDispatcher("ProductoController?accion=listar").forward(request, response);
                break;
                
            case "eliminar":
                int id2 = Integer.parseInt(request.getParameter("id"));
                pdao.delete(id2);
                request.getRequestDispatcher("ProductoController?accion=listar").forward(request, response);
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