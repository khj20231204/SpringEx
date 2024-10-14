<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제</title>
</head>
<body>

<!-- 원래는 boarddeleteform.do에서 model로 넘겨야하는데 controller에서 넘기지 않고
.jsp -> .do -> .jsp
controller의 RequestParam으로 받는 걸 jsp에서 바로 ${param. } 으로 접근 가능
 -->
no : ${param.no} <br> 
page : ${param.page}
<form method=post action="boarddelete.do">
<input type="hidden" name="no" value="${param.no}"> 
<input type="hidden" name="page" value="${param.page}">

<table border=1 width=400 align=center>
	<caption><h3>글 삭제</h3></caption>
	<tr><th>비밀번호</th>
		<td><input type=password name="passwd" required="required"></td>
	</tr>
	<tr><td colspan=2 align=center>
			<input type=submit value="글 삭제">
			<input type=reset value="취소">
		</td>
	</tr>
</table>
</form>

</body>
</html>