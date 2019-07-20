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
	    expandableRowTemplate: 'expandableRowTemplate.html',
	    expandableRowHeight: 550,
	    enableHorizontalScrollbar:0, 
	    enableVerticalScrollbar:2,
	    expandableRowScope: {
	     subGridVariable: 'subGridScopeVariable'
	    }
	  }

	  $scope.gridOptions.columnDefs = [
		  	{ name: 'S.No' , field:"id", width: '5%'},
		    { name: 'Database Service',field:"className", width: '95%' ,cellTemplate: '<div>' +
		          '  <a href="getSource/{{row.entity.projectId}}/{{COL_FIELD}}">{{COL_FIELD}}</a>' +
		          '</div>'}
		    /*{ name: 'Functions Count',field:"noOfMethods", width: '15%' },
		    { name: 'Lines of Code',field:"loc", width: '10%' }*/
	  ];
 
 
  $http.get('dataModelReportJSON?projectId='+$scope.pId+'&technology='+$scope.tId)//
     .then(function(response) {

      var data = response.data;
    
	      for(i = 0; i < data.length; i++){
	        var methods = data[i].methods;
	        
	    	$scope.pId=data[i].projectId;
	    	$scope.cName=data[i].className;
	    	//console.log('Outer loop');
	
	        for(j = 0; j < methods.length; j++){
	        	methods[j].subGridOptions = {
		          columnDefs: [ {name:"Id", field:"id", width: '5%'},        	 
		        	  {name:"Referenced Functionality", field:"methodRef", width:'15%'},
		        	  {name:"Call Sequence", field:"methodSequence", width:'50%' }, //, cellTemplate:'<div>'+$scope.parseSequence('{{COL_FIELD}}')+'</div>'		        	 
		        	  {name:"Referred Entities", field:"tableNms", width: '13%',wordWrap: true},
		        	  {name:"proposedMicroService", field:"proposedMicroService", width: '17%'}
		        	  ],
		          enableHorizontalScrollbar: 2,
		          data: methods[j].methodCallHierarchy
		        };

		        data[i].subGridOptions = {
		          columnDefs: [ {name:"Id", field:"id", width: '5%'},
		        	  {name:"Functionality", field:"methodName", width: '20%',cellTemplate: '<div>' +
			          '  <a href="getSource/'+$scope.pId+'/'+$scope.cName+'/{{COL_FIELD}}">{{COL_FIELD}}</a>' +
			          '</div>'},
		              //{name:"Lines of Code", field:"loc", width: '20%'},
			          {name:"Input Parameters", field:"methodParams", width: '75%'}
		          ],
		          data: methods,
		          expandableRowTemplate: 'expandableRowTemplateLevel2.html',
		          rowTemplate: 'rowTemplate.html',
		          enableHorizontalScrollbar: 0,
		          expandableRowHeight: 600
		        };
	        }
	      }
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
    
    $scope.parseSequence = function (p) {
    	console.log(p);
    	var temp='<a href="getSource/'+$scope.pId+'/{{COL_FIELD}}">{{COL_FIELD}}</a>' ;
        return temp;
    }

}]);


