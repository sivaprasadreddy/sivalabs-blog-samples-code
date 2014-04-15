
var myApp = angular.module('myApp',[]);

myApp.controller('HelloCtrl', function($scope, $http){
	$scope.hello = 'Hello World';
	
	var futureResponse = $http.get('greet');
	
	futureResponse.success(function (data, status, headers, config) {
		$scope.data = data;
	});
	
	futureResponse.error(function (data, status, headers, config) {
		throw new Error('Something went wrong...');
	});
	
	
});