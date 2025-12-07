<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.proyectointermedia.modelo.Usuario"%>

<%
    String nombreUsuario = "Usuario";
    
    // Lógica para obtener el nombre (soporta "user" y "usuario")
    if (session.getAttribute("user") != null) {
        Usuario usu = (Usuario) session.getAttribute("user");
        nombreUsuario = usu.getNombre();
    } else if (session.getAttribute("usuario") != null) {
        Usuario usu = (Usuario) session.getAttribute("usuario");
        nombreUsuario = usu.getNombre();
    }
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <div class="container-fluid">
    
    <a class="navbar-brand fw-bold" href="Principal.jsp">
      <i class="fas fa-glass-martini-alt text-warning"></i> Jardín Secreto
    </a>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarContent">
      <ul class="navbar-nav ms-auto align-items-center">
        
        <li class="nav-item me-3">
            <span class="text-white">
                <i class="fas fa-user-circle"></i> Hola, <b><%= nombreUsuario %></b>
            </span>
        </li>

        <li class="nav-item">
            <a class="nav-link text-white" href="Principal.jsp">
                <i class="fas fa-home"></i> Inicio
            </a>
        </li>

        <li class="nav-item ms-2">
            <a class="btn btn-sm btn-danger" href="index.jsp">
                <i class="fas fa-sign-out-alt"></i> Salir
            </a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>