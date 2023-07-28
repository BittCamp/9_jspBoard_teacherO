<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글리스트</title>
</head>
<body>
<%@include file="top.jsp" %>
<h3 style="text-align: center;">자유 게시판</h3>
<hr style="margin-bottom: 5px; margin-top: 5px;">
<div class="container">
  <c:choose>
    <c:when test="${ articles ==null or fn:length(articles)==0}">
      <table>
        <tbody>
            <tr> <td>게시글이 없습니다.</td>
            </tr>
        </tbody>
      </table>
    </c:when>
    <c:when test="${articles !=null and fn:length(articles)>0}">
      <table>
        <tbody>
         <tr>
           <th>글제목</th>
           <th>작성자</th>
           <th>이메일</th>
           <th>조회수</th>
           <th>작성일</th>
         </tr>
        <c:forEach var="article" items="${articles}">
            <tr> 
               <td>${article.subject}</td>
	           <td>${article.writer}</td>
	           <td>${article.email}</td>
	           <td>${article.readcount }</td>
	           <td>${article.reg_date}</td>
            </tr>
        </c:forEach>
        </tbody>
      </table>
    </c:when>
  </c:choose>
</div>
</body>
</html>