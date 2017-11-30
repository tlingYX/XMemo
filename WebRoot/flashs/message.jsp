<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${message != null}">
    <div class="alert alert-success">
        <ul>
            <li>
            ${message}
            </li>
        </ul>
    </div>
</c:if>