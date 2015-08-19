<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="r" class="br.com.chovebilu.control.ReservatorioMain" />

<%
	request.setCharacterEncoding("UTF-8");
	r.setReservatorio(request.getParameter("reservatorio"));
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/main.css" media="screen">
<meta name="ImagePath" id="path" content="{{path}}" />
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
	<section class="sec sec1">
			<c:choose>
				<c:when test="${r.getReservatorio().getPlu_dia().equals('0.0')}">
					<img src="img/tempo-01.png">
					<p>Não está Chovendo</p>
				</c:when>
				<c:otherwise>
					<img src="img/tempo-02.png">
					<p>Tá Chovendo</p>
				</c:otherwise>
			</c:choose>
	</section>
	<section class="sec2">
			<img src="${r.getImgNivelReservatorio() }">
			<p>Nivel do reservatório</p>
			<p class="description">${r.getNivelReservatorio()}</p>
	</section>

	<section class="sec3">
			<img src="${r.getImgNivelChuva() }">
			<p>Nivel de Chuva</p>
			<p class="description">${r.getNivelChuva() * 10}%</p>
	</section>

	<footer id="MyFooter" style="height: auto;">
		<img src="img/rodape-01.png" style="width =: 200px; height: 36px">
		<img src="img/rodape-02.png"
			style="float: right; width: 200px; height =50px; margin-bottom: 12px;">
	</footer>
</body>
<script src="js/jquery.js"></script>
<script src="js/main.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</html>
