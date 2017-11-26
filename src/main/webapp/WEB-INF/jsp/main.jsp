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
        <input type="submit" name="command" value="SAX">
        <br>
        <br>
        <br>
        <br>
        <input type="submit" name="command" value="STAX">
        <br>
        <br>
        <br>
        <br>
        <input type="submit" name="command" value="DOM">
    </form>
</div>
</body>
</html>
