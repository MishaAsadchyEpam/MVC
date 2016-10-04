<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Удаление</title>
    <jsp:include page="../partial/shared/_bootstrapStyles.jsp"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/shared/images.css"/>"/>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>

<div class="panel panel-warning">

    <div class="panel-heading">
        <span>Подтвердите удаление альбома</span>
    </div>
    <div class="panel-body">
        <form action="<c:url value="/albums/delete"/>" method="post">
            <input type="hidden" id="albumId" name="albumId" value="${albums.albumId}">

            <label>Название альбома: </label>
            <span>${albums.name}</span>

            <div class="panel panel-info">
                <div class="panel-heading">
                    <span>Фотки в альбоме (${fn:length(albums.imagesesByAlbumId)})</span>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <c:if test="${empty albums.imagesesByAlbumId}">
                            <span>В альбоме нету фоток</span>
                        </c:if>

                        <c:forEach var="currentMessage" items="${albums.imagesesByAlbumId}">

                            <div class="col-lg-4" style="text-align: center">
                                <img src="${mediaFolder}/${currentMessage.pictureUrl}" alt=""
                                     class="img-thumbnail imageNormal"/>
                            </div>

                        </c:forEach>
                    </div>
                </div>
            </div>

            <input type="submit" value="Удалить" class="btn btn-danger">
        </form>
    </div>
</div>

<jsp:include page="/pages/partial/shared/tools/_imageModal.jsp"/>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
