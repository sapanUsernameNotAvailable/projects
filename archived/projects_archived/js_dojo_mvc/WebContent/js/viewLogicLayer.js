/**
 * @author sapan
 * 
 * This layer is made to be independent of who calls the methods of this layer.
 * There is HTML rendering in this layer as well, but its independent of the
 * document semantics of the HTML which is templated by the functions in this
 * file.
 */
define([ "dojo/dom-attr", "dojo/Deferred", "dojo/query", "dojo/topic", "dojo/_base/array", "../../megaProject/js/SAO.js" ], function(attr, deff,
		query, topic, array, sao) {
	return {
		/* event functions */
		deleteContact : function(resultSet) {
			var obj = this;
			var resultSetChanged = false;
			var contacts = query(".contact", resultSet);
			array.forEach(contacts, function(contact) {
				var checkbox = query(".delete", contact)[0];
				var checked = attr.get(checkbox, "checked");
				if (checked == true) {
					var id = query(".idHolder", contact)[0].innerHTML;
					var later = new deff();
					// update client when confirmation from server
					later.then(function(data) {
						obj.loadPage(resultSet);
					}, function(error) {
						alert("errror herre");
					});
					sao.removeContact(id, later);
				}
			});
		},
		addContact : function(newContact, resultSet) {
			var obj = this;
			var newId = attr.get(query("#newId", newContact)[0], "value");
			var newName = attr.get(query("#newName", newContact)[0], "value");
			var newPhone = attr.get(query("#newPhone", newContact)[0], "value");
			var later = new deff();
			// update client when confirmation from server
			later.then(function(data) {
				obj.loadPage(resultSet);
			}, function(error) {
				alert("errror herre");
			});
			// send to server
			sao.addContact(newId, newName, newPhone, later);
		},
		loadPage : function(resultSet) {
			var obj = this;
			var later = new deff();
			later.then(function(data) {
				obj._frameResultSet(resultSet, data);
				obj._populateResultSet(resultSet, data);
			}, function(error) {
				alert("errror herre");
			});
			sao.getContacts(later);
		},
		/* non event functions */
		_populateResultSet : function(resultSet, data) {
			var resultSetContacts = query(".contact", resultSet);
			var currentresultSetContactIndex = 0;
			array.forEach(data, function(contact, index) {
				var currentContact = resultSetContacts[currentresultSetContactIndex];
				query(".idHolder", currentContact)[0].innerHTML = data[index]["id"];
				query(".nameHolder", currentContact)[0].innerHTML = data[index]["name"];
				query(".phoneHolder", currentContact)[0].innerHTML = data[index]["phone"];
				currentresultSetContactIndex++;
			});
		},
		_frameResultSet : function(resultSet, data) {
			var placeholderFormat = "";
			array.forEach(data, function(contact, index) {
				placeholderFormat += "<div class = \"contact\">";
				placeholderFormat += "<div class = \"idHolder\"></div>";
				placeholderFormat += "<div class = \"nameHolder\"></div>";
				placeholderFormat += "<div class = \"phoneHolder\"></div>";
				placeholderFormat += "<input type =\"checkbox\" class =\"delete\" />";
				placeholderFormat += "</div>";
			});
			resultSet.innerHTML = placeholderFormat;
		}
	};
});