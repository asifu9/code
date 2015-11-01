//Define an angular module for our app
var sampleApp = angular.module('sampleApp', ['ngRoute']);
sampleApp.factory('sharedService', function($rootScope) {
    var sharedService = {};
    sharedService.info1={};
    sharedService.info1={};
    sharedService.level1 = '';
    sharedService.level2 = '';
    sharedService.level3 = '';
    sharedService.level4 = '';
    sharedService.level5 = '';
    sharedService.base='';
    sharedService.level1Path='';
    sharedService.level2Path='';
    sharedService.level3Path='';
    sharedService.level4Path='';
    sharedService.level5Path='';
    
    sharedService.setInfo1=function(infoLevel1){
    	this.info1=infoLevel1;
    }
    sharedService.getInfo1=function(){
    	return sharedService;
    }
    sharedService.setBase=function(baseValue){
    	this.base=baseValue;
    }
    sharedService.setLevel = function(levelValue,levelNumber) {
        if(levelNumber===1){
        	this.level1=levelValue;
        }else if(levelNumber===2){
        	this.level2=levelValue;
        }else if(levelNumber===3){
        	this.level3=levelValue;
        }else if(levelNumber===4){
        	this.level4=levelValue;
        }else if(levelNumber===5){
        	this.level5=levelValue;
        }
    };
    sharedService.setLevelPath = function(path,levelNumber) {
        if(levelNumber===1){
        	this.level1Path=path;
        }else if(levelNumber===2){
        	this.level2Path=path;
        }else if(levelNumber===3){
        	this.level3Path=path;
        }else if(levelNumber===4){
        	this.level4Path=path;
        }else if(levelNumber===5){
        	this.level5Path=path;
        }
    };
    
    sharedService.getLevel=function(){
    	return sharedService;
    };

    return sharedService;
});



sampleApp.controller('baseController', ['$scope','$routeParams','$location','sharedService', function($scope,$routeParams,$location,sharedService) {
	console.log("here i am");
	
	//http://localhost:8080/health/rest/fitness/secondLevel/fitness/Women
}]);

sampleApp.controller('docListController',['$scope','$http',function($scope,$http){
	$scope.docs = [];
	$scope.getDocs = function() {

        $http({method : 'GET',url : 'http://localhost:8080/health/rest/doctor/info'})
            .success(function(data, status) {
                $scope.docs = data;
            })
            .error(function(data, status) {
                alert("Error");
            });
    };
}]);
sampleApp.controller('hosListController',['$scope','$http',function($scope,$http){
	$scope.hos = [];
	$scope.getHos = function() {

        $http({method : 'GET',url : 'http://localhost:8080/health/rest/hospital/all'})
            .success(function(data, status) {
                $scope.hos = data;
            })
            .error(function(data, status) {
                alert("Error");
            });
    };
}]);

sampleApp.controller('registerController',['$scope', function($scope){
	
	console.log("here i am in registration");
	
}]);
 

sampleApp.controller('level1Controller',['$scope','$http','$routeParams','$location','sharedService',function($scope,$http,$routeParams,$location,sharedService) {
    
	console.log("here in first leve");
    $scope.items = [];
    console.log("here is console " + $routeParams.selType);
	sharedService.setBase($routeParams.selType);
	console.log(sharedService);
	console.log("$location.$$absUrl " + $location.$$absUrl);
	sharedService.setLevelPath($location.$$absUrl,1);
    $scope.getItems = function() {

        $http({method : 'GET',url : 'http://localhost:8080/health/rest/fitness/firstlevel'})
            .success(function(data, status) {
                $scope.items = data;
                sharedService.setInfo1(data);
            })
            .error(function(data, status) {
                alert("Error");
            });
    };
}]);
sampleApp.controller('level2Controller',['$scope','$http','$routeParams','$location','sharedService',function ($scope,$http,$routeParams,$location,sharedService) {
	// $scope.user.genderType=  $routeParams.genderType;
	 sharedService.setLevel($routeParams.genderType,1);
	 console.log(sharedService);
	 console.log($location);
	 console.log("path is here "+$location.$$path);
	 sharedService.setLevelPath($location.$$absUrl,2);
	 
	 $scope.mylevel1=sharedService.level1;
	 $scope.myLevel1Path=sharedService.level1Path;
	 console.log("------------------------------");
	 console.log(sharedService);
	 //fetch level2 data
	 $scope.items = [];
    $scope.getItems = function() {

        $http({method : 'GET',url : 'http://localhost:8080/health/rest/fitness/secondLevel/'+sharedService.base+'/'+sharedService.level1})
            .success(function(data, status) {
                $scope.items = data;
            })
            .error(function(data, status) {
                alert("Error");
            });
    };


}]);

sampleApp.controller('level3Controller',['$scope','$http','$routeParams','$location','sharedService',function($scope,$http,$routeParams,$location,sharedService){
	sharedService.setLevel($routeParams.bodyType,2);
	$scope.mylevel1=sharedService.level1;
	$scope.mylevel2=sharedService.level2;
	console.log(sharedService);
	sharedService.setLevelPath($location.$$absUrl,3);
	 $scope.myLevel2Path=sharedService.level2Path;
	 $scope.myLevel1Path=sharedService.level1Path;
	 console.log(" sharedService.level1Path "+ sharedService.level1Path + " : " + sharedService.level2Path);
	//http://localhost:8080/health/rest/fitness/thirdLevel/Men
	 $scope.items = [];
	    $scope.getItems = function() {

	        $http({method : 'GET',url : 'http://localhost:8080/health/rest/fitness/thirdLevel/'+sharedService.level1})
	            .success(function(data, status) {
	                $scope.items = data;
	            })
	            .error(function(data, status) {
	                alert("Error");
	            });
	    };
	
	
}]);

sampleApp.controller('level4Controller',['$scope','$http','$routeParams','$location','sharedService',function($scope,$http,$routeParams,$location,sharedService){
	sharedService.setLevel($routeParams.wtype,3);
	$scope.mylevel1=sharedService.level1;
	$scope.mylevel2=sharedService.level2;
	$scope.mylevel3=sharedService.level3;
	console.log($scope);
	sharedService.setLevelPath($location.$$absUrl,4);
	$scope.myLevel1Path=sharedService.level1Path;
	$scope.myLevel2Path=sharedService.level2Path;
	//http://localhost:8080/health/rest/fitness/fourthLevel
	$scope.myLevel3Path=sharedService.level3Path;
	 $scope.items = [];
	    $scope.getItems = function() {

	        $http({method : 'GET',url : 'http://localhost:8080/health/rest/fitness/fourthLevel'})
	            .success(function(data, status) {
	                $scope.items = data;
	            })
	            .error(function(data, status) {
	                alert("Error");
	            });
	    };
}]);

sampleApp.controller('level5Controller',['$scope','$http','$routeParams','$location','sharedService',function($scope,$http,$routeParams,$location,sharedService){
	console.log("ssssssss " + $routeParams.gainloss);
	sharedService.setLevel($routeParams.gainloss,4);
	$scope.mylevel1=sharedService.level1;
	$scope.mylevel2=sharedService.level2;
	$scope.mylevel3=sharedService.level3;
	$scope.mylevel4=sharedService.level4;
	$scope.mylevel5Path=$location.$$absUrl;
	$scope.myLevel1Path=sharedService.level1Path;
	$scope.myLevel2Path=sharedService.level2Path;
	$scope.myLevel3Path=sharedService.level3Path;
	$scope.myLevel4Path=sharedService.level4Path;
	console.log(sharedService);
	//http://localhost:8080/health/rest/fitness/fourthLevel
	 $scope.items = [];
	    $scope.getItems = function() {

	        $http({method : 'GET',url : 'http://localhost:8080/health/rest/fitness/fifthLevel/'+sharedService.base+'/'+sharedService.level1})
	            .success(function(data, status) {
	                $scope.items = data;
	            })
	            .error(function(data, status) {
	                alert("Error");
	            });
	    };
}]);


//Define Routing for app
//Uri /AddNewOrder -> template add_order.html and Controller AddOrderController
//Uri /ShowOrders -> template show_orders.html and Controller AddOrderController
sampleApp.config(['$routeProvider',
function($routeProvider) {
  $routeProvider.
  when('/register', {
      templateUrl: 'templates/fitness/register.html',
      controller: 'registerController'
  }).
  when('/', {
      templateUrl: 'templates/fitness/home.html',
      controller: 'baseController'
  }).
    when('/level1/:selType', {
      templateUrl: 'templates/fitness/fit-level1.html',
      controller: 'level1Controller'
  }).
    when('/level2/:genderType', {
      templateUrl:  'templates/fitness/fit-level2.html',
      controller: 'level2Controller'
    }).
    when('/level3/:bodyType', {
        templateUrl:  'templates/fitness/fit-level3.html',
        controller: 'level3Controller'
      }).
    when('/level4/:wtype', {
          templateUrl:  'templates/fitness/fit-level4.html',
          controller: 'level4Controller'
      }).
      when('/level5/:gainloss', {
          templateUrl:  'templates/fitness/fit-level5.html',
          controller: 'level5Controller'
      }).
      when('/hospitals', {
          templateUrl:  'templates/fitness/hospitallist.html',
          controller: 'hosListController'
      }).
    otherwise({
      redirectTo: '/level1'
    });
}]);
/*function baseController($scope){
	
	
}*/


//level1Controller.$inject = ['$scope','$http','$routeParams', 'mySharedService'];   
//level2Controller.$inject = ['$scope','$http','$routeParams', 'mySharedService'];   
/*level3Controller.$inject = ['$scope','$http','$routeParams', 'mySharedService'];
level4Controller.$inject = ['$scope','$http','$routeParams', 'mySharedService'];*/
