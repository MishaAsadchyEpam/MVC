<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:include page="../partial/shared/masterPages/user/_userMasterHeader.jsp"/>
    <title>Index</title>
    <jsp:include page="../partial/validation/_dialog.sendMessage.jsp"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/pages/dialog/showDialog.css'/>"/>
</head>
<body>
<jsp:include page="../partial/shared/masterPages/user/_userMasterBody.jsp"/>

<div class="panel panel-warning">

    <div class="panel-heading">
        <span>Участники чата</span>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-lg-3">
                <ul>
                    <c:forEach var="member" items="${dialog.usersdialogsesByDialogId}">
                        <li><span>${member.usersByUserId.nickName}</span></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-lg-9">
                <c:forEach var="member" items="${dialog.usersdialogsesByDialogId}">
                    <a href="<c:url value='/users/${member.usersByUserId.userId}'/>">
                        <img title="${member.usersByUserId.nickName}"
                             src="${mediaFolder}/${member.usersByUserId.formsesByUserId.myPhoto}" alt=""
                             class="dialogMemberImage"/>
                    </a>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<div class="panel panel-primary">
    <div class="panel-heading">
        <span>История сообщений</span>
    </div>
    <div class="panel-body">
        <div id="messageHistory">
            <c:if test="${empty dialog.messagesByDialogId}">
                <span id="emptyDialogMessage">Тут будет выводиться история сообщений</span>
            </c:if>
            <c:forEach var="message" items="${dialog.messagesByDialogId}">
                <%@include file="../partial/models/_showMessage.jsp" %>
            </c:forEach>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-lg-4">

        <sf:form action="javascript:void(null);" onsubmit="postAjaxRequest()" name="message" method="post"
                 id="form">

            <div class="form-group has-feedback">
                <label class="control-label" for="text">Введите свое сообщение</label>
                <textarea id="text" class="form-control noResize" name="text" placeholder="Введите Ваше сообщение.."
                          required></textarea>
                <span class="glyphicon form-control-feedback"></span>
                <sf:errors path="text" cssClass="control-label"/>
            </div>

            <p></p>

            <input type="hidden" id="dialogId" name="dialogId" value="${dialog.dialogId}">

            <input type="submit" value="<spring:message code="shared.buttons.sendButton"/>" class="btn btn-primary">
        </sf:form>
    </div>
    <div class="col-lg-3">
        <p><a id="addMemberLink" onclick="ajaxAddMemberRequest()"
              class="btn btn-primary btn-block">
            <span class="glyphicon glyphicon-user"></span>
            <spring:message code="dialog.indexId.addToCompany"/></a></p>

        <p><a href="<c:url value='/dialog/delete/${dialog.dialogId}'/>" class="btn btn-warning btn-block"><span
                class="glyphicon glyphicon-ban-circle"></span> <spring:message code="dialog.indexId.leaveChat"/></a></p>

    </div>
</div>

<script>

    var isCleared = !$("#emptyDialogMessage").length;


    function clearEmptyDialogMessage() {
        if (!isCleared) {
            $("#emptyDialogMessage").remove();
            isCleared = true;
        }
    }

    function postAjaxRequest() {
        var message = $("#form").serialize();

        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/message/add",
            data: message,
            success: function (data) {
                clearEmptyDialogMessage();
                $("#messageHistory").append(data);
                $('#form').trigger('reset');
            }
        });
    }

    function ajaxAddMemberRequest() {
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/dialog/addMember/${dialog.dialogId}",
            success: function (data) {
                $("#addMemberLink").after(data);
            },
            error: function () {
                alert('Возникла ошибка');
            }
        });
    }

</script>

<jsp:include page="../partial/shared/masterPages/user/_userMasterFooter.jsp"/>
</body>
</html>
