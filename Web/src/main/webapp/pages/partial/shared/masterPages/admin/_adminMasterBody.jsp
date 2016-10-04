<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/admin/"/>">Home Page</a></li>
                <li><a href="<c:url value="/users/"/>">Управление пользователями</a></li>
                <li><a href="<c:url value="/tags/"/>">Просмотр тегов</a></li>
                <li><a href="<c:url value="/user/"/>">Войти, как пользователь</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/logout"/>">Выйти</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container-fluid">
