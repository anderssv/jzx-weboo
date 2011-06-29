<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>All information requests</title>
</head>
<body>

	<div id="requestListing">
		<c:forEach items="${requests}" var="informationRequest">
			<div class="informationRequest">
				<span class="requestNumber">${informationRequest.id}</span>
				<span class="requestTitle">${informationRequest.title}</span>
			</div>
		</c:forEach>
	</div>

</body>
</html>
