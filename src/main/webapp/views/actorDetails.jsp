<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actor</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Actor</h1>
		
		<form class="form" method="post" action="${pageContext.request.contextPath}/actorDetails">
			<input type="hidden" id="id" name="id" value="${actor.getId()}">
			<div class="row">
				<div class="col">
					<label for="firstName" class="form-label">Nombre:</label><input
						type="text" class="form-control" id="firstName" name="firstName"
						value="${actor.getFirstName()}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="lastName" class="form-label">Apellido</label><input
						type="text" class="form-control" id="lastName" name="lastName"
						value="${actor.getLastName()}">
				</div>
			</div>
			<div class="row">
				<div class="col pt-4">
					<button type="submit" class="btn btn-primary"><i class="fa-solid fa-floppy-disk"></i> Guardar</button>
				</div>
			</div>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
		crossorigin="anonymous"></script>

	<script src="https://kit.fontawesome.com/81a2ed02b0.js"
		crossorigin="anonymous"></script>
</body>
</html>