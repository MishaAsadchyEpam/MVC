<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Редактирование</title>
    <jsp:include page="../partial/validation/_images.edit.jsp"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/shared/images.css'/>"/>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>
<div>
    <sf:form id="form" action="${pageContext.request.contextPath}/images/edit" commandName="images" method="post">
        <input type="hidden" id="imageId" name="imageId" value="${images.imageId}">
        <input type="hidden" id="albumId" name="albumId" value="${images.albumId}">
        <input type="hidden" id="pictureUrl" name="pictureUrl" value="${images.pictureUrl}">

        <div class="row">
            <div class="col-lg-3">
                <jsp:include page="../partial/models/_image.jsp"/>
                <p></p>
                <input type="submit" value="обновить" class="btn btn-success">
            </div>
            <div class="col-lg-7">
                <div class="form-group has-feedback">
                    <label class="label-primary">Название картинки:</label>
                    <input type="text" class="form-control" id="pictureName" name="pictureName"
                           placeholder="Введите pictureName" value="${images.pictureName}">
                    <span class="glyphicon form-control-feedback"></span>
                    <sf:errors path="pictureName" cssClass="error"/>
                </div>
                <div class="form-group has-feedback">
                    <label class="label-primary">Описание картинки:</label>
                    <textarea style="height: 130px; resize: none;" class="form-control" id="pictureDescribe"
                              name="pictureDescribe"
                              placeholder="Введите pictureDescribe">${images.pictureDescribe}</textarea>
                    <span class="glyphicon form-control-feedback"></span>
                    <sf:errors path="pictureDescribe" cssClass="error"/>
                </div>
            </div>

        </div>
        <p></p>

    </sf:form>
</div>


<jsp:include page="/pages/partial/shared/tools/_imageModal.jsp"/>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
