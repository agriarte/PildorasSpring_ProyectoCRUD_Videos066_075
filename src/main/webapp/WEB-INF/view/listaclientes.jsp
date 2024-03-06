<%-- 
    Document   : index
    Created on : 28-feb-2024, 19:21:35
    
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
        <!-- Enlace al archivo CSS -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilos.css">

    </head>
    <body>
        <h1>Lista clientes</h1>

        <h2>Tabla de datos de clientes</h2>

        <table>
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach  var="clienteTemp" items="${clientes}">
                <c:url var="URLactualizarCliente" value="/cliente/formularioActualizar">
                    <c:param name="clienteId" value="${clienteTemp.id}"/>
                </c:url>
                <!-- Link para eliminar -->
                <c:url var="URLeliminar" value="/cliente/eliminar">
                    <c:param name="clienteId" value="${clienteTemp.id}"/>
                </c:url>
                <tr>
                    <td>${clienteTemp.nombre}</td>
                    <td>${clienteTemp.apellido}</td>
                    <td>${clienteTemp.email}</td>
                    <td><a href="${URLactualizarCliente}"><input type="button" value="Modificar"></a></td>
                    <td><a href="${URLeliminar}"><input type="button" value="Eliminar" 
			onclick="if(!(confirm('Vas a eliminar un registro. ¿Estás seguro?'))) return false"/></a></td>

                </tr>
            </c:forEach>
        </table>

        <!-- Mensaje adicional -->
        <p>Esto es una prueba para imprimir otros datos desde el DAO</p>   
        <p>${mensaje}</p>

        <!-- Botones CRUD -->

        <!-- Agregar Cliente -->
        <input type="button" value="Agregar Cliente" onclick="window.location.href = 'muestraFormularioAgregar; return false;'"/>
    </body>
</html>
