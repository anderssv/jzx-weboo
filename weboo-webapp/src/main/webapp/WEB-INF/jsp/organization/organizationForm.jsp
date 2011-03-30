<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Register Organization</title>
</head>
<body>

	<form:form commandName="organization">
		<label>Organization name:</label><form:input path="name" />
		<label>Organization number:</label><form:input path="organizationNumber" />
	</form:form>

</body>
</html>
