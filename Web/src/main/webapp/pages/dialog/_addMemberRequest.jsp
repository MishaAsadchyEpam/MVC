<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p></p>

<div id="addPanel" class="panel panel-success">
    <div class="panel-heading">
        <span>Выберите друга, чтобы добавить в чат</span>
    </div>
    <div class="panel-body">
        <c:if test="${empty usersList}">
            <span>У вас нету друзей, которых можно пригласить в этот чат.</span>
        </c:if>
        <ul>
            <c:forEach var="currentMessage" items="${usersList}">
                <li>
                    <a href="<c:url value="/dialog/addMember?dialogId=${dialogId}&userId=${currentMessage.userId}"/>">${currentMessage.nickName}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<script>
    var addLink = $("#addMemberLink");

    addLink.removeAttr("onclick");
    addLink.click(function () {
        $("#addPanel").slideToggle();
    });

    $("#addPanel").click(function () {
        $("#addPanel").slideUp();
    });
</script>
