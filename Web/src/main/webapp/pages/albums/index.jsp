<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Index</title>
    <jsp:include page="../partial/shared/_bootstrapStyles.jsp"/>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>
<a href="<c:url value="/albums/add"/>" class="btn btn-success">
    <span class="glyphicon glyphicon-plus"></span>
    <spring:message code="shared.buttons.addButton"/>
</a>

<table class="table table-striped">
    <thead>
    <tr>
        <th style="text-align: center"><spring:message code="albums.index.TableHeaderAlbumName"/></th>
        <th style="text-align: center"><spring:message code="shared.buttons.editButton"/></th>
        <th style="text-align: center"><spring:message code="shared.buttons.deleteButton"/></th>
        <th style="text-align: center"><spring:message code="albums.index.TableHeaderAddPictures"/></th>
        <th style="text-align: center"><spring:message code="albums.index.TableHeaderBrowsingPictures"/></th>
    </tr>
    </thead>
    <c:forEach var="album" items="${albums}">
        <tr>
            <td>${album.name}</td>
            <td align="center"><a href="<c:url value='/albums/edit/${album.albumId}'/>" class="btn btn-warning"><span
                    class="glyphicon glyphicon-pencil"></span></a></td>
            <td align="center"><a href="<c:url value='/albums/delete/${album.albumId}'/>" class="btn btn-danger"><span
                    class="glyphicon glyphicon-trash"></span></a></td>
            <td align="center"><a href="<c:url value='/images/add/${album.albumId}'/>" class="btn btn-success"><span
                    class="glyphicon glyphicon-plus"></span></a></td>
            <td align="center"><a href="<c:url value='/albums/${album.albumId}'/>" class="btn btn-info"><span
                    class="glyphicon glyphicon-film"></span></a></td>
        </tr>
    </c:forEach></table>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
