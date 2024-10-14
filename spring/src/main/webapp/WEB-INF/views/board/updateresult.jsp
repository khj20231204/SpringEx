<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${result == 1}">
	<script>
		alert("글 수정 성공")
		/* 수정 후 글 목록으로 갈 수도 있고 수정 하던 상세 페이지로 갈 수도 있다 */
		/* location.href="boardlist.do?page=${page}"; */
		location.href="boardcontent.do?no=${board.no}&page={page}";
	</script>
</c:if>
<c:if test="${result != 1}">
	<script>
		alert("글 수정 실패")
		history.go(-1);
	</script>
</c:if>
</body>
</html>