<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="by.mycloud_zapchast.www.entity.User"%>
<%@ page import="by.mycloud_zapchast.www.entity.Depo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto&display=swap');
</style>
<meta charset="utf-8">
<title>REGISTRATION_1_PAGE</title>
<link rel="stylesheet" href="resources/css/registration.css" type="text/css">
<link rel="stylesheet" href="resources/css/header.css" type="text/css">
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="registrationDiv">
		<div>
			<img src="resources/pictures/circle_logo.png" style="margin: 20px; margin-bottom: 10px; height: 90px; width: 90px;" />
		</div>
		<h1 class="bluetxtcolor" style="margin-bottom: 0px;" :>Регистрация</h1>
		<h4 class="bluetxtcolor" style="margin-top: 0px;">шаг 1 из 2</h4>
		<div style="display: flex; flex-direction: column;">
			<font style="text-size: 5;">Уже есть аккаунт?</font>
			<a href="Controller?commandToController=GO_TO_AUTHORIZATION_PAGE">Страница авторизации</a>
			<br>
		</div>
		
		<form action="Controller" method="post" style="color: white, margin-bottom:50px;">
			<input type="hidden" name="commandToController" value="GO_TO_REGISTRATION_2_PAGE" />
			<select name="depo"
				style="margin: 5px; border-color: #35B9FF; border-width: 1px; border-style: solid; border-radius: 9px; width: 212px; height: 45px; color: #809EAE; padding-left: 4px;">

				<option name="depo" value=""><a>Выберите Ваше предприятие</a></option>
				<c:if test="${deposDb != null}">
					<c:forEach var="depo" items="${deposDb}">
						<option value="${depo.getIdDepo()}">${depo.getName()}</option>
					</c:forEach>
				</c:if>
			</select>
			
			<input type="text" name="name" value="" required pattern="^[А-Яа-яЁё//-]{3,20}$" title="Текст кириллицей, возможно тире (3-20 символов)"
				placeholder="Имя" />
			<input type="text" name="second_name" value="" required pattern="^[А-Яа-яЁё//-]{3,20}$" title="Текст кириллицей, возможно тире (3-20 символов)"
				placeholder="Фамилия" />

			<input type="submit" value="Дальше" class="bluebutton" style="width: 220px; height: 40px;" />
		<br><br><br>
		<a class="redmessage" >${param.user_message}</a>
		<br><br><br>
		</form>
		
		
		
	</div>
</body>
</html>