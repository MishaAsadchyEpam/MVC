<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Удаление</title></head>
<body>
<jsp:include page="../partial/shared/masterPages/admin/_adminMasterBody.jsp"/>
<div class="panel panel-warning">

    <div class="panel-heading">
        <span>Подтвердите удаление пользователя</span>
    </div>

    <div class="panel-body">

        <form action="<c:url value="/users/delete"/>" method="post">
            <input type="hidden" id="userId" name="userId" value="${users.userId}">

            <p>
                <span class="alert-danger">Имя пользователя: ${users.nickName}</span>
            </p>

            <p>
                <span class="alert-danger">Логин: ${users.username}</span>
            </p>

            <input type="submit" value="Удалить" class="btn btn-danger">
        </form>
    </div>
</div>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
