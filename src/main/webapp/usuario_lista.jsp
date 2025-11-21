<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.proyectointermedia.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Usuarios</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-4">
            <h1>Lista de Usuarios</h1>
            
            <a href="UsuarioController?accion=nuevo" class="btn btn-success mb-3">Nuevo Usuario</a>
            
            <table class="table table-bordered table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>APELLIDO</th>
                        <th>CELULAR</th>
                        <th>CARGO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Recibimos la lista que mandó el Controlador
                        List<Usuario> lista = (List<Usuario>) request.getAttribute("usuarios");
                        if (lista != null) {
                            for (Usuario u : lista) {
                    %>
                    <tr>
                        <td><%= u.getId() %></td>
                        <td><%= u.getNombre() %></td>
                        <td><%= u.getApellido() %></td>
                        <td><%= u.getCelular() %></td>
                        <td><%= u.getNombre_cargo() %></td> <td>
                            <a href="UsuarioController?accion=editar&id=<%= u.getId() %>" class="btn btn-warning btn-sm">Editar</a>
                            
                            <a href="UsuarioController?accion=eliminar&id=<%= u.getId() %>" 
                               class="btn btn-danger btn-sm" 
                               onclick="return confirm('¿Está seguro de eliminar este registro? Si selecciona No, no pasará nada.');">
                               Eliminar
                            </a>
                        </td>
                    </tr>
                    <% 
                            }
                        } 
                    %>
                </tbody>
            </table>
            <a href="index.jsp" class="btn btn-secondary">Volver al Inicio</a>
        </div>
    </body>
</html>