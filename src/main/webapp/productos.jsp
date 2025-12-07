<%@page import="java.util.List"%>
<%@page import="com.mycompany.proyectointermedia.modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos - Jardín Secreto</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div style="height: 90px;"></div>

        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="card shadow-sm">
                        <div class="card-header bg-success text-white">
                            <h5 class="mb-0"><i class="fas fa-box"></i> Datos del Producto</h5>
                        </div>
                        <div class="card-body">
                            <form action="Controlador?menu=Producto" method="POST">
                                <div class="mb-3">
                                    <label>Nombre:</label>
                                    <input type="text" name="txtNombres" value="${producto.getNom()}" class="form-control" required>
                                </div>
                                <div class="mb-3">
                                    <label>Precio:</label>
                                    <input type="number" step="0.01" name="txtPrecio" value="${producto.getPrecio()}" class="form-control" required>
                                </div>
                                <div class="mb-3">
                                    <label>Stock:</label>
                                    <input type="number" name="txtStock" value="${producto.getStock()}" class="form-control" required>
                                </div>
                                <div class="mb-3">
                                    <label>Estado:</label>
                                    <input type="text" name="txtEstado" value="${producto.getEstado()}" class="form-control" placeholder="1 para activo">
                                </div>
                                
                                <input type="hidden" name="id" value="${producto.getId()}">

                                <div class="d-grid gap-2">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-primary">Agregar</button>
                                    <button type="submit" name="accion" value="Actualizar" class="btn btn-warning text-white">Actualizar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-md-8">
                    <table class="table table-hover table-bordered">
                        <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>NOMBRES</th> <th>PRECIO</th>
                                <th>STOCK</th>
                                <th>ESTADO</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Producto> lista = (List<Producto>) request.getAttribute("productos");
                                if (lista != null) {
                                    for (Producto p : lista) {
                            %>
                            <tr>
                                <td><%= p.getId() %></td>
                                <td><%= p.getNom() %></td> 
                                <td>$<%= p.getPrecio() %></td>
                                <td><%= p.getStock() %></td>
                                <td><%= p.getEstado() %></td>
                                <td>
                                    <a href="Controlador?menu=Producto&accion=Editar&id=<%= p.getId() %>" class="btn btn-warning btn-sm">
                                        <i class="fas fa-edit"></i>
                                    </a>
                                    <a href="Controlador?menu=Producto&accion=Eliminar&id=<%= p.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('¿Eliminar?');">
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>