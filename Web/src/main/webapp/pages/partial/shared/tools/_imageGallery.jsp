<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/resources/js/touchTouch-min.js"></script>

<link rel="stylesheet" href="<c:url value="/resources/css/touchTouch-min.css"/>"/>

<script>
    function buildGallery() {
        $("#Gallery").find(".magnifier").touchTouch();
    }
</script>
