<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${article}" var="article">
    <div class="container" id="${article.id}">
        <div class="row">
            <div class="span4">
                <div class="thumbnail">
                    <div class="caption">
                        <p>${article.text}</p>
                        <a class="btn pull-right">${article.issued}</a>
                    </div>
                    <button class="btn btn-danger" onclick="RecycleArticle(this)"
                        data-toggle="modal" data-target="#isRecycle"
                        data-id="${article.id}">删除</button>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
