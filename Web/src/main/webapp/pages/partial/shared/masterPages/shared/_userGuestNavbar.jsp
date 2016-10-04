<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav navbar-nav">
    <li class="dropdown">
        <a href="<c:url value='#'/>" class="dropdown-toggle" data-toggle="dropdown"><spring:message
                code="navbar.profile"/><span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
            <li><a href="<c:url value="/forms/"/>"><spring:message code="navbar.myForm"/></a></li>
        </ul>
    </li>
    <li><a href="<c:url value="/user/"/>"><spring:message code="navbar.myPage"/></a></li>
    <li><a href="<c:url value="/albums/"/>"><spring:message code="navbar.myAlbums"/></a></li>
    <li><a href="<c:url value="/friends/"/>"><spring:message code="navbar.myFriends"/></a></li>
    <li><a href="<c:url value="/dialog/"/>"><spring:message code="navbar.myMessages"/></a></li>
    <li><a href="<c:url value="/users/peoples/"/>"><spring:message code="navbar.Peoples"/></a></li>
    <li><a href="<c:url value="/gallery/"/>"><spring:message code="navbar.Gallery"/></a></li>
    <li class="dropdown">
        <a href="<c:url value='#'/>" class="dropdown-toggle" data-toggle="dropdown"><spring:message
                code="navbar.Languages"/><span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
            <li><a href="<c:url value='?lang=ru'/>"><spring:message code="navbar.LanguagesRussian"/></a>
            </li>
            <li><a href="<c:url value='?lang=en'/>"><spring:message code="navbar.LanguagesEnglish"/></a>
            </li>
            <li class="divider"></li>
            <li class="dropdown-header"><spring:message code="navbar.LanguagesNotSupportedLabel"/></li>
            <li><a href="<c:url value='?lang=fr'/>"><spring:message code="navbar.LanguagesFrench"/></a></li>
        </ul>
    </li>
</ul>
