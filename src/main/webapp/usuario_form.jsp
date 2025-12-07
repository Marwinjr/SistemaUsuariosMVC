<%@page import="com.mycompany.proyectointermedia.modelo.Cargo"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.proyectointermedia.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario Usuario</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h3>Datos del Usuario</h3>
                    </div>
                    <div class="card-body">
                        
                        <%
                            Usuario user = (Usuario) request.getAttribute("usuario");
                            if(user == null) user = new Usuario(); 
                        %>

                        <form action="UsuarioController" method="POST">
                            <input type="hidden" name="id" value="<%= user.getId() %>">
                            
                            <div class="form-group">
                                <label>Nombre:</label>
                                <input type="text" name="nombre" value="<%= user.getNombre() != null ? user.getNombre() : "" %>" class="form-control" required>
                            </div>
                            
                            <div class="form-group">
                                <label>Apellido:</label>
                                <input type="text" name="apellido" value="<%= user.getApellido() != null ? user.getApellido() : "" %>" class="form-control" required>
                            </div>
                            
                            <div class="form-group">
                                <label>Correo:</label>
                                <input type="email" name="correo" value="<%= user.getCorreo() != null ? user.getCorreo() : "" %>" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>Contraseña:</label>
                                <input type="text" name="password" value="<%= user.getPassword() != null ? user.getPassword() : "" %>" class="form-control" required>
                            </div>
                            
                            <div class="form-group">
                                <label>Celular:</label>
                                <input type="text" name="celular" value="<%= user.getCelular() != null ? user.getCelular() : "" %>" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>Cargo:</label>
                                <select name="cboCargo" class="form-control">
                                    <%
                                        List<Cargo> cargos = (List<Cargo>) request.getAttribute("cargos");
                                        if(cargos != null) {
                                            for(Cargo c : cargos) {
                                                String selected = (c.getId() == user.getId_cargo()) ? "selected" : "";
                                    %>
                                        <option value="<%= c.getId() %>" <%= selected %>> <%= c.getNombre() %> </option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                            
                            <input type="submit" name="accion" value="<%= user.getId() != 0 ? "Actualizar" : "Guardar" %>" class="btn btn-primary btn-block">
                        </form>
                    </div>
                </div>
                <br>
                <a href="UsuarioController?accion=listar" class="btn btn-secondary">Cancelar y Volver</a>
            </div>
        </div>
    </body>
</html>