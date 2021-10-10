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
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto&display=swap');
</style>
<meta charset="utf-8">
<title>Oops_page</title>
<link rel="stylesheet" href="resources/css/property.css" type="text/css">
<link rel="stylesheet" href="resources/css/header.css" type="text/css">
</head>
<body>
	<%@include file="header.jsp"%>

	<div style="justify-content: center;">
		<div style="width: 30%; margin: 0 auto; text-align: center;">
			<img alt="image" src="resources/pictures/oops_img.png" />

			<h1 style="color: #45327d;">Что-то пошло не так...</h1>
			<br /><br /><br />
			<a class="redmessage">${param.user_message}</a>
			<a class="redmessage">${user_message}</a>
			<br/><br/><br/>
		</div>

	</div>

</body>
</html>