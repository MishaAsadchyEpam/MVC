<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Index</title></head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>

<div class="panel panel-warning">
    <div class="panel-heading">
        <span>Ваши чаты:</span>
    </div>
    <div class="panel-body">
        <c:forEach var="currentMessage" items="${allDialogsForUser}">
            <p><a href="<c:url value='/dialog/${currentMessage.dialogId}'/>"><spring:message
                    code="users.peoples.goToDialog"/> -
                <c:forEach var="item" items="${currentMessage.usersdialogsesByDialogId}">
                    ${item.usersByUserId.nickName} -
                </c:forEach>
            </a></p>
        </c:forEach>
    </div>
</div>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
