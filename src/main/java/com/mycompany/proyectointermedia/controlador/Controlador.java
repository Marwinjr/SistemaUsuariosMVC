package com.mycompany.proyectointermedia.controlador;

import com.mycompany.proyectointermedia.dao.ClienteDAO;
import com.mycompany.proyectointermedia.dao.ProductoDAO;
import com.mycompany.proyectointermedia.dao.UsuarioDAO;
import com.mycompany.proyectointermedia.dao.VentaDAO;
import com.mycompany.proyectointermedia.modelo.Cliente;
import com.mycompany.proyectointermedia.modelo.Producto;
import com.mycompany.proyectointermedia.modelo.Usuario;
import com.mycompany.proyectointermedia.modelo.Venta;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    
    Usuario u = new Usuario();
    UsuarioDAO udao = new UsuarioDAO();
    
    Venta v = new Venta();
    VentaDAO vdao = new VentaDAO();
    
    // Variables para la Venta
    List<Venta> lista = new ArrayList<>();
    int item = 0;
    double totalPagar = 0.0;
    int numberserie = 1;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if (menu == null) menu = "Principal";
        if (accion == null) accion = "Listar";

        // --------------------------------------------------------------------------------------
        // 1. MENU PRINCIPAL
        // --------------------------------------------------------------------------------------
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        // --------------------------------------------------------------------------------------
        // 2. MENU PRODUCTOS
        // --------------------------------------------------------------------------------------
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List listaProductos = pdao.listar();
                    request.setAttribute("productos", listaProductos);
                    break;

                case "Agregar":
                    p = new Producto(); 
                    String nom = request.getParameter("txtNombres");
                    double pre = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String est = request.getParameter("txtEstado");
                    
                    p.setNom(nom); 
                    p.setPrecio(pre);
                    p.setStock(stock);
                    p.setEstado(est);
                    pdao.agregar(p); // Tu ProductoDAO sí usa "agregar"
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    return;

                case "Editar":
                    int id_prod = Integer.parseInt(request.getParameter("id"));
                    Producto p_edit = pdao.listarId(id_prod); // Tu ProductoDAO sí usa "listarId"
                    request.setAttribute("producto", p_edit);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    return;

                case "Actualizar":
                    String nom1 = request.getParameter("txtNombres");
                    double pre1 = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock1 = Integer.parseInt(request.getParameter("txtStock"));
                    String est1 = request.getParameter("txtEstado");
                    int id_prod_act = Integer.parseInt(request.getParameter("id"));

                    p.setNom(nom1);
                    p.setPrecio(pre1);
                    p.setStock(stock1);
                    p.setEstado(est1);
                    p.setId(id_prod_act);
                    pdao.actualizar(p); // Tu ProductoDAO sí usa "actualizar"
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    return;

                case "Eliminar":
                    int id_prod_del = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(id_prod_del); // Tu ProductoDAO sí usa "delete"
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    return;
            }
            request.getRequestDispatcher("productos.jsp").forward(request, response);
        }

        // --------------------------------------------------------------------------------------
        // 3. MENU CLIENTES
        // --------------------------------------------------------------------------------------
        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List listaClientes = cdao.listar();
                    request.setAttribute("clientes", listaClientes);
                    break;

                case "Agregar":
                    c = new Cliente(); // Limpiamos
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String dir = request.getParameter("txtDireccion");
                    String est = request.getParameter("txtEstado");
                    
                    c.setDni(dni);
                    c.setNombres(nom);
                    c.setDireccion(dir);
                    c.setEstado(est);
                    
                    cdao.agregar(c); // Verifica si en tu DAO se llama 'agregar' o 'add'
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    return;

                case "Editar":
                    int id_cli = Integer.parseInt(request.getParameter("id"));
                    Cliente c_edit = cdao.listarId(id_cli); // Verifica si se llama 'listarId' o 'list'
                    request.setAttribute("cliente", c_edit);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    return;

                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String dir1 = request.getParameter("txtDireccion");
                    String est1 = request.getParameter("txtEstado");
                    int id_cli_act = Integer.parseInt(request.getParameter("id"));

                    c.setDni(dni1);
                    c.setNombres(nom1);
                    c.setDireccion(dir1);
                    c.setEstado(est1);
                    c.setId(id_cli_act);
                    
                    cdao.actualizar(c); // Verifica si se llama 'actualizar' o 'edit'
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    return;

                case "Eliminar":
                    int id_cli_del = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(id_cli_del); // Verifica si se llama 'delete' o 'eliminar'
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    return;
            }
            request.getRequestDispatcher("clientes.jsp").forward(request, response);
        }
        // --------------------------------------------------------------------------------------
        // 4. MENU USUARIOS (CORREGIDO CON TUS NOMBRES DEL DAO)
        // --------------------------------------------------------------------------------------
        if (menu.equals("Usuario")) {
            switch (accion) {
                case "Listar":
                    List<Usuario> listaUsuarios = udao.listar();
                    request.setAttribute("usuarios", listaUsuarios);
                    break;

                case "Agregar":
                    u = new Usuario(); 
                    String nom = request.getParameter("txtNombre");
                    String ape = request.getParameter("txtApellido");
                    String cor = request.getParameter("txtCorreo");
                    String cel = request.getParameter("txtCelular");
                    String pass = request.getParameter("txtPass");
                    int cargo = Integer.parseInt(request.getParameter("txtCargo"));
                    
                    u.setNombre(nom);
                    u.setApellido(ape);
                    u.setCorreo(cor);
                    u.setCelular(cel);
                    u.setPassword(pass);
                    u.setId_cargo(cargo);
                    
                    // CORREGIDO: Usamos "add" en lugar de "agregar"
                    udao.add(u); 
                    
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    return;

                case "Editar":
                    int id_user = Integer.parseInt(request.getParameter("id"));
                    
                    // CORREGIDO: Usamos "list" en lugar de "listarId"
                    Usuario u_edit = udao.list(id_user); 
                    
                    request.setAttribute("usuario", u_edit);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    return;

                case "Actualizar":
                    String nom1 = request.getParameter("txtNombre");
                    String ape1 = request.getParameter("txtApellido");
                    String cor1 = request.getParameter("txtCorreo");
                    String cel1 = request.getParameter("txtCelular");
                    String pass1 = request.getParameter("txtPass");
                    int cargo1 = Integer.parseInt(request.getParameter("txtCargo"));
                    int id_user_act = Integer.parseInt(request.getParameter("id"));

                    u.setNombre(nom1);
                    u.setApellido(ape1);
                    u.setCorreo(cor1);
                    u.setCelular(cel1);
                    u.setPassword(pass1);
                    u.setId_cargo(cargo1);
                    u.setId(id_user_act);
                    
                    // CORREGIDO: Usamos "edit" en lugar de "actualizar"
                    udao.edit(u); 
                    
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    return;

                case "Eliminar":
                    int id_user_del = Integer.parseInt(request.getParameter("id"));
                    
                    // CORREGIDO: Usamos "eliminar" en lugar de "delete"
                    udao.eliminar(id_user_del); 
                    
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    return;
            }
            request.getRequestDispatcher("usuario_lista.jsp").forward(request, response);
        }
        
        // --------------------------------------------------------------------------------------
        // 5. NUEVA VENTA
        // --------------------------------------------------------------------------------------
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    c.setDni(dni);
                    c = cdao.buscar(dni);
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numberserie);
                    break;
                    
                case "BuscarProducto":
                    int id_prod_v = Integer.parseInt(request.getParameter("codigoproducto"));
                    p = pdao.listarId(id_prod_v);
                    request.setAttribute("c", c);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("nserie", numberserie);
                    break;
                    
                case "Agregar":
                    request.setAttribute("c", c);
                    totalPagar = 0.0;
                    item = item + 1;
                    int cod = p.getId();
                    String descripcion = request.getParameter("nomproducto");
                    double precio = Double.parseDouble(request.getParameter("precio"));
                    int cant = Integer.parseInt(request.getParameter("cant"));
                    double subtotal = precio * cant;
                    
                    v = new Venta();
                    v.setId(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numberserie);
                    break;
                    
                case "GenerarVenta":
                    v.setIdcliente(c.getId());
                    v.setIdempleado(1); 
                    v.setNumserie(""+numberserie);
                    v.setFecha(LocalDate.now().toString());
                    v.setPrecio(totalPagar);
                    v.setEstado("1");
                    vdao.GuardarVenta(v);
                    
                    int idv = Integer.parseInt(vdao.GenerarSerie());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.GuardarDetalleVentas(v);
                    }
                    
                    lista.clear();
                    item = 0;
                    totalPagar = 0.0;
                    numberserie++; 
                    request.setAttribute("nserie", numberserie);
                    break;
                    
                case "Cancelar":
                    lista.clear();
                    item = 0;
                    totalPagar = 0.0;
                    request.setAttribute("nserie", numberserie);
                    break;

                default:
                    v = new Venta();
                    lista = new ArrayList<>();
                    item = 0;
                    totalPagar = 0.0;
                    
                    String serie = vdao.GenerarSerie();
                    if (serie == null) {
                        numberserie = 1;
                    } else {
                        numberserie = Integer.parseInt(serie) + 1;
                    }
                    request.setAttribute("nserie", numberserie);
            }
            request.getRequestDispatcher("registrarVenta.jsp").forward(request, response);
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