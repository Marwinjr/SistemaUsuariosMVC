<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nueva Venta</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        
<div style="height: 90px;"></div> 
        <div class="container mt-4">
            <div class="row">
                <div class="col-sm-8"> <div class="card">
                        <div class="card-body">
                            <form action="Controlador?menu=NuevaVenta" method="POST">
                                <div class="form-group">
                                    <label>Datos del Cliente</label>
                                    <div class="d-flex">
                                        <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="DNI Cliente" required>
                                        <button type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info ml-2">Buscar</button>
                                    </div>
                                    <input type="text" name="nombrescliente" value="${c.getNombres()}" class="form-control mt-1" readonly placeholder="Nombre Cliente">
                                </div>
                            </form>

                            <form action="Controlador?menu=NuevaVenta" method="POST">
                                <div class="form-group">
                                    <label>Datos del Producto</label>
                                    <div class="d-flex">
                                        <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Código Producto" required>
                                        <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info ml-2">Buscar</button>
                                    </div>
                                    <input type="text" name="nomproducto" value="${producto.getNom()}" class="form-control mt-1" readonly placeholder="Producto">
                                    
                                    <div class="d-flex mt-2">
                                        <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control mr-1" placeholder="Precio" readonly>
                                        <input type="number" name="cant" value="1" class="form-control mr-1" placeholder="Cant">
                                        <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="Stock" readonly>
                                    </div>
                                </div>
                                <button type="submit" name="accion" value="Agregar" class="btn btn-primary btn-block">Agregar Producto al Carrito</button>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4"> <div class="card">
                        <div class="card-body">
                            <div class="d-flex justify-content-between">
                                <label>Nro. Serie:</label>
                                <input type="text" name="NroSerie" value="00000${nserie}" class="form-control text-center font-weight-bold" style="width: 100px" readonly>
                            </div>
                            <br>
                            <table class="table table-sm table-hover">
                                <thead>
                                    <tr>
                                        <th>Producto</th>
                                        <th>Cant</th>
                                        <th>SubTotal</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="list" items="${lista}">
                                        <tr>
                                            <td>${list.getDescripcionP()}</td>
                                            <td>${list.getCantidad()}</td>
                                            <td>${list.getSubtotal()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="card-footer text-center">
                            <h3>Total: S/. ${totalpagar}</h3>
                            <div class="mt-3">
                                <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" class="btn btn-success btn-block" onclick="return confirm('¿Generar Venta?');">Generar Venta</a>
                                <a href="Controlador?menu=NuevaVenta&accion=Cancelar" class="btn btn-danger btn-block">Cancelar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>