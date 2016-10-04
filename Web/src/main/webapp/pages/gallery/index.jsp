<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <script src="<c:url value="/resources/js/jquery-min.js"/>"></script>
    <title>Index</title>
    <jsp:include page="../partial/shared/_bootstrapStyles.jsp"/>
    <jsp:include page="../partial/shared/tools/_imageGallery.jsp"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/pages/gallery.css'/>"/>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>

<div class="row">
    <div class="container-fluid">
        <div class="col-lg-2">
        </div>

        <div class="col-lg-8">

            <div id="tagCloud">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <span><spring:message code="gallery.tagCloud"/></span>
                    </div>
                    <div class="panel-body">
                        <a class="label label-default" onclick="requestPage(0, 0)">Показать все</a>
                        <c:forEach var="currentMessage" items="${tagCloud}">
                            <a class="label label-default"
                               onclick="requestPage(0, ${currentMessage.tagId})">${currentMessage.tagName}</a>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>

<div id="Gallery">

</div>

<script>

    function requestPage(pageNumber, tagId) {
        $("#Gallery").load("${pageContext.request.contextPath}/gallery/getPage?pageNumber=" + pageNumber + "&tagId=" + tagId, function () {
            buildGallery();
        });
    }

    function like(pictureId) {
        $.get("${pageContext.request.contextPath}/votes/like/" + pictureId,
                function (data) {
                    $("#" + pictureId).html(data);
                }
        );
    }

    requestPage(0, 0);
</script>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>

</body>
</html>
