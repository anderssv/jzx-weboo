<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Summary of request</title>
</head>
<body>

	<span id="requestTitle">${informationRequest.title}</span>
	<span id="requestId">${informationRequest.id}</span>

</body>
</html>
