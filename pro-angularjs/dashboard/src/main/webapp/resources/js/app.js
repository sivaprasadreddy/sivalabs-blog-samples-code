var myApp = angular.module('myApp',[]);

myApp.controller('UserController',['$scope', '$http',function($scope, $http){
	
	$scope.hello = 'Hello Buddy';
	
	$scope.loadUsers = function()
	{
		$http.get('users/')
			.success(function(data, status, headers, config){
				$scope.users = data;
			})
			.error(function(data, status, headers, config){
				alert('Error')
			});
	}
	
	$scope.loadHome = function()
	{
		$scope.resetAll();
		$scope.loadUsers();
	}
	
	$scope.resetAll = function()
	{
		$scope.query = '';
		$scope.newUser = null;
		$scope.currentUser = null;
	}
	
	$scope.searchUsers = function()
	{
		$http.get('users/search?query='+$scope.query)
		.success(function(data, status, headers, config){
			$scope.users = data;
		});
		
		//$scope.loadHome();
	}
	
	$scope.newUserForm = function()
	{
		$scope.resetAll();
		$scope.newUser = {};
	}
	
	$scope.editUserForm = function(userId)
	{
		$scope.resetAll();
		
		$http.get('users/'+userId)
		.success(function(data, status, headers, config){
			$scope.currentUser = data;
		})
		.error(function(data, status, headers, config){
			alert('Error');
		});
	}
	

	$scope.createUser = function()
	{
		$http.post('users/', $scope.newUser)
		.success(function(data, status, headers, config){
			$scope.loadHome();
		})
		.error(function(data, status, headers, config){
			alert('Error :'+data.error);
		})
		
	}
	
	$scope.updateUser = function()
	{
		$http.put('users/',$scope.currentUser)
		.success(function(){
			$scope.loadHome();
		});
	}
	
	$scope.deleteUser = function(userId)
	{
		$http.delete('users/'+userId)
		.success(function(){
			$scope.loadHome();
		});
	}
	
	$scope.loadHome();
	
}]
);