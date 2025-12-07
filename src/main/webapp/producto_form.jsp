<%@page import="com.mycompany.proyectointermedia.modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario Producto</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-header bg-warning">
                        <h3>Datos del Producto</h3>
                    </div>
                    <div class="card-body">
                        <%
                            Producto p = (Producto) request.getAttribute("producto");
                            if(p == null) p = new Producto();
                        %>
                        <form action="ProductoController" method="POST">
                            <input type="hidden" name="id" value="<%= p.getId() %>">
                            
                            <div class="form-group">
                                <label>Nombres:</label>
                                <input type="text" name="txtNombres" value="<%= p.getNom()!=null?p.getNom():"" %>" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Precio:</label>
                                <input type="number" step="0.01" name="txtPrecio" value="<%= p.getPrecio() %>" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Stock:</label>
                                <input type="number" name="txtStock" value="<%= p.getStock() %>" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Estado (1 Activo / 0 Inactivo):</label>
                                <input type="text" name="txtEstado" value="<%= p.getEstado()!=null?p.getEstado():"1" %>" class="form-control" required>
                            </div>
                            
                            <input type="submit" name="accion" value="<%= p.getId()!=0?"Actualizar":"Guardar" %>" class="btn btn-primary btn-block">
                            <a href="ProductoController?accion=listar" class="btn btn-secondary btn-block">Cancelar</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>