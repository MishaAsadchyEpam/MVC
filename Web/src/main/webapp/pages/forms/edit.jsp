<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <jsp:include page="../partial/validation/_forms.edit.jsp"/>
    <title>Редактирование</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/pages/forms/edit.css'/>"/>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>
<div class="row">
    <sf:form id="form" action="${pageContext.request.contextPath}/forms/edit" commandName="forms" method="post">
    <div class="col-lg-3">
        <div class="form-group has-feedback">
            <label class="control-label" for="aboutMe"><spring:message code="form.index.AboutMeLabel"/>:</label>
            <input value="${forms.aboutMe}" type="text" class="form-control" id="aboutMe" name="aboutMe">
            <span class="glyphicon form-control-feedback"></span>
            <sf:errors path="aboutMe" cssClass="control-label"/>
        </div>

        <p class="alert-danger"><spring:message code="form.edit.SelectedPicture"/></p>

        <img id="currentPhoto" src="${mediaFolder}/${forms.myPhoto}"
             alt="" class="userCurrentPhoto"/>

        <div class="btn-group">
            <a onclick="resetChanges()" class="btn btn-info"><span class="glyphicon glyphicon-minus"></span>
                <spring:message code="form.edit.ResetChanges"/></a>
            <a onclick="notPhoto()" class="btn btn-primary"><span class="glyphicon glyphicon-ban-circle"></span>
                <spring:message code="form.edit.NoPhoto"/></a>
        </div>
        <br/>
        <input type="submit" value="<spring:message code="shared.buttons.updateButton"/>" class="btn btn-warning">

    </div>
    <div class="col-lg-8">
        <input type="hidden" id="formId" name="formId" value="${forms.formId}">
        <input type="hidden" id="userId" name="userId" value="${forms.userId}">
        <input type="hidden" id="myPhoto" name="myPhoto" value="${forms.myPhoto}">


        <div class="panel panel-primary">
            <div class="panel-heading">
                <span><spring:message code="form.edit.ChooseAvatarPhoto"/></span>
            </div>
            <div class="panel-body">
                <c:if test="${empty userPictures}">
                    <span>У вас нет фотографий. <a href="<c:url value="/albums/add"/>">Создайте новый альбом</a>, чтобы добавить
                    туда фотографии.</span>
                </c:if>
                <c:forEach var="currentImage" items="${userPictures}" varStatus="iterator">

                    <img id="${iterator.index}" onclick="changeCurrentPhoto(${iterator.index})"
                         src="${mediaFolder}/${currentImage.pictureUrl}" alt=""
                         class="userPhoto"/>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<p></p>
</sf:form>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
