<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Register new request</title>
</head>
<body>

	<form:form modelAttribute="informationRequest">
		
		<form:errors id="errors" path="*" />
		
		<label>Request title:</label><form:input path="title" />
		
		<input type="submit" value="Save" id="save" />
	</form:form>


</body>
</html>