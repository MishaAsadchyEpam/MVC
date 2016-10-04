<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Отметить тэгами фотографию</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/pages/pictureTags/add.css'/>"/>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>
<div class="row">
    <div class="col-lg-4">
        <h3>Отметьте фотографию тэгами</h3>
        <img src="${mediaFolder}/${pictureUrl}" alt="" class="imageNormal"/>
    </div>
    <div class="col-lg-6">

        <sf:form action="${pageContext.request.contextPath}/picturetags/add" method="post"
                 modelAttribute="editTagsModels">

        <input type="hidden" name="imageId" value="${editTagsModels.imageId}">

        <c:forEach var="tagMarkModels" items="${editTagsModels.tagMarkModels}" varStatus="status">

            <div class="col-lg-3">
                <sf:checkbox cssStyle="height: 18px; width: 18px; margin: 0;"
                             path="tagMarkModels[${status.index}].isChecked" name="isChecked"/>
                <label class="label-primary">${tagMarkModels.tagName}</label>
            </div>

            <sf:hidden path="tagMarkModels[${status.index}].tagName" name="tagName" value="${tagMarkModels.tagName}"/>
        </c:forEach>
    </div>
</div>
<p></p>
<input type="submit" value="submit" class="btn btn-warning">
</sf:form>


<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
