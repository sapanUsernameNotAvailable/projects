/**
 * @author sapan
 * 
 * This is the server access object. Its inspired by DAO. This enables the rest
 * of the js to be independent of the server mappings, format returned, etc.
 * Again, this might be conceptually broken cause I haven't come across this
 * before. This class has a one to one mapping with the relevant controller
 * mappings. Methods here should receive raw arguments to be sent to the server,
 * not domain objects.
 */
define([ "dojo/request", "dojo/topic" ], function(request, topic) {
	return {
		addContact : function(idArg, nameArg, phoneArg, defferred) { // done
			request.post("addContact.htm", {
				query : {
					id : idArg,
					name : nameArg,
					phone : phoneArg
				}
			}).then(function(response) {
				defferred.resolve(response);
			}, function(error) {
				alert(error);
			});
		},
		removeContact : function(idArg, defferred) { // done
			request.get("removeContact.htm", {
				query : {
					id : idArg
				}
			}).then(function(response) {
				defferred.resolve(response);
			}, function(error) {
				alert(error);
			});
		},
		getContacts : function(defferred) { // done
			request.get("listContacts.htm", {
				handleAs : "json"
			}).then(function(data) {
				defferred.resolve(data);
			}, function(error) {
				alert(error);
			});
		}
	};
});