<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login - Sistema Ventas</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet"/>
        <style>
            body { background-color: #f5f5f5; display: flex; align-items: center; justify-content: center; height: 100vh; }
            .card { width: 350px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        </style>
    </head>
    <body>
        <div class="card">
            <div class="card-body">
                <div class="text-center mb-4">
                    <img src="https://cdn-icons-png.flaticon.com/512/295/295128.png" width="80" alt="Logo">
                    <h3>Bienvenido</h3>
                </div>
                <form action="Validar" method="POST">
                    <div class="form-group">
                        <label>Correo Electrónico</label>
                        <input type="email" name="txtuser" class="form-control" placeholder="admin@correo.com" required>
                    </div>
                    <div class="form-group">
                        <label>Contraseña</label>
                        <input type="password" name="txtpass" class="form-control" placeholder="123" required>
                    </div>
                    <button type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block">Ingresar</button>
                </form>
            </div>
        </div>
    </body>
</html>