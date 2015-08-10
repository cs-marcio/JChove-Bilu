<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="lista" class="br.com.chovebilu.scanner.TrackerSabesp" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/main.css" media="screen">
<meta name="ImagePath" id="path" content="/img" />
<title>Chove, Bilu!</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="icon" type="image/png" href="img/favicon.png">
<link rel="stylesheet" href="css/main.css" media="screen">
</head>
<body>

	<header class="navbar navbar-default navbar-fixed-top" id="myHeader">
		<img src="img/avatar_bilus-08.png">
	</header>
	<section class="sec sec2">
		<img src="img/reservatorio.png"
			style="text-align: center; height: 50vh" id="img">
		<form style="text-align: center;" id="target" action="main.jsp" method="post" accept-charset="UTF-8">
			<select class="form-control" name="reservatorio">
				<c:forEach var="list" items="${lista.getReservatorios()}">
					<option value="${list.getName()}">Reservatório:
						${list.getName()}</option>
				</c:forEach>
			</select>
			<p>
				<button type="submit" class="btn btn-default" id="btn_submit">Enviar</button>
			</p>
		</form>
	</section>
</body>

<footer id="MyFooter" style="height: auto;">
	<img src="img/rodape-01.png" style="width =: 200px; height: 36px">
	<img src="img/rodape-02.png"
		style="float: right; width: 200px; height =50px; margin-bottom: 12px;">
</footer>
<script src="js/jquery.js"></script>
<script src="js/main.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</html>