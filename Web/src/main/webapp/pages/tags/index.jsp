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

<a href="<c:url value="/tags/add"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> Добавить тэг</a>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Имя тэга</th>
        <th>Редактировать</th>
        <th>Удалить</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="currentMessage" items="${tagss}">
        <tr>
            <td>${currentMessage.tagName}</td>
            <td><a href="<c:url value='/tags/edit/${currentMessage.tagId}'/>">Редактировать</a></td>
            <td><a href="<c:url value='/tags/delete/${currentMessage.tagId}'/>">Удалить</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
