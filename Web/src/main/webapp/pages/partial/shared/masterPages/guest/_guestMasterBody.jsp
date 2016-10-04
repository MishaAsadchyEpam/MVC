<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    body {
        background: url(<c:url value="/resources/images/pagesImages/background.jpg"/>);
        background-size: 100%
    }
</style>

<div class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="https://mentoring.lab.epam.com:44300/">Mentoring portal</a>
        </div>
        <div class="navbar-collapse collapse">

<jsp:include page="../shared/_userGuestNavbar.jsp"/>

<ul class="nav navbar-nav navbar-right">
    <li><a href="<c:url value="/account/register"/>"><spring:message code="home.register"/></a></li>
    <li><a href="<c:url value="/account/login"/>"><spring:message code="home.login"/></a></li>
</ul>
</div>
</div>
</div>

<div class="container-fluid">

