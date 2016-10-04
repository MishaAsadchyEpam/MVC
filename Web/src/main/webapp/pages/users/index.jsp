<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Index</title>
    <jsp:include page="../partial/shared/_bootstrapStyles.jsp"/>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/admin/_adminMasterBody.jsp"/>
<h3>Пользователи</h3>
<table class="table table-striped">
    <thead>
    <tr>
        <td>Имя пользователя</td>
        <td>Удаление пользователя</td>
    </tr>
    </thead>
    <c:forEach var="currentMessage" items="${userss}">
        <tr>
            <td>${currentMessage.username}</td>
            <td><a href="<c:url value='/users/delete/${currentMessage.userId}'/>">Удалить</a></td>
        </tr>
    </c:forEach></table>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
