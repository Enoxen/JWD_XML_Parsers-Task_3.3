<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<style>
    .form{
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top:200px;
    }
    body{
        width: 100%;
        margin: 0;
        padding: 0;
    }
</style>
<head>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
    <title>Gems</title>
</head>
<body>
    <c:if test="${requestScope.gems != null}">
        <div class="form">
            <table border="1">
                <c:forEach var="item" items="${requestScope.gems}">
                    <tr>
                        <td>gem № ${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.preciousness}</td>
                        <td>${item.color}</td>
                        <td>${item.shine}</td>
                        <td>${item.transparency}</td>
                        <td>${item.value}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
        </c:if>
</body>
</html>
