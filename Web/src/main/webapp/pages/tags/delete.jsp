<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Удаление</title></head>
<body>
<jsp:include page="../partial/shared/masterPages/admin/_adminMasterBody.jsp"/>

<div class="panel panel-warning">

    <div class="panel-heading">
        <span>Подтвердите удаление тэга</span>
    </div>
    <div class="panel-body">
        <form action="<c:url value="/tags/delete"/>" method="post">
            <input type="hidden" id="tagId" name="tagId" value="${tags.tagId}">

            <p>
                <span class="alert-danger">Имя тэга: ${tags.tagName}</span>
            </p>
            <input type="submit" value="Удалить" class="btn btn-danger">
        </form>
    </div>
</div>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
