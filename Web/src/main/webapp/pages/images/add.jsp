<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Добавление</title>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>

<div class="row">
    <div class="col-lg-3">
        <form id="form" action="<c:url value="/images/add"/>" method="post" enctype="multipart/form-data">
            <div>
                <input type="file" name="multipartFiles" multiple="" accept="image/*" required/>
                <input type="hidden" name="albumId" value="${albumId}">
            </div>
            <div>

                <input id="submitButton" type="submit" value="<spring:message code="shared.buttons.uploadButton"/>"
                       class="btn btn-primary"/>
            </div>
        </form>
    </div>
    <div id="progressBar" class="col-lg-6">
        <span>Loading in progress...</span>

        <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="100"
                 aria-valuemin="0" aria-valuemax="100" style="width: 100%">
            </div>
        </div>
    </div>
</div>

<script>

    $("#progressBar").hide();

    $("#form").submit(function (event) {
        $("#progressBar").show();
    });
</script>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
