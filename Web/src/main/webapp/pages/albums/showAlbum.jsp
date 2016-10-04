<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Index</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/shared/images.css'/>"/>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>

<h3>Album name: ${album.name}</h3>

<div class="row">
    <c:forEach var="currentPicture" items="${album.imagesesByAlbumId}">
        <div class="col-lg-3">

            <%@include file="/pages/partial/models/_showImage.jsp" %>

            <div class="btn-group">
                <a href="<c:url value='/images/edit/${currentPicture.imageId}'/>" class="btn btn-warning"><span
                        class="glyphicon glyphicon-pencil"></span></a>
                <a href="<c:url value='/images/delete/${currentPicture.imageId}'/>" class="btn btn-danger"><span
                        class="glyphicon glyphicon-trash"></span></a>
                <a href="<c:url value='/picturetags/add/${currentPicture.imageId}'/>" class="btn btn-primary"><span
                        class="glyphicon glyphicon-tags"></span></a>
            </div>
        </div>
    </c:forEach>
</div>
<p></p>
<a href="<c:url value='/images/add/${album.albumId}'/>" class="btn btn-success"><span
        class="glyphicon glyphicon-plus"></span>
    Добавить фотографии в альбом</a>

<jsp:include page="/pages/partial/shared/tools/_imageModal.jsp"/>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
