<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="by.mycloud_zapchast.www.entity.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto&display=swap')
	;
</style>
<meta charset="utf-8">
<title>Поиск по годовым заявкам</title>
<link rel="stylesheet" href="resources/css/property.css" type="text/css">
<link rel="stylesheet" href="resources/css/header.css" type="text/css">

<style type="text/css">
input {
	background-color: #058acc;
	border: none;
	border-radius: 9px;
	width: 200px;
	height: 40px;
	color: #809EAE;
	padding-left: 15px;
	background-color: white;
}

.gz_button {
	padding-left: 20px;
	padding-right: 20px;
	color: white;
	font-weight: 400;
	font-size: 20px;
	background-color: #058acc;
}
</style>


<script defer src="resources/js/mask.js"></script>
<script defer src="resources/js/main.js"></script>

</head>

<body>
<%@include file="header.jsp"%>
	<!-- Input Fields -->
	<div class="lineconteiner" style="background-color: none; justify-content: center;">
		<form action="Controller" method="post">
			<input type="hidden" name="commandToController" value="APPLICATION_SEARCH" />
			<div class="columnconteiner2string" style="float: left;">
				<input type="hidden" name="commandToController" value="" />
				<a style="color: white; margin-left: 5px;">Наименование запчасти</a>
				<input type="text" name="itemName" value="" placeholder="Введите наименование" />
			</div>
			<div class="columnconteiner2string" style="float: left;">
				<a style="color: white; margin-left: 5px;">Номенклатурный №</a>
				<input type="text" data-mask="nn_mask" name="nn" value="" placeholder="Введите номер" />
			</div>
			<div class="columnconteiner2string" style="float: left;">
				<a style="color: white; margin-left: 5px;">№ SAP</a>
				<input type="text" name="nnSap" value="" placeholder="Введите №SAP" />
			</div>
			<div class="columnconteiner2string" style="float: left;">
				<a style="color: white; margin-left: 5px;">Год</a>
				<select name="year" style="border: none; border-radius: 9px; width: 200px; height: 40px; color: #809EAE; padding-left: 15px;">

					<option value=""selected ;"><a>Не выбрано</a></option>
					<c:if test="${yearsDb != null}">
						<c:forEach var="year" items="${yearsDb}">
							<option>${year}</option>
						</c:forEach>
					</c:if>
				</select>
			</div>

			<div class="columnconteiner2string" style="float: left;">
				<button style="color: #FFB74E; align-item: center; border-radius: 20px; height: 40px; margin-top: 18px;">
					<a>Найти</a>
					<img style="margin-left: 20px; height: 15px; width: 15px;" src="resources/pictures/search_icon.png" />
				</button>
			</div>
		</form>
	</div>

	<div class="search_big_conteiner">
		<div class="lineconteiner" style="background-color: none; justify-content: center;">
			<div class="columnconteiner" style="float: left;">
				<a>Наименование</a>
			</div>
			<div class="columnconteiner" style="float: left;">
				<a>Номенклатурный №</a>
			</div>
			<div class="columnconteiner" style="float: left;">
				<a>№ Sap</a>
			</div>
			<div class="columnconteiner" style="float: left;">
				<a>Заявлено/После урезания</a>
			</div>
		</div>


	</div>

</body>

</html>