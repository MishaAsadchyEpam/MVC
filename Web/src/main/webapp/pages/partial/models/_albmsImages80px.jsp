<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${empty currentAlbum.imagesesByAlbumId}">
    <div style="text-align: center;">
        <span>Пустой альбом</span>
    </div>
</c:if>
<div class="row">
    <c:forEach var="picture" items="${currentAlbum.imagesesByAlbumId}">
        <div class="col-lg-1">
            <img src="${mediaFolder}/${picture.pictureUrl}" alt="" style="height: 80px;"
                 class="img-thumbnail"/>
        </div>
    </c:forEach>
</div>
