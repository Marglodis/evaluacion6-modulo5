<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmación</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
<style>
    .ticket {
        max-width: 400px;
        margin: 20px auto;
        padding: 15px;
        border: 1px dashed #333;
        border-radius: 8px;
        background-color: #f9f9f9;
        font-family: "Courier New", Courier, monospace;
    }
    .ticket h1, .ticket h3 {
        text-align: center;
    }
    .ticket p {
        margin: 5px 0;
    }
    .ticket hr {
        border-top: 1px dashed #333;
    }
    .ticket-footer {
        text-align: center;
        font-size: 12px;
        margin-top: 10px;
    }
</style>
</head>
<body>
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

<div class="ticket">
    <h1>Confirmación de Inscripción</h1>
    <hr>
    <p><strong>Código de Inscripción:</strong> ${idInsc}</p>
    <hr>
    <p><strong>Nombre:</strong> ${nombre}</p>
    <p><strong>Teléfono:</strong> ${telefono}</p>
    <p><strong>ID Curso:</strong> ${idCurso}</p>
    <p><strong>ID Forma de Pago:</strong> ${idFormaDePago}</p>
    <hr>
    <div class="ticket-footer">
        <p>¡Gracias por inscribirse!</p>
        <p>www.mantenedordecursos.com</p>
    </div>
</div>
</body>
</html>
