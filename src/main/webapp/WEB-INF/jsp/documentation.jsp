<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<style>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto&display=swap');
</style>
<meta charset="utf-8">
<title>Documentation</title>
<link rel="stylesheet" href="<c:url value="/resources/css/property.css"/>" type="text/css"/>
<link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>" type="text/css"/>
<style type="text/css">
.input {
	background-color: #058acc;
	border: none;
	border-radius: 9px;
	width: 200px;
	height: 40px;
	color: #809EAE;
	padding-left: 15px;
	background-color: white;
}

.docum_button {
	padding-left: 20px;
	padding-right: 20px;
	color: white;
	font-weight: 400;
	font-size: 20px;
	background-color: #058acc;
}
</style>
</head>
<body>
    <%@include file="header.jsp"%>

</body>
</html>