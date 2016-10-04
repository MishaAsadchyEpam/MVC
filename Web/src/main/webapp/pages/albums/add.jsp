<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Добавление</title>
    <jsp:include page="../partial/validation/_albums.add.jsp"/>

</head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>

<br/>

<div class="container">
    <sf:form id="form" action="${pageContext.request.contextPath}/albums/add" commandName="albums" method="post">
        <div class="form-group has-feedback">
            <label class="control-label" for="name"><spring:message code="albums.index.TableHeaderAlbumName"/></label>
            <input type="text" class="form-control" id="name" name="name"
                   placeholder="<spring:message code="albums.index.TableHeaderAlbumName"/>">
            <span class="glyphicon form-control-feedback"></span>
            <sf:errors path="name" cssClass="control-label"/>
        </div>
        <input type="submit" value="<spring:message code="shared.buttons.addButton"/>" class="btn btn-success">
    </sf:form>
</div>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
