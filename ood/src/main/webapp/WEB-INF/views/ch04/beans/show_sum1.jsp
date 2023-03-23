<%-- 
    Document   : show_sum1
    Created on : 2023. 3. 23., 오후 7:06:33
    Author     : CHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="sumBean" scope="page" 
             class="deu.se.ood.beans.ch04.SumBean" />
<jsp:setProperty name="sumBean" property="n" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Java Bean을 사용한 계산 결과</title>
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/css/my_style.css">
    </head>
    <body>
        <div class="padding_bottom_30px box center" style="width: 80%;">
            Request Parameter n : <%=request.getParameter("n")%>
        </div>

        <% sumBean.calculate();%>
        
        <ul>
            <li>계산 결과 1: <jsp:getProperty name="sumBean" property="result" /></li>
            <li>계산 결과 2: <%=sumBean.getResult()%></li>
            <li>계산 결과 3: ${sumBean.result}</li>
        </ul>

        
    <%@include file="/WEB-INF/jspf/main_footer.jspf" %>   
    </body>
</html>
