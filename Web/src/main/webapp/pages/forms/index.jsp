<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Index</title></head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>
<p>
    <span class="alert-danger"><spring:message code="form.index.AboutMeLabel"/> ${userForm.aboutMe}</span>
</p>

<p>
    <img src="${mediaFolder}/${userForm.myPhoto}" alt="" style="height: 200px;"/>
</p>

<div class="col-lg-3">

    <a href="<c:url value='/forms/edit/${userForm.formId}'/>" class="btn btn-warning btn-block"><span
            class="glyphicon glyphicon-file"></span> <spring:message code="form.index.editMyFormLabel"/></a>
</div>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
