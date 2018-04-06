<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="http://code.jquery.com/jquery-1.10.2.js"
        type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
<e:url value="/j_spring_security_check" var="loginUrl" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <c:forEach var="user" items="${users}" >
        <div >
            <div  style="text-align: center">id - ${user.getId()}</div>
            <div  style="text-align: center">name - ${user.getName()}</div>
            <div  style="text-align: center">surname - ${user.getSurname()}</div>

        </div>
        <br>
    </c:forEach>
</div>
</body>
</html>
