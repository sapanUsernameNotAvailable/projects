app.controller("MyController", function($scope){
   $scope.inputted="";
   
	$scope.people = [{
			name: 'Leon',
			music: [
				'Rock',
				'Metal',
				'Dubstep',
				'Electro'
			]
		}, {
			name: 'Chris',
			music: [
				'Indie',
				'Drumstep',
				'Dubstep',
				'Electro'
			]
		}];
});
