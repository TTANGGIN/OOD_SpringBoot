<%-- 
    Document   : show_sum2
    Created on : 2023. 3. 23., 오후 7:17:01
    Author     : CHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Spring Bean을 사용한 계산 결과</title>
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/css/my_style.css">
    </head>
    <body>
        <div class="padding_bottom_30px box center" style="width: 80%;">
            Request Parameter n : ${param.n}
        </div>

        <ul>
            <li>계산 결과 1: ${result}</li>
        </ul>

        
    <%@include file="/WEB-INF/jspf/main_footer.jspf" %>   
</html>
