<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>        
<style type="text/css">
ul{
	list-style-type: none;
}
li{
   display: inline-block;
   margin: 12px 30px 0 50px;
   font-size:13px;
 }
.container li a:link {
    text-decoration:none;
    color:black;
}
.container li a:visited {
    text-decoration:none;
    color:black;
}
 .container li a:active {
    text-decoration:none;
    color:black;
}
.container{
   width: 700px;
   margin: 0 auto;
}
  table {
    margin: 0 auto;
    }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
  $().ready(function(){
	  }
	 );
  });
</script>
</head>
	<div class="container">
	  <ul style="text-align: right; ">
	      <li ><a href="writeForm.to">게시글 글쓰기</a></li>
	      <li ><a href="list.to">글목록</a></li>
	      <li>총 게시글(${total})</li>
	  </ul>
	</div>
	  <hr style="margin-top: 10px; margin-bottom: 10px;">
  
