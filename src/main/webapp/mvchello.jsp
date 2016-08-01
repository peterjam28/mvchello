<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <title>Spring MVC</title>
</head>
<body>
<h1>index - ${title}</h1>
<p>
    <c:if test="${not empty msg}">
        Hello ${msg}
    </c:if>

    <c:if test="${empty msg}">
        Welcome Welcome!
    </c:if>
</p>
</body>
</html>