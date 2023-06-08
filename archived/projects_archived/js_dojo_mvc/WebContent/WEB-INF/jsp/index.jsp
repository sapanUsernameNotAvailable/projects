<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script src="js/dojo/dojo/dojo.js" data-dojo-config="async: true"></script>
<script src="js/eventManager.js"></script>
</head>
<body>
	<div class = "title">
		<spring:message code="welcome" />
	</div>
	<input id="refreshData" type="button" value="refresh data" />
	<input id="deleteData" type="button" value="delete selected" />
	<div id="resultSet"></div>
	<div id="newDetails">
		<p>new id</p>
		<input type="text" id="newId" />
		<p>new name</p>
		<input type="text" id="newName" />
		<p>new phone</p>
		<input type="text" id="newPhone" />
	</div>
	<input id="addNew" type="button" value="add new contact" />
</body>
</html>