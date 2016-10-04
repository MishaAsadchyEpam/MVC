<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Index</title></head>
<link rel="stylesheet" href="<c:url value='/resources/css/pages/users/peoples.css'/>"/>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>

<c:forEach var="currentMessage" items="${allUsers}">
    <div class="row">
        <div class="col-lg-2">
            <img src="${mediaFolder}/${currentMessage.formsesByUserId.myPhoto}" alt=""
                 class="peoplesImage"/>
        </div>
        <div class="col-lg-3">
            <p class="alert-info">Имя: ${currentMessage.nickName}</p>

            <p><a href="<c:url value='/friends/add/${currentMessage.userId}'/>" class="btn btn-success btn-block"><span
                    class="glyphicon glyphicon-user"></span> <spring:message code="users.peoples.addFriend"/></a></p>

            <p><a href="<c:url value='/dialog/add/${currentMessage.userId}'/>" class="btn btn-primary btn-block"><span
                    class="glyphicon glyphicon-comment">

            </span><spring:message code="users.peoples.goToDialog"/></a></p>
        </div>
    </div>
    <br/>
</c:forEach>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
