<%@page import="java.util.List"%>
<%@page import="com.mycompany.proyectointermedia.modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes - Jardín Secreto</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div style="height: 90px;"></div>

        <div class="container-fluid px-4">
            <div class="row">
                
                <div class="col-md-4">
                    <div class="card shadow-sm mb-4">
                        <div class="card-header bg-info text-white">
                            <h5 class="mb-0"><i class="fas fa-user-tag"></i> Datos del Cliente</h5>
                        </div>
                        <div class="card-body">
                            <form action="Controlador?menu=Cliente" method="POST">
                                
                                <div class="mb-3">
                                    <label>DNI / Identificación:</label>
                                    <input type="text" name="txtDni" value="${cliente.getDni()}" class="form-control" required>
                                </div>

                                <div class="mb-3">
                                    <label>Nombres:</label>
                                    <input type="text" name="txtNombres" value="${cliente.getNombres()}" class="form-control" required>
                                </div>

                                <div class="mb-3">
                                    <label>Dirección:</label>
                                    <input type="text" name="txtDireccion" value="${cliente.getDireccion()}" class="form-control" required>
                                </div>

                                <div class="mb-3">
                                    <label>Estado:</label>
                                    <input type="text" name="txtEstado" value="${cliente.getEstado()}" class="form-control" placeholder="1 para activo">
                                </div>
                                
                                <input type="hidden" name="id" value="${cliente.getId()}">

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
                                        <th>DNI</th>
                                        <th>NOMBRES</th>
                                        <th>DIRECCIÓN</th> 
                                        <th>ESTADO</th>
                                        <th>ACCIONES</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        List<Cliente> lista = (List<Cliente>) request.getAttribute("clientes");
                                        if (lista != null) {
                                            for (Cliente c : lista) {
                                    %>
                                    <tr>
                                        <td><%= c.getId() %></td>
                                        <td><%= c.getDni() %></td>
                                        <td><%= c.getNombres() %></td>
                                        <td><%= c.getDireccion() %></td> 
                                        <td><%= c.getEstado() %></td>
                                        <td>
                                            <a href="Controlador?menu=Cliente&accion=Editar&id=<%= c.getId() %>" class="btn btn-warning btn-sm text-white">
                                                <i class="fas fa-edit"></i>
                                            </a>
                                            <a href="Controlador?menu=Cliente&accion=Eliminar&id=<%= c.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('¿Seguro?');">
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