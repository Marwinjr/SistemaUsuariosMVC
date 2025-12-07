<%@page import="com.mycompany.proyectointermedia.modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario Cliente</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-header bg-info text-white">
                        <h3>Datos del Cliente</h3>
                    </div>
                    <div class="card-body">
                        <%
                            Cliente c = (Cliente) request.getAttribute("cliente");
                            if(c == null) c = new Cliente();
                        %>
                        <form action="ClienteController" method="POST">
                            <input type="hidden" name="id" value="<%= c.getId() %>">
                            
                            <div class="form-group">
                                <label>DNI:</label>
                                <input type="text" name="txtDni" value="<%= c.getDni()!=null?c.getDni():"" %>" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Nombres:</label>
                                <input type="text" name="txtNombres" value="<%= c.getNombres()!=null?c.getNombres():"" %>" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Dirección:</label>
                                <input type="text" name="txtDireccion" value="<%= c.getDireccion()!=null?c.getDireccion():"" %>" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Estado (1 Activo / 0 Inactivo):</label>
                                <input type="text" name="txtEstado" value="<%= c.getEstado()!=null?c.getEstado():"1" %>" class="form-control" required>
                            </div>
                            
                            <input type="submit" name="accion" value="<%= c.getId()!=0?"Actualizar":"Guardar" %>" class="btn btn-primary btn-block">
                            <a href="ClienteController?accion=listar" class="btn btn-secondary btn-block">Cancelar</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>