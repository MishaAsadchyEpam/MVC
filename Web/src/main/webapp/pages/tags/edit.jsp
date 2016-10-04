<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Редактирование</title>
    <jsp:include page="../partial/validation/_tags.edit.jsp"/>
</head>

<body>
<jsp:include page="../partial/shared/masterPages/admin/_adminMasterBody.jsp"/>
<div>
    <sf:form id="form" action="${pageContext.request.contextPath}/tags/edit" name="tags" method="post">
        <input type="hidden" id="tagId" name="tagId" value="${tags.tagId}">

        <div class="form-group has-feedback">
            <label class="control-label" for="tagName">Имя тэга</label>
            <input type="text" class="form-control" id="tagName" name="tagName" placeholder="Введите tagName"
                   value="${tags.tagName}" required maxlength="50">
            <span class="glyphicon form-control-feedback"></span>
            <sf:errors path="tagName" cssClass="error"/>
        </div>

        <input type="submit" value="обновить" class="btn btn-warning">
    </sf:form>
</div>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>


</body>
</html>
