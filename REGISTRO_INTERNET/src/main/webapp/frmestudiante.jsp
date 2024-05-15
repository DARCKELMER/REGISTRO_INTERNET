<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-5 row justify-content-center" >
            <h1 class="text-center">
                <c:if test="${estudiante.id == 0}">Nueva</c:if>
                <c:if test="${estudiante.id != 0}">Editar</c:if>
                Inscripcion
            </h1>
            <form class=" " action="MainServlet" style="width: 18rem;background: lightblue; border-radius: 20px" method="post">
                <input type="hidden" name="id" value="${estudiante.id}">
                <div class="mb-3">
                    <label for="fecha" class="form-label">Nombres</label>
                    <input type="text" name="nombres" class="form-control" id="fecha" value="${estudiante.nombres}">
                </div>
                <div class="mb-3">
                    <label for="titulo" class="form-label">Apellidos</label>
                    <input type="text" name="apellidos" class="form-control" id="titulo" value="${estudiante.apellidos}">
                </div>
                <div class="mb-3">
                    <label for="titulo" class="form-label">Seminario</label>
                    <input type="text" name="seminario" class="form-control" id="titulo" value="${estudiante.seminario}">
                </div>
                <div class="mb-3">
                    <label for="titulo" class="form-label">Confirmado</label>
                    <c:if test="${estudiante.confirmado == 0}"><input name="confirmado"  type="checkbox"></c:if>
                    <c:if test="${estudiante.confirmado != 0}"><input name="confirmado" type="checkbox" checked=""></c:if>
                </div>
                <div class="mb-3">
                    <label for="titulo" class="form-label">Fecha de inscripcion</label>
                    <input type="date" name="fecha" class="form-control" id="titulo" value="${estudiante.fecha}">
                </div>
                <div class="mb-3">
                    <input type="submit" class="btn btn-primary">
                </div>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
