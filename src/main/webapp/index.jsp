<%@page import="com.example.MyPojo"%>
<html>
<body>
    <h1>Tomcat Running</h1>
    <%=new MyPojo().getMessage()%>
    <form action="myservice">
        <input type="submit" value="Test Service"/>
    </form>
</body>
</html>