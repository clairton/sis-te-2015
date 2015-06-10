<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VRaptor Blank Project</title>
</head>
<body>	
	<form action="<c:url value='/update'/>" method="POST">
	    <input value="${pessoa.id}" name="pessoa.id" readonly="readonly"/>
	    
	    <input value="${pessoa.nome}" name="pessoa.nome"/>	    
		
		<input type="text" 
		value="<fmt:formatDate value='${pessoa.nascidoEm}' pattern='dd/MM/yyyy'/>" 
		name="pessoa.nascidoEm"/>
	    
	
	    <input type="submit" value="Save" />
	</form>
</body>
</html>