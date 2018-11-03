<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="pl">
    <head>
        <meta charset="UTF-8">
        <title>404 - Not Found</title>
    </head>
    <body>
        <h1>404 - Not Found</h1>
        <c:if test="${ requestScope.containsKey('message') }">
            <h3>${ requestScope.message.value }</h3>
        </c:if>

        <a href="/">Wróć do strony głównej</a>
    </body>
</html>