var usersApp = angular.module('usersApp', []);

usersApp.controller('UserCtrl',['$scope','$http', function($scope, $http){
	$scope.userList = [
	                   {id: 1, name: 'Siva1', email: 'siva1@gmail.com'},
	                   {id: 2, name: 'Siva2', email: 'siva2@gmail.com'},
	                   {id: 3, name: 'Siva3', email: 'siva3@gmail.com'},
	                   {id: 4, name: 'Siva4', email: 'siva4@gmail.com'},
	                   {id: 5, name: 'Siva5', email: 'siva5@gmail.com'}
	                   ];
	
	$http.get('users/2/contacts/').success(function(data){
		$scope.userList = data;
	});
	
	$scope.handleEditUser = function(user){
		$scope.editingUser = user;
		var cloneUser = angular.copy(user);//JSON.parse( JSON.stringify( user ) );
		$scope.editUser = cloneUser;
	};
	
	$scope.handleDeleteUser = function(user){
		alert('Delete User: '+user.name);
	};
	
	$scope.handleUpdateUser = function(user){
		//alert('Update User: '+user.name);
		//$scope.editingUser = JSON.parse( JSON.stringify( user ) );
		copy($scope.editingUser, user);
	};
	
	function copy(a, b) {
		  Object.keys(b).forEach(function(key) {
		    a[key] = b[key];
		  });
		}
	
}]);