<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Добавление</title>

    <jsp:include page="../partial/validation/_tags.add.jsp"/>

</head>
<body>
<jsp:include page="../partial/shared/masterPages/admin/_adminMasterBody.jsp"/>
<div class="container">
    <br/>
    <sf:form id="form" action="${pageContext.request.contextPath}/tags/add" commandName="tags" method="post">

        <div class="form-group has-feedback">
            <label class="control-label" for="tagName">Имя для обращения</label>
            <input type="text" class="form-control" id="tagName" name="tagName">
            <span class="glyphicon form-control-feedback"></span>
            <sf:errors path="tagName" cssClass="control-label"/>
        </div>
        <input type="submit" value="Добавить" class="btn btn-success">
    </sf:form>
</div>


<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
