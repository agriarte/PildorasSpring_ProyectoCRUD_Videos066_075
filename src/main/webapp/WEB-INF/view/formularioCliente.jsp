<%-- 
    Document   : muestraFormulario
    Created on : 04-mar-2024, 18:30:21

--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Agregar Cliente</title>
        <!-- Enlace al archivo CSS -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilos.css">
    </head>
    <body>
        <h1>Formulario Agregar Cliente</h1>
        <!-- action="insertarCliente" es la URL del Mapping del controlador, cliente es el conjunto de datos que se envía al controlador -->
        <!-- al pulsar Insertar se envía por POST el formulario al controlador y este lo envía al Data Access Object -->
        <form:form action="insertarCliente" modelAttribute="cliente" method="POST">
            <form:hidden path="id" /> <!-- necesario para mandar el id al controlador en las modificaciones -->
            <table>
                <tr>
                    <td>Nombre: </td>
                    <td><form:input path="nombre" /></td>
                </tr>
                <tr>
                    <td>Apellido: </td>
                    <td><form:input path="apellido" /></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                <p>Valor del botón: ${boton}</p>
                <td colspan="2"><input type="submit" value="${boton}"></td>

            </tr>
        </table>
    </form:form>
</body>
</html>
