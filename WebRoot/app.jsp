<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
   
    <title>${user.name}个人日记</title> 
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<meta name="viewport"
	    content="width=device-width, initial-scale=1.0,
	        maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/ruozhi_UI.css">
    <link rel="stylesheet" type="text/css" href="css/summernote.css">
</head>
  
<body>
      <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
      <script type="text/javascript" src="js/bootstrap.min.js"></script>
      
	  <!-- header -->    
	  <jsp:include page="layouts/header.jsp"></jsp:include>
	  <!-- header end -->
      <!-- message -->    
      <jsp:include page="flashs/message.jsp"></jsp:include>
      <!-- message end -->
         
	  <!-- content -->    
	  <jsp:include page="${content}.jsp"></jsp:include>
	  <!-- content end -->
	
	  <!-- footer -->    
	  <jsp:include page="layouts/footer.jsp"></jsp:include>
	  <!-- footer end -->
</body>
</html>
