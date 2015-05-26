<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VRaptor Blank Project</title>
</head>
<body>
	<ul>
		<c:forEach items="${pessoaList}" var="pessoa">
		    <li>${pessoa.nome} - ${pessoa.nascidoEm}</li>
		</c:forEach>
	</ul>
</body>
</html>