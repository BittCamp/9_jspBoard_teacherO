<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${msg!=null }">
     <script type="text/javascript">
         var msg = '${msg}';
         alert("처리 결과: "+msg);
     </script>
  </c:if>
<script type="text/javascript">
    document.location.href= "${url}";
</script>