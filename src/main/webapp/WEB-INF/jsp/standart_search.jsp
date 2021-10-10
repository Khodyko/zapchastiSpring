<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="by.mycloud_zapchast.www.entity.User"%>
<%@ page import="by.mycloud_zapchast.www.entity.StandartSearchItem"%>
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
<title>Zapchasti</title>
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

.zapchast_button {
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
			<input type="hidden" name="commandToController" value="STANDART_SEARCH" />
			<div class="columnconteiner2string" style="float: left;">
				<input type="hidden" name="commandToController" value="" />
				<a style="color: white;">Наименование запчасти</a>
				<input type="text" name="itemName" value="" placeholder="Введите наименование" />
			</div>
			<div class="columnconteiner2string" style="float: left;">
				<a style="color: white;">Номенклатурный №</a>
				<input type="text" data-mask="nn_mask" name="nn" value="" placeholder="Введите номер" />

			</div>
			<div class="columnconteiner2string" style="float: left;">
				<a style="color: white;">№ SAP</a>
				<input type="text"  name="nnSap" value="" placeholder="Введите №SAP" />
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

		</div>
		<c:if test="${item_bd_list != null && item_bd_list.size()!=0}">
			<c:forEach var="item" items="${item_bd_list}">
				<div class="shadowlineconteiner" style="background-color: none; justify-content: center;">
					<div class="columnconteiner" style="float: left;">
						<a>${item.getName()}</a>
					</div>
					<div class="columnconteiner" style="float: left;">
						<a>${item.getNn()}</a>
					</div>
					<div class="columnconteiner" style="float: left;">
						<a>${item.getNnSap()}</a>
					</div>

				</div>
			</c:forEach>
		</c:if>
		<c:if test="${item_bd_list == null || item_bd_list.size()==0}">
			<div class="shadowlineconteiner" style="background-color: none; justify-content: center;">
				<div class="columnconteiner" style="float: left;">
					<a>Ничего не найдено</a>
				</div>
			</div>
		</c:if>
	</div>

	<div class="pagination" style="width: 50%; margin: 0 auto; text-align: center;">
		<c:if test="${pagesMaxNum>1}">
			<c:if test="${currentPage>1}">
				<a class="pagination_link"
					href="Controller?commandToController=STANDART_SEARCH&currentPage=${currentPage-1}&itemName=${item_search.getName()}&nn=${item_search.getNn()}&nnSap=${item_search.getNnSap()}">&laquo;</a>
			</c:if>
			<c:forEach begin="${currentPage-10<1?1:currentPage-10}" end="${currentPage+10>pagesMaxNum?pagesMaxNum:currentPage+10}" varStatus="loop">

				<c:if test="${loop.index != currentPage}">
					<a class="pagination_link"
						href="Controller?commandToController=STANDART_SEARCH&currentPage=${loop.index}&itemName=${item_search.getName()}&nn=${item_search.getNn()}&nnSap=${item_search.getNnSap()}">${loop.index}</a>
				</c:if>
				<c:if test="${loop.index == currentPage}">
					<a class="active" href="#">${loop.index}</a>
				</c:if>


			</c:forEach>
			<c:if test="${(pagesMaxNum)>currentPage}">
				<a class="pagination_link"
					href="Controller?commandToController=STANDART_SEARCH&currentPage=${currentPage+1}&itemName=${item_search.getName()}&nn=${item_search.getNn()}&nnSap=${item_search.getNnSap()}">&raquo;</a>
			</c:if>
		</c:if>
	</div>


</body>

</html>