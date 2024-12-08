<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.evaluacion6.entidades.CursoDTO"%>
<%@ page import="com.evaluacion6.entidades.FormaDePagoDTO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Inscripción</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
    .form-ticket {
        max-width: 400px;
        margin: 20px auto;
        padding: 20px;
        border: 1px dashed #333;
        border-radius: 8px;
        background-color: #f9f9f9;
        font-family: "Courier New", Courier, monospace;
    }
    .form-ticket h2 {
        text-align: center;
    }
    .form-ticket label {
        font-weight: bold;
    }
    .form-ticket select, .form-ticket input {
        width: 100%;
        margin-bottom: 10px;
    }
    .form-ticket button {
        width: 100%;
    }
</style>
<script>
    function validarFormulario() {
        let nombre = document.getElementById('nombre').value.trim();
        let telefono = document.getElementById('telefono').value.trim();
        let cursos = document.getElementById('cursos').value;
        let formasPago = document.getElementById('formasPago').value;

        if (nombre === '') {
            alert('El campo "Nombre" es obligatorio.');
            return false;
        }
        if (!/^[a-zA-Z\s]+$/.test(nombre)) {
            alert('El campo "Nombre" solo debe contener letras.');
            return false;
        }
        if (telefono === '') {
            alert('El campo "Teléfono" es obligatorio.');
            return false;
        }
        if (!/^\d{9}$/.test(telefono)) {
            alert('El campo "Teléfono" debe contener 9 dígitos.');
            return false;
        }
        if (cursos === '') {
            alert('Debe seleccionar un curso.');
            return false;
        }
        if (formasPago === '') {
            alert('Debe seleccionar una forma de pago.');
            return false;
        }
        return true;
    }
</script>
</head>
<%
    List<CursoDTO> cursos = (List<CursoDTO>)request.getAttribute("cursos");
    List<FormaDePagoDTO> formasPago = (List<FormaDePagoDTO>)request.getAttribute("formasPago");
%>
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

    <div class="form-ticket">
        <h2>Formulario de Inscripción</h2>
        <form action="PosInscripcion" method="post" onsubmit="return validarFormulario()">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese su nombre">
            </div>
            <div class="form-group">
                <label for="telefono">Teléfono:</label>
                <input type="text" class="form-control" name="telefono" id="telefono" placeholder="Ingrese su teléfono">
            </div>
            <div class="form-group">
                <label for="cursos">Curso:</label>
                <select class="form-control" name="idCurso" id="cursos">
                    <option value="">Seleccione un curso</option>
                    <% for(CursoDTO dto: cursos) { %>
                        <option value="<%=dto.getIdCurso()%>"><%=dto.getDescripcion()%></option>
                    <% } %>
                </select>
            </div>
            <div class="form-group">
                <label for="formasPago">Forma de Pago:</label>
                <select class="form-control" name="idFormaPago" id="formasPago">
                    <option value="">Seleccione una forma de pago</option>
                    <% for(FormaDePagoDTO dto : formasPago) { %>
                        <option value="<%=dto.getIdFormaDePago()%>"><%=dto.getDescripcion()%></option>
                    <% } %>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>
</body>
</html>
