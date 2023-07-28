<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> <!--[ 김찬영  2023-07-14 오후 03:34:19 ]  -->
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style type="text/css">
 table{ 
  margin: 0 auto;
  width: 695px;
  border: 1px solid #4444;
 }
 th, td{
  border: 1px solid #4444;  
  width: 15%
 }
 textarea{
  resize: none;
 } 
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript" src="./js/board.js"></script>
</head>
<body>
<h3 style="text-align: center;">게시글 쓰기</h3>
<hr style="margin-bottom: 5px; margin-top:5px;">
<form action="writePro.to" method="post">
   <table>
    <tbody>
      <tr><th>글제목 </th><td><input name="subject" type="text" size="40" class="chk" title="글제목"></td></tr>
      <tr><th>글쓴이 </th><td><input name="writer" type="text" size="40" class="chk" title="글쓴이"></td></tr>
      <tr><th>글내용 </th><td><textarea name="content" rows="10" cols="49" class="chk" title="글내용"></textarea> </td></tr>
      <tr><th>이메일 </th><td><input name="email" type="text" size="30"></td></tr>
      <tr><th>비밀번호 </th><td><input name="passwd" type="password" size="30" class="chk pw1" title="비밀번호"></td></tr>
      <tr><th>비밀번호확인</th><td><input name="passwd" type="password" size="30" class="chk pw2" title="비밀번호 확인">
      		   <font class="pwMsg" style="font-size: 0.8em"></font>	
      </td></tr>
    </tbody> 
   </table>
   <table style="border: none;">
    <tbody style="border: none;">
      <tr style="text-align: center; border: none;"><td style=" border: none;">
        <input id="submit1" type="button" value="전송"> &nbsp;&nbsp;&nbsp; 
        <input type="button" value="글목록" onclick="javascript:location.href='list.to'"></td></tr>
    </tbody>
   </table>
</form>
</body>
</html>