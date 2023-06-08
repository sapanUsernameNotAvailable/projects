/**
 * @author sapan.verma
 * This layer is sandwiched between the view presentation and view logic layer.
 * This allows for separation of HTML markup and js dom funtions.
 * I haven't come across this approach in the view layer before, so this might be flawed. 
 * */ 
require([ "dojo/on", "dojo/dom", "dojo/topic", "dojo/query", "../../megaProject/js/viewLogicLayer.js", "dojo/domReady!" ], function(on, dom, topic, query,
		vl) {
	// load page handled
	vl.loadPage(query("#resultSet")[0]);
	// contact addition handled
	on(dom.byId("addNew"), "click", function() {
		vl.addContact(query("#newDetails")[0], query("#resultSet")[0]);
	});
	// contact deletion handled
	on(dom.byId("deleteData"), "click", function() {
		vl.deleteContact(query("#resultSet")[0]);
	});
});