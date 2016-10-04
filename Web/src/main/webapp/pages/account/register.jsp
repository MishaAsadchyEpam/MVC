<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Регистрация</title>
    <jsp:include page="../partial/validation/_account.register.jsp"/>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/guest/_guestMasterBody.jsp"/>
<div class="container">

    <div class="row">

        <div class="span5">

            <h2><spring:message code="account.register.registrationPageLabel"/></h2>

            <br>

            <sf:form id="form" action="${pageContext.request.contextPath}/account/register" commandName="users"
                     method="post">
                <div class="form-group has-feedback">
                    <label class="control-label" for="username"><spring:message
                            code="account.login.usernameLabel"/></label>
                    <input type="email" class="form-control" id="username" name="username">
                    <span class="glyphicon form-control-feedback"></span>
                    <sf:errors path="username" cssClass="control-label"/>
                </div>

                <div class="form-group has-feedback">
                    <label class="control-label" for="password"><spring:message
                            code="account.login.passwordLabel"/></label>
                    <input type="password" class="form-control" id="password" name="password">
                    <span class="glyphicon form-control-feedback"></span>
                    <sf:errors path="password" cssClass="control-label"/>
                </div>

                <div class="form-group has-feedback">
                    <label class="control-label" for="passwordConfirm"><spring:message
                            code="account.register.confirmPasswordLabel"/></label>
                    <input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm">
                    <span class="glyphicon form-control-feedback"></span>
                    <sf:errors path="passwordConfirm" cssClass="control-label"/>
                </div>

                <div class="form-group has-feedback">
                    <label class="control-label" for="nickName"><spring:message
                            code="account.register.nickNameLabel"/></label>
                    <input type="text" class="form-control" id="nickName" name="nickName">
                    <span class="glyphicon form-control-feedback"></span>
                    <sf:errors path="nickName" cssClass="control-label"/>
                </div>

                <br>

                <input type="submit" value="<spring:message code="home.register"/>" class="btn btn-success"/>

            </sf:form>
        </div>
    </div>
</div>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>