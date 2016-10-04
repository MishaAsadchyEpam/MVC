<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="row">
    <ul class="portfolio clearfix">
        <div class="col-lg-12 center">
            <c:if test="${pagesCount > 1}">
                <div class="btn-group">
                    <c:choose>
                        <c:when test="${pageNumber + 1 < pagesCount}">
                            <a class="btn btn-default"
                               onclick="requestPage(${pageNumber + 1}, ${tagId})"><spring:message
                                    code="shared.buttons.nextButton"/></a>
                        </c:when>
                        <c:otherwise>
                            <a class="btn btn-default disabled"><spring:message code="shared.buttons.nextButton"/></a>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${pageNumber - 1 >= 0}">
                            <a class="btn btn-default"
                               onclick="requestPage(${pageNumber - 1}, ${tagId})"><spring:message
                                    code="shared.buttons.prevButton"/></a>
                        </c:when>
                        <c:otherwise>
                            <a class="btn btn-default disabled"><spring:message code="shared.buttons.prevButton"/></a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:if>
        </div>

        <c:forEach var="currentImage" items="${galleryPage}">
            <li>
                <div class="imageContainer">
                    <div class="thumbnail thumbnailContainer">
                        <a class="magnifier" href="${mediaFolder}/${currentImage.pictureUrl}">
                            <img class="galleryImage" src="${mediaFolder}/${currentImage.pictureUrl}">
                        </a>
                    </div>

                    <div class="imageInfoContainer">
                        <span class="alert-danger">Name: ${currentImage.pictureName}</span>
                        <br/>

                        <p class="alert-success">Describe: ${currentImage.pictureDescribe}</p>
                    </div>

                    <div class="likeContainer">
                        <a class="btn btn-success btn-xs" onclick="like(${currentImage.imageId})">
                            <span class="glyphicon glyphicon-thumbs-up"></span>
                            <spring:message code="gallery.likeButton"/></a>
                        <span class="badge badgeNormal"
                              id="${currentImage.imageId}">${currentImage.votesNumber}</span>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
