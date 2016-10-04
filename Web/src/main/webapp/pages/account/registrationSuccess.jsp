<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
</head>
<html>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>
<h3>Success</h3>

<p>
    <img src="<c:url value="/resources/images/pagesImages/notification.jpg"/>" alt=""/>
</p>
<span>На указанный вами адрес отправлено письмо с сылкой для активации аккаунта</span>
<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>



