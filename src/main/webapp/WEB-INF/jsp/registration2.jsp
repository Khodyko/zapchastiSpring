<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="by.mycloud.www.entity.Depo"%>
<!DOCTYPE html>
<html>
<head>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto&display=swap');
</style>
<meta charset="utf-8">
<title>REGISTRATION_2_PAGE</title>
<link rel="stylesheet" href="<c:url value="/resources/css/registration.css"/>" type="text/css"/>
<link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>" type="text/css"/>
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="registrationDiv">
		<div>
			<img src="resources/pictures/circle_logo.png" style="margin: 20px; margin-bottom: 10px; height: 90px; width: 90px;" />
		</div>
		<h1 class="bluetxtcolor" style="margin-bottom: 0px;" :>Регистрация</h1>
		<h4 class="bluetxtcolor" style="margin-top: 0px;">шаг 2 из 2</h4>
		<div style="display: flex; flex-direction: column;">
			<font style="text-size: 5;">Уже есть аккаунт?</font>
			<a href="Controller?commandToController=GO_TO_AUTHORIZATION_PAGE">Страница авторизации</a>
			<br>
		</div>
		<form:form action="${pageContext.request.contextPath}/user/register" method="POST" style="color: white;">
			<select name="sectorIdUI"
				style="margin: 5px; border-color: #35B9FF; border-width: 1px; border-style: solid; border-radius: 9px; width: 212px; height: 45px; color: #809EAE; padding-left: 4px;">

				<option  value=""><a>Выберите Ваш участок</a></option>
				<c:if test="${sectorUI != null}">
					<c:forEach var="sector" items="${sectorUI}">
						<option value="${sector.getId()}">${sector.getName()}</option>
					</c:forEach>
				</c:if>
			</select>
			<input type="hidden" name="depoIdUI" value=${depoIdUI }  />
			<input type="hidden" name="nameUI" value=${nameUI }  />
			<input type="hidden" name="secondNameUI" value=${secondNameUI }  />
			<input type="text" name="emailUI" value=""  placeholder="Email" />
			<input type="password" name="passwordUI" value=""  placeholder="Пароль" />
			<input type="password" name="password2UI" value=""  placeholder="Повторите пароль" />


			<input type="submit" value="Отправить" class="bluebutton" style="width: 220px; height: 40px;" />
			<br />
			<br>
			<br>
			<br>
			<a class="redmessage">${param.user_message}</a>
			<br>
			<br>
			<br>
		</form:form>


	</div>

</body>
</html>