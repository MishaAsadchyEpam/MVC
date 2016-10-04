<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Index</title></head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>
<div class="alert-warning col-lg-3">
    <span>У вас нету активных чатов. </span>
    <a href="<c:url value="/users/peoples/"/>"><spring:message code="dialog.index.findFriends"/></a>
</div>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
