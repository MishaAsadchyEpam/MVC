<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shared/images.css"/>
</head>
<html>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>
<p>
    <img class="imageNormal" src="${pageContext.request.contextPath}/resources/images/pagesImages/smile.gif" alt=""/>
</p>

<span>Confirmation Success</span>

<a href="<c:url value="/account/login"/>">Войти на сайт</a>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>




