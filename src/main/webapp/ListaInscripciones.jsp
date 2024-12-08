<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Inscripciones</title>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script> 
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
    <style>
        .ticket-container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            border: 1px dashed #333;
            border-radius: 8px;
            background-color: #f9f9f9;
            font-family: "Courier New", Courier, monospace;
        }
        .ticket-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .table {
            margin-top: 10px;
        }
        .alert {
            text-align: center;
        }
    </style>
</head>
<body>
    <!-- Barra de navegación -->
    <nav class="navbar navbar-default"> 
        <div class="container-fluid"> 
            <div class="navbar-header"> 
                <a class="navbar-brand" href="PreListarInscripciones">Mantenedor de Cursos</a> 
            </div> 
            <ul class="nav navbar-nav"> 
                <li class="active"><a href="PreListarInscripciones">Listar Inscripciones</a></li> 
                <li><a href="PreInscripcion">Inscribir Cursos</a></li> 
            </ul> 
        </div> 
    </nav> 

    <div class="ticket-container">
        <h2>Lista de Inscripciones</h2>
        
        <!-- Verificar si hay inscripciones -->
        <c:if test="${not empty inscripciones}">
            
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID Inscripción</th>
                        <th>Nombre</th>
                        <th>Teléfono</th>
                        <th>Curso</th>
                        <th>Forma de Pago</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterar sobre la lista de inscripciones y mostrar sus datos -->
                    <c:forEach var="inscripcion" items="${inscripciones}">
                        <tr>
                            <td>${inscripcion.idInsc}</td>
                            <td>${inscripcion.nombre}</td>
                            <td>${inscripcion.celular}</td>
                            <td><c:out value="${cursoMap[inscripcion.idCurso]}"/></td>
                            <td><c:out value="${formaPagoMap[inscripcion.idFormaDePago]}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        <!-- Mensaje cuando no haya inscripciones -->
        <c:if test="${empty inscripciones}">
            <div class="alert alert-warning" role="alert">
                No se encontraron inscripciones.
            </div>
        </c:if>
    </div>
</body>
</html>
