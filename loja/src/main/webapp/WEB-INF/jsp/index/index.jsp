<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VRaptor Blank Project</title>
</head>
<body>
   	<a href="${linkTo[IndexController].novo()}">
   		Novo
   	</a>
	<ul>
		<c:forEach items="${pessoaList}" var="pessoa"> 
		    <li>
		    	<a href="${linkTo[IndexController].show(pessoa.id)}">
		    		${pessoa.nome}
		    	</a>
		    	- ${pessoa.nascidoEm}
		    	
		    	<a href="${linkTo[IndexController].delete(pessoa.id)}">
		    		Deletar
		    	</a>
		   	</li>
		</c:forEach>
	</ul>
</body>
</html>