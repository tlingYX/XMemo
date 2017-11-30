<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="headline">
    <div class="container">
        <div class="col-sm-6">
            <!--图标-->
            <a class="navbar-brand" href="index">个人日记系统</a>
            <!--图标end-->
        </div>
        <div class="col-sm-6">
            <c:if test="${user == null}">
                <a class="navbar-brand pull-right" href="login">登录</a>
                <a class="navbar-brand pull-right" href="register">注册</a>
            </c:if>
            <c:if test="${user != null}">
                <div class="btn-group pull-right">
	                <a class="navbar-brand btn dropdown-toggle" data-toggle="dropdown" 
	                    aria-haspopup="true" aria-expanded="false">${user.name}<span class="caret"></span>
	                </a>
					<ul class="dropdown-menu">
					  <li><a href="edit">发表新日记</a></li>

					  <li role="separator" class="divider"></li>
					  <li><a href="index" onclick="event.preventDefault();
                       document.getElementById('logout-form').submit();">退出</a>
                      </li>
                      
					</ul>
					<form id="logout-form" action="logout" method="POST" style="display: none;">
                    </form>
				</div>


            </c:if>
        </div>
     </div>
</nav>