<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Actores</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link
	href="//cdn.datatables.net/2.0.8/css/dataTables.dataTables.min.css"
	rel="stylesheet">
	
	
	
</head>
<body>
	<div class="container">
		<h1>Listado de Actores</h1>

		<table class="table" id="tblActor">
			<thead class="table-dark">
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${actores}">
					<tr>
						<th><c:out value="${a.getId()}"></c:out></th>
						<td><c:out value="${a.getFirstName()}"></c:out></td>
						<td><c:out value="${a.getLastName()}"></c:out></td>
						<td>
							<a href="${pageContext.request.contextPath}/actorDetails?id=${a.getId()}" class="btn btn-secondary"><i class="fa-solid fa-pen-to-square"></i></a>
							<a href="#" class="btn btn-danger"><i class="fa-solid fa-trash-can"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
		crossorigin="anonymous"></script>

	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>
		
	<script src="https://cdn.datatables.net/2.0.8/js/dataTables.min.js"></script>
	
	<script>
		$(document).ready(()=>{
			$('#tblActor').DataTable();
		})
	</script>
	
	<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>
	
</body>
</html>