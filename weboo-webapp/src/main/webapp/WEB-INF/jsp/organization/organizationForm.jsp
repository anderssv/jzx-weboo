<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Register Organization</title>
</head>
<body>


	<form:form modelAttribute="informationRequest.organization">

		<form:errors id="errors" path="*" />
		<c:if
			test="${informationRequest.organization.organizationNumber eq null}">
			<label>Organization number:</label>
			<form:input path="organizationNumber" />
			<input type="submit" value="Lookup" name="lookup" id="lookup" />
		</c:if>
		<c:if
			test="${informationRequest.organization.organizationNumber ne null}">
			<label>Organization number:</label><c:out value="${informationRequest.organization.organizationNumber}"/>
			<label>Organization name:</label>
			<form:input path="name" />
			<input type="submit" value="Save" name="save" id="save" />
		</c:if>

	</form:form>

</body>
</html>
