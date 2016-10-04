<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Index</title></head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>

<c:forEach var="friendForm" items="${myFriendsForms}">

    <div class="row">
        <div class="col-lg-2">
            <img src="${mediaFolder}/${friendForm.myPhoto}" alt="" style="height: 150px; max-width: 200px;"/>
        </div>
        <div class="col-lg-3">
            <p class="alert-info">Имя: ${friendForm.usersByUserId.nickName}</p>
        </div>
        <div class="col-lg-3">
            <p><a href="<c:url value='/dialog/add/${friendForm.userId}'/>" class="btn btn-success btn-block">
                <span class="glyphicon glyphicon-comment"></span>
                <spring:message code="friends.index.writeMessage"/></a></p>

            <p><a href="<c:url value='/users/${friendForm.userId}'/>" class="btn btn-primary btn-block">
                <span class="glyphicon glyphicon-list-alt"></span> <spring:message code="friends.index.toUserPage"/></a>
            </p>

            <p><a href="<c:url value='/friends/delete/${friendForm.userId}'/>" class="btn btn-danger btn-block"><span
                    class="glyphicon glyphicon-remove">

            </span> <spring:message code="friends.index.deleteFrind"/></a></p>
        </div>
    </div>
    <p></p>
</c:forEach>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
