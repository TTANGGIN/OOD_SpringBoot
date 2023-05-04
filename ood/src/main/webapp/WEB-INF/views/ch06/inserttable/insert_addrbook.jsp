<%--
  Created by IntelliJ IDEA.
  User: CHANG
  Date: 2023-05-04
  Time: 오후 5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>주소록 추가 폼</title>
  <link rel="styleSheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
</head>
<script>
  <c:if test="${!empty msg}">
  alert("${msg}");
  </c:if>
</script>
<body>
<h1>주소록 추가</h1>
<hr/>

<form action="${pageContext.request.contextPath}/ch06/insert.do" method="post">
  <table border="0">
    <tbody>
    <tr>
      <td>이름</td>
      <td><input type="text" name="name" size="20"/></td>
    </tr>
    <tr>
      <td>이메일</td>
      <td><input type="text" name="email" value="" size="20"/></td>
    </tr>
    <tr>
      <td>전화번호</td>
      <td><input type="text" name="phone" value="" size="20"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <center>
          <input type="submit" value="추가"/><input type="reset" value="취소"/>
        </center>
      </td>
    </tr>
    </tbody>
  </table>
</form>

<br><br>

<%@include file="/WEB-INF/jspf/main_footer.jspf" %>
</body>
</html>
