<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib
	prefix="form"
	uri="http://www.springframework.org/tags/form"%>
<%@taglib
	prefix="spring"
	uri="http://www.springframework.org/tags"%>
<%@taglib
	uri="http://java.sun.com/jstl/core"
	prefix="c"%>
<html>
<head>
<script src="js/dojo.1.6.1.xd.js"></script>
<script>
	function createContact() { // done
		var xhrArgs = {
			url : "addContact.htm?id=77&name=faltu&phone=34444",
			load : function(data) {
				alert(data);
			},
			error : function(error) {
				alert("foobar");
			}
		}
		dojo.xhrPost(xhrArgs);
	}
	function readContact() {
		var xhrArgs = {
			url : "listContacts.htm",
			load : function(data) {
				alert(data);
			},
			error : function(error) {
				alert("foobar");
			}
		}
		dojo.xhrGet(xhrArgs);
	}
	function deleteContact() { //done
		var xhrArgs = {
			url : "removeContact.htm?id=77",
			handleAs : "text",
			load : function(data) {
				alert(data);
			},
			error : function(error) {
				alert("foobar");
			}
		}
		dojo.xhrGet(xhrArgs);
	}
</script>
</head>
<body>
	<input
		type="button"
		value="create"
		id="create"
		onclick="createContact();" />
	<input
		type="button"
		value="read"
		id="read"
		onclick="readContact();" />
	<input
		type="button"
		value="delete"
		id="delete"
		onclick="deleteContact();" />
</body>
</html>