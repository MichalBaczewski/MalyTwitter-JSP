<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Mały twitter</title>
</head>
<body>

<c:if test="${!requestScope.containsKey('posts')}">
    <jsp:forward page="/posts"></jsp:forward>
</c:if>

<header>
    <h1>Mały Twitter</h1>
</header>
<c:choose>
    <c:when test="${ !sessionScope.containsKey('user') }">
        <form action="/login" method="post">
            <input type="text" placeholder="Login" name="login">
            <input type="password" placeholder="Password" name="password">
            <input type="submit" value="Sign in!">
        </form>
    </c:when>
    <c:otherwise>
        <a href="/logout">Wyloguj się</a>
    </c:otherwise>
</c:choose>
<c:if test="${ requestScope.containsKey('message') }">
    <h3>${ requestScope.message.value }</h3>
</c:if>
<c:forEach items="${posts}" var="post">
    <c:url value="/deletePost" var="deletePostUrl">
        <c:param name="id" value="${post.id}"></c:param>
    </c:url>
    <div>
        <hr/>
        <h4>Autor: ${post.publisher.name}</h4>
        <ul>
            <li>Data: <b>${post.postDateTime}</b></li>
            <li>Wiadomość: <b>${post.message}</b></li>
        </ul>
        <c:choose>
            <c:when test="${ sessionScope.containsKey('user') && sessionScope.get('user') == post.publisher }">
                <a href="${deletePostUrl}">Usuń post</a>
            </c:when>
        </c:choose>
    </div>
</c:forEach>
</body>
</html>


<%--<c:choose>--%>
    <%--<c:when test="${ sessionScope.containsKey('user')  == post.}">--%>
        <%--<a href="${deletePostUrl}">Usuń post</a>--%>
    <%--</c:when>--%>
<%--</c:choose>--%>