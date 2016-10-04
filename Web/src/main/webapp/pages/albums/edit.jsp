<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Добавление</title>
    <jsp:include page="../partial/validation/_albums.edit.jsp"/>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>

<br/>

<div class="container">
    <sf:form id="form" action="${pageContext.request.contextPath}/albums/edit" commandName="albums" method="post">

        <input type="hidden" id="albumId" name="albumId" value="${albums.albumId}">
        <input type="hidden" id="userId" name="userId" placeholder="Введите userId" value="${albums.userId}">

        <div class="form-group has-feedback">
            <label class="control-label" for="name">Название альбома</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Название альбома"
                   value="${albums.name}">
            <span class="glyphicon form-control-feedback"></span>
            <sf:errors path="name" cssClass="control-label"/>
        </div>
        <input type="submit" value="Обновить" class="btn btn-success">
    </sf:form>
</div>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
