<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<link rel="stylesheet" href="<c:url value='/resources/css/shared/images.css'/>"/>--%>
<p class="center">
    <img src="${mediaFolder}/${currentPicture.pictureUrl}" alt=""
         class="img-thumbnail imageNormal"/>
</p>

<p class="alert-danger">Название: ${currentPicture.pictureName}</p>

<p class="alert-info">Описание: ${currentPicture.pictureDescribe}</p>


