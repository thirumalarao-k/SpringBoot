var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.expandable', 'ui.grid.selection']);
function rowTemplate() {
      return '<div ng-class="{ \'my-css-class\': grid.appScope.rowFormatter( row ) }">' +
                 '  <div ng-if="row.entity.merge">{{row.entity.title}}</div>' +
                 '  <div ng-if="!row.entity.merge" ng-repeat="(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name" class="ui-grid-cell" ng-class="{ \'ui-grid-row-header-cell\': col.isRowHeader }"  ui-grid-cell></div>' +
                 '</div>';
 
  }
app.controller('MainCtrl', ['$scope', '$http', '$log', function ($scope, $http, $log) {
		
	$scope.pId=$("#myDiv").attr("data-my-variable");
	$scope.tId=$("#myDiv").attr("data-my-variable2");
	  $scope.gridOptions = {	  
	    expandableRowHeight: 550,
	    enableHorizontalScrollbar:0, 
	    enableVerticalScrollbar:2,
	  }

	  $scope.gridOptions.columnDefs = [
		  	{ name: 'S.No' , field:"id", width: '5%'},
		    { name: 'Dependency Name',field:"dependencyNm", width: '35%' },
		    { name: 'Dependency Library',field:"dependencyLib", width: '35%' },
		    { name: 'Dependency Version',field:"dependencyVersion", width: '30%' }
	  ];
 
 
	$http.get('dependencyReportJSON?projectId='+$scope.pId+'&technology='+$scope.tId)//
     .then(function(response) {
      var data = response.data;
      $scope.gridOptions.data = data;
    });

    $scope.gridOptions.onRegisterApi = function(gridApi){
      $scope.gridApi = gridApi;
    };

    $scope.expandAllRows = function() {
      $scope.gridApi.expandable.expandAllRows();
    }

    $scope.collapseAllRows = function() {
      $scope.gridApi.expandable.collapseAllRows();
    }
    

}]);


