<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<%@ include file="parts/head.jsp"%>
</head>
<body>
	<div class="nav">
		<a href="<c:url value="/"/>">Home</a>
	</div>
	<h1>Grand Circus Sunrise and Sunset Time</h1>

	<p>
		<label>Current Time: </label>
		<c:out value="${ sun.sunrise }" />
		<c:out value="${ sun.sunset }" />
		
	</p>

</body>
</html>