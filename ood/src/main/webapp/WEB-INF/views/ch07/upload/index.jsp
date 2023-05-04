<%-- 
    Document   : index
    Created on : 2023. 5. 4., 오전 11:25:20
    Author     : CHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>파일 업로드</title>
        <<link rel="stylesheet" type="text/css" 
               href="${pageContext.request.contextPath}/css/my_style.css"/>
    </head>
    <body>
        <h1>파일 올리기</h1>
        <hr>
        <c:if test="${!empty exec_message}">
            <div class="box">실행 결과: ${exec_message}</div>
        </c:if>
            
            <form enctype="multipart/form-data" method="POST"
                  action="${pageContext.request.contextPath}/ch07/upload.do">
                username: <input type="text" name="username"> <br>
                upload할 파일 선택: <<input type="file" name="upfile"> <br>
                <input type="submit" name="Upload">
            </form>
                
            <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
    </body>
</html>
