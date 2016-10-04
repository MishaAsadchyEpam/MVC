<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Домашняя страничка</title>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>

<h3>Hello, ${currentUser.nickName}</h3>

<img src="${mediaFolder}/${currentUser.formsesByUserId.myPhoto}" alt="" style="height: 200px;"/>

<c:if test="${empty currentUser.albumsesByUserId}">
    <span>У вас нет ни одного альбома. Может <a href="<c:url value="/albums/add"/>">создать альбом</a>?</span>
</c:if>

<p></p>
<c:forEach var="currentAlbum" items="${currentUser.albumsesByUserId}">

    <div class="panel panel-warning">
        <div class="panel-heading pull-right">
            <a href="<c:url value='/images/add/${currentAlbum.albumId}'/>">Добавить фотографии в альбом</a>
        </div>
        <div class="panel-heading">
            <span>Альбом: ${currentAlbum.name} (${fn:length(currentAlbum.imagesesByAlbumId)} фото)</span>
        </div>
        <div class="panel-body">
            <%@include file="../partial/models/_albmsImages80px.jsp" %>
        </div>
    </div>
</c:forEach>

<jsp:include page="/pages/partial/shared/tools/_imageModal.jsp"/>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
