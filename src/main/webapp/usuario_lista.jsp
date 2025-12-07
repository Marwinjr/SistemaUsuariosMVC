<%@page import="java.util.List"%>
<%@page import="com.mycompany.proyectointermedia.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Usuarios</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div style="height: 90px;"></div>

        <div class="container-fluid px-4"> <div class="row">
                
                <div class="col-md-4">
                    <div class="card shadow-sm mb-4">
                        <div class="card-header bg-primary text-white">
                            <h5 class="mb-0"><i class="fas fa-user-plus"></i> Datos del Usuario</h5>
                        </div>
                        <div class="card-body">
                            <form action="Controlador?menu=Usuario" method="POST">
                                
                                <div class="row">
                                    <div class="col-6 mb-2">
                                        <label>Nombres:</label>
                                        <input type="text" name="txtNombre" value="${usuario.getNombre()}" class="form-control" required>
                                    </div>
                                    <div class="col-6 mb-2">
                                        <label>Apellidos:</label>
                                        <input type="text" name="txtApellido" value="${usuario.getApellido()}" class="form-control" required>
                                    </div>
                                </div>

                                <div class="mb-2">
                                    <label>Correo:</label>
                                    <input type="email" name="txtCorreo" value="${usuario.getCorreo()}" class="form-control" required>
                                </div>
                                
                                <div class="mb-2">
                                    <label>Celular:</label>
                                    <input type="text" name="txtCelular" value="${usuario.getCelular()}" class="form-control" required>
                                </div>

                                <div class="mb-2">
                                    <label>Contraseña:</label>
                                    <input type="password" name="txtPass" value="${usuario.getPassword()}" class="form-control" required>
                                </div>

                                <div class="mb-3">
                                    <label>Cargo (ID):</label>
                                    <input type="number" name="txtCargo" value="${usuario.getId_cargo()}" class="form-control" placeholder="1=Admin, 2=Empleado" required>
                                </div>
                                
                                <input type="hidden" name="id" value="${usuario.getId()}">

                                <div class="d-grid gap-2">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-primary">Agregar</button>
                                    <button type="submit" name="accion" value="Actualizar" class="btn btn-warning text-white">Actualizar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-md-8">
                    <div class="card shadow-sm">
                         <div class="card-body p-0">
                            <table class="table table-hover table-bordered mb-0">
                                <thead class="table-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>NOMBRES</th>
                                        <th>APELLIDOS</th>
                                        <th>CORREO</th> 
                                        <th>CARGO</th>
                                        <th>ACCIONES</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        List<Usuario> lista = (List<Usuario>) request.getAttribute("usuarios");
                                        if (lista != null) {
                                            for (Usuario u : lista) {
                                    %>
                                    <tr>
                                        <td><%= u.getId() %></td>
                                        <td><%= u.getNombre() %></td>
                                        <td><%= u.getApellido() %></td>
                                        <td><%= u.getCorreo() %></td> 
                                        <td><%= u.getId_cargo() %></td>
                                        <td>
                                            <a href="Controlador?menu=Usuario&accion=Editar&id=<%= u.getId() %>" class="btn btn-warning btn-sm text-white">
                                                <i class="fas fa-edit"></i>
                                            </a>
                                            <a href="Controlador?menu=Usuario&accion=Eliminar&id=<%= u.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('¿Seguro?');">
                                                <i class="fas fa-trash"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <% 
                                            }
                                        } 
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>