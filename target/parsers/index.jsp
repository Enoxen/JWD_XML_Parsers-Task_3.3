<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body>
    <div class="form">
        <form action="FrontController" method="get">
            <h1>Чо пацаны, парсинг?</h1>
            <input type="hidden" name="command" value="main">
            <input type="submit" name="toMainPage" value="КОНЕЧНО">
        </form>
    </div>
</body>
</html>
