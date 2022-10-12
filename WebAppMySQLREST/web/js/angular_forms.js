var app = angular.module("app", []);

function entityAct(entity) {
    app.controller("DBCtrl", 
    function($scope, $http) {
        $scope.saveRecord = function() {
            $scope.newEntity.fax="-0";
            var date = new Date();
            var date_form=(date.getDay()+2) + "_"+
                    (date.getMonth()+1)+"_"+
                    date.getFullYear()+"_"+
                    date.getHours()+":"+
                    date.getMinutes()+":"+
                    date.getSeconds()+":"+
                    date.getMilliseconds();
            $scope.newEntity.dateCreated = date_form;
            $http.post("/WebAppMySQLREST/webresources/com.cbm.web.rest.webappmysqlrest.entity."+entity, JSON.stringify($scope.newEntity))
                    .then(function(response){
                        $scope.clearFields();
                        $scope.getRecords(); 
                    });
        };
        
        $scope.getRecords = function() {
            $http.get("/WebAppMySQLREST/webresources/com.cbm.web.rest.webappmysqlrest.entity."+entity)
                    .then(function(response){
                        $scope.entity=response.data;
                    });
        };
        $scope.edit = function(id) {
            $scope.newEntity = $scope.entity[id];
            document.getElementById("btnSave").disabled = true;
            document.getElementById("btnEdit").disabled = false;
            document.getElementById("btnDelete").disabled = false;
        };
        
        $scope.editRecord = function() {
            $http.put("/WebAppMySQLREST/webresources/com.cbm.web.rest.webappmysqlrest.entity."+entity+"/"+$scope.newEntity.personId, JSON.stringify($scope.newEntity))
                    .then(function(response){$scope.getRecords();});
        };
        
        $scope.deleteRecord = function() {
            $http.delete("/WebAppMySQLREST/webresources/com.cbm.web.rest.webappmysqlrest.entity."+entity+"/"+$scope.newEntity.personId)
                    .then(function(response){$scope.clearFields(); $scope.getRecords();});
        };
        
        $scope.clearFields = function() {
            $scope.newEntity = {};
            document.getElementById("btnSave").disabled = false;
            document.getElementById("btnEdit").disabled = true;
            document.getElementById("btnDelete").disabled = true;
        };
        
        $scope.writeResponse = function() {
            $scope.ws_response = $scope.entity;
        };
        
        $scope.clearTextResponse = function() {
            $scope.ws_response = "";
        };
        
        $scope.ws_response="";
        $scope.getRecords(entity);
    });
}

function ChangeColor(tableRow, highlight) {
    if(highlight) {
        tableRow.style.backgroundColor="#808080";
    } else {
        tableRow.style.backgroundColor="white";
    }
}
