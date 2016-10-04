<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Index</title></head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>
<div class="row">
    <h4 class="alert-danger col-lg-3">Name: ${user.nickName}</h4>
</div>

<img src="${mediaFolder}/${user.formsesByUserId.myPhoto}" alt="" style="height: 200px;"/>


<p></p>
<c:forEach var="currentAlbum" items="${user.albumsesByUserId}">

    <div class="panel panel-warning">
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
