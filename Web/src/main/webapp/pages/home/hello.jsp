<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <jsp:include page="../partial/shared/_flexslider.jsp"/>
</head>

<body>
<jsp:include page="../partial/shared/masterPages/guest/_guestMasterBody.jsp"/>
<h3>Топ 5 лучших фотографий</h3>

<div class="flexslider">
    <ul class="slides">

        <c:forEach var="image" items="${topImages}" varStatus="index">
            <li>
                <img src="${mediaFolder}/${image.pictureUrl}" style="height: 393px; width: 770px;">
            </li>
        </c:forEach>
    </ul>
</div>
<span id="responsiveFlag"></span>

<h3>Вы не выполнили вход</h3>

<ul class="nav nav-pills nav-stacked">
    <li class="active"><a href="<c:url value="/account/login"/>"><spring:message code="home.login"/></a></li>
    <li><a href="<c:url value="/account/register"/>"><spring:message code="home.register"/></a></li>
</ul>

<img src="<c:url value="/resources/images/pagesImages/question.jpg"/>" alt="" style="width: 400px;"/>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
