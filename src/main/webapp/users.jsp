<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html lang="pl">
    <head>
        <meta charset="UTF-8">
        <title>Hello</title>
    </head>
    <body>
        <h1>Strona JSP</h1>

        <c:forEach items="${users}" var="user">
            <div>
                <h2>Dane użytkownika ${user.name}</h2>
                <ul>
                    <li>Login: <b>${user.login}</b></li>
                    <li>Imię: <b>${user.name}</b></li>
                    <c:if test="${user.showEmail}">
                        <li>E-mail: <b>${user.email}</b></li>
                    </c:if>
                    <li>Płeć: <b>${user.gender.label}</b></li>
                    <li>Data urodzenia: <b>${user.birthDate}</b></li>
                    <li>Uprawnienia: <b>${user.role.label}</b></li>
                </ul>
            </div>
        </c:forEach>

    </body>
</html>