<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>

</head>
<html>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>
<span>Access is denied</span>

<img src="${pageContext.request.contextPath}/resources/images/pagesImages/accessDenied.png" alt=""/>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
