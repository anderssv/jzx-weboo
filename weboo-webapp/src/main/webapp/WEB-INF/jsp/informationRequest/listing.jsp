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
	   <table summary="All information requests">
	    	<caption>All information requests</caption>
			<thead>
				<tr>
					<th>Request number</th>
					<th>Request title</th>
					<th>Request status</th>
					<th>Request operations</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requests}" var="informationRequest">
					<tr class="informationRequest">
						<td><span class="requestNumber">${informationRequest.id}</span></td>
						<td><span class="requestTitle">${informationRequest.title}</span></td>
						<td><span class="status">${informationRequest.received}</span></td> 
						<td> 
							<span class="operations"> 
								<c:if test="${informationRequest.received eq false}">
									<c:url value="/informationRequest/${informationRequest.id}/received" var="requestReceivedUrl" />
									<a href="${requestReceivedUrl}">Open</a>
								</c:if>
							</span>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
