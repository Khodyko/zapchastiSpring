<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<div class="headline">
	<div class="hamburger-menu">
		<input id="menu__toggle" type="checkbox" />
		<label class="menu__btn" for="menu__toggle"> <span></span>
		</label>

		<ul class="menu__box">
			<c:if test="${user_session== null}">
				<li><a class="menu__item" href="Controller?commandToController=GO_TO_AUTHORIZATION_PAGE">Авторизация</a></li>

				<li><a class="menu__item" href="Controller?commandToController=GO_TO_REGISTRATION_1_PAGE">Регистрация</a></li>
			</c:if>
			<c:if test="${user_session!= null}">
				<li><a class="menu__item" href="Controller?commandToController=SIGN_OUT">Выйти</a></li>
			</c:if>
		</ul>
	</div>

	<a href="Controller?commandToController=GO_TO_STANDART_PRE_SEARCH" style="text-decoration: none; margin-left: 100px;">
		<div class="lineconteiner">
			<div style="float: left;">
				<img src="<c:url value="/resources/pictures/logo.png"/>" style="margin: 20px; height: 50px; width: 50px;" />
			</div>
			<div style="float: left;">
				<h1 class="bluetxtcolor">Запчасти</h1>
			</div>
		</div>
	</a>

	<div class="lineconteiner">

		<form:form	action="${pageContext.request.contextPath}/item/goToStandartPreSearch"
				method="GET"> 
			<button class="zapchast_button">Запчасти</button>
		</form:form>
		<form:form	action="${pageContext.request.contextPath}/item/goToDocumentationPage"
				method="GET"> 
			<button class="docum_button">Документация</button>
		</form:form>
		<c:if test="${user_session!= null}">

			<form action="Controller" method="post">
				<input type="hidden" name="commandToController" value="GO_TO_APPLICATION_PRE_SEARCH" />
				<button class="gz_button">ГЗ</button>
			</form>
		</c:if>



	</div>
</div>