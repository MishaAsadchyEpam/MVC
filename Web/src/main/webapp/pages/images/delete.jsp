<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Удаление</title></head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>
<div>
    <div class="row">
        <div class="col-lg-3">
            <h4 class="alert-danger">Подтвердите удаление</h4>

            <form action="<c:url value="/images/delete"/>" method="post">
                <input type="hidden" id="imageId" name="imageId" value="${currentPicture.imageId}">
                <input type="hidden" id="forwardToAlbum" name="forwardToAlbum" value="${currentPicture.albumId}">

                <jsp:include page="../partial/models/_showImage.jsp"/>
                <input type="submit" value="Удалить" class="btn btn-danger">
            </form>
        </div>
    </div>
</div>

<jsp:include page="../partial/shared/tools/_imageModal.jsp"/>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
