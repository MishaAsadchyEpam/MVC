<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Log In</title>
    <jsp:include page="../partial/validation/_account.login.jsp"/>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/guest/_guestMasterBody.jsp"/>
<div class="container jumbotron">
    <h2>
        <spring:message code="account.login.authentication"/></h2>
    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
        <font color="red">
            No valid data: <br/>
            <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
        </font>
    </c:if>
    <form id="form" class="login-form" action="<c:url value='/j_spring_security_check'/>" method="post">
        <div class="form-group has-feedback">
            <label class="control-label" for="j_username"><spring:message code="account.login.usernameLabel"/></label>
            <input type="email" class="form-control" id="j_username" name="j_username">
            <span class="glyphicon form-control-feedback"></span>
            <sf:errors path="j_username" cssClass="control-label"/>
        </div>

        <div class="form-group has-feedback">
            <label class="control-label" for="j_password"><spring:message code="account.login.passwordLabel"/></label>
            <input type="password" class="form-control" id="j_password" name="j_password">
            <span class="glyphicon form-control-feedback"></span>
            <sf:errors path="j_password" cssClass="control-label"/>
        </div>
        <input type="submit" value="<spring:message code="home.login"/>" class="btn btn-success"/>
    </form>
</div>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>

</body>
</html>


