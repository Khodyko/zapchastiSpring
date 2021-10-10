<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto&display=swap');
</style>
<meta charset="utf-8">
<title>AUTHORIZATION_PAGE</title>
<link rel="stylesheet" href="<c:url value="/resources/css/registration.css"/>" type="text/css"/>
<link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>" type="text/css"/>
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="registrationDiv">
		<div>
			<img src="<c:url value="/resources/pictures/circle_logo.png"/>" style="margin: 20px; margin-bottom: 10px; height: 90px; width: 90px;" />
		</div>
		<h1 class="bluetxtcolor">Войти на сайт</h1>
		<div style="display: flex; flex-direction: column;">
			<font style="text-size: 5;">Еще нет аккаунта?</font>
			<a href="Controller?commandToController=GO_TO_REGISTRATION_1_PAGE">Страница регистрации</a>
			<br>
		</div>
		<form action="Controller" method="post" style="color: white">
			<input type="hidden" name="commandToController" value="AUTHORIZATION" />

			<input type="text" name="email" required pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$" title="text@text.2or3symbols" value=""
				placeholder="Email" />
			<input type="password" name="password" required pattern="^(?=^.{6,20}$)(?=.*[0-9])(?=.*[A-Za-zА-Яа-я!@#$%^&*?]).*$"
				title="Пароль должен содержать минимум 6 символов, из них хотя бы одну цифру" value="" placeholder="Пароль" />


			<input type="submit" value="Войти" class="bluebutton" style="width: 220px; height: 40px;" />
		</form>
		<br />
		<br />
		<br />
		<br />
		<br />
		<a class="redmessage">${param.user_message}</a>
		
	</div>
</body>
</html>