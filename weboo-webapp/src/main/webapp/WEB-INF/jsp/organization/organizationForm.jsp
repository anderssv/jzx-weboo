<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Register Organization</title>
</head>
<body>


	<form:form modelAttribute="organizationForm">

		<form:errors id="errors" path="*" />
		<c:if test="${organizationForm.organization.organizationNumber eq null}">
			<label>Organization number:</label>
			<form:input path="organizationNumberSearch" />
			<input type="submit" value="Lookup" name="lookup" id="lookup" />
		</c:if>
		<c:if test="${organizationForm.searchPerformed}">
			<label>Organization number:</label>
			<form:hidden path="organization.organizationNumber"/>
			<c:out value="${organizationForm.organization.organizationNumber}" />
			<label>Organization name:</label>
			<form:input path="organization.name" />
			<input type="submit" value="Save" name="save" id="save" />
		</c:if>

	</form:form>

</body>
</html>
