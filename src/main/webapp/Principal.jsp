<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jardín Secreto - Panel Principal</title>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

        <style>
            /* Contenedor principal para centrar verticalmente si se desea */
            .dashboard-container {
                padding-top: 50px;
                padding-bottom: 50px;
            }

            /* Diseño de las tarjetas */
            .card-menu {
                border: none;
                border-radius: 15px; /* Bordes redondeados */
                transition: all 0.3s ease; /* Suaviza la animación */
                cursor: pointer;
                color: white; /* Texto blanco por defecto */
                height: 100%; /* Para que todas midan lo mismo */
                text-decoration: none !important; /* Quita el subrayado del link */
                display: block; /* Hace que todo el cuadro sea clicleable */
            }

            /* Colores específicos para cada botón */
            .bg-venta { background: linear-gradient(45deg, #ff357a, #fff172); } /* Degradado rojizo */
            .bg-prod  { background: linear-gradient(45deg, #11998e, #38ef7d); } /* Degradado verde */
            .bg-clien { background: linear-gradient(45deg, #2193b0, #6dd5ed); } /* Degradado azul */
            .bg-user  { background: linear-gradient(45deg, #373b44, #4286f4); } /* Degradado oscuro */

            /* Animación al pasar el mouse (Hover) */
            .card-menu:hover {
                transform: translateY(-10px) scale(1.02); /* Sube y crece un poquito */
                box-shadow: 0 15px 30px rgba(0,0,0,0.3); /* Sombra elegante */
                color: white;
            }

            /* Estilo del icono */
            .card-menu i {
                font-size: 3rem; /* Tamaño del icono */
                margin-bottom: 15px;
                opacity: 0.9;
            }

            .card-body {
                padding: 2rem;
                text-align: center;
            }
        </style>
    </head>
    
    <body>
        <jsp:include page="menu.jsp" />
        
        <div style="height: 70px;"></div> 

        <div class="container dashboard-container">
            
            <div class="text-center mb-5">
                <h2 class="fw-bold text-dark">Panel de Control</h2>
                <p class="text-secondary">Seleccione una operación rápida</p>
            </div>

            <div class="row g-4">
                
                <div class="col-md-6 col-lg-3">
                    <a href="Controlador?menu=NuevaVenta&accion=default" class="card-menu bg-venta shadow">
                        <div class="card-body">
                            <i class="fas fa-shopping-cart"></i>
                            <h4>Nueva Venta</h4>
                            <small>Registrar facturación</small>
                        </div>
                    </a>
                </div>

                <div class="col-md-6 col-lg-3">
                    <a href="ProductoController?accion=listar" class="card-menu bg-prod shadow">
                        <div class="card-body">
                            <i class="fas fa-box-open"></i>
                            <h4>Productos</h4>
                            <small>Inventario y precios</small>
                        </div>
                    </a>
                </div>

                <div class="col-md-6 col-lg-3">
                    <a href="ClienteController?accion=listar" class="card-menu bg-clien shadow">
                        <div class="card-body">
                            <i class="fas fa-users"></i>
                            <h4>Clientes</h4>
                            <small>Cartera de clientes</small>
                        </div>
                    </a>
                </div>

                <div class="col-md-6 col-lg-3">
                    <a href="UsuarioController?accion=listar" class="card-menu bg-user shadow"> 
                        <div class="card-body">
                            <i class="fas fa-user-cog"></i>
                            <h4>Usuarios</h4>
                            <small>Gestión de accesos</small>
                        </div>
                    </a>
                </div>

            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>