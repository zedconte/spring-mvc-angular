'use strict';

/**
 * CarController
 * @constructor
 */
var CarController = function($scope, $http) {
    $scope.car = {};
    $scope.editMode = false;

    $scope.fetchCarsList = function() {
        $http.get('cars/carlist.json').success(function(carList){
            $scope.cars = carList;
        });
    };

    $scope.addCar = function(car) {
        $scope.resetError();
        $http.post('cars/add/', car).success(function() {
            $scope.fetchCarsList();
            $scope.car.name = '';
            $scope.car.cylinders = '';
        }).error(function() {
            $scope.setError('Could not add a new car');
        });
        //$scope.carName = '';
    };

    $scope.updateCar = function(car) {
        $scope.resetError();

        $http.put('cars/update', car).success(function() {
            $scope.fetchCarsList();
            $scope.car.name = '';
            $scope.car.cylinders = '';
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the car');
        });
    };


    $scope.editCar = function(car) {
        $scope.resetError();
        $scope.car = car;
        $scope.editMode = true;
    };

    $scope.removeCar = function(id) {
        $scope.resetError();
/*        $http.delete('cars/removeCar/' + car).success(function() {
         $scope.fetchCarsList();
         });*/
        $http.delete('cars/remove/' + id).success(function() {
            $scope.fetchCarsList();
        }).error(function() {
            $scope.setError('Could not remove car');
        });

        $scope.car = '';
    };

    $scope.removeAllCars = function() {
/*        $http.delete('cars/removeAllCars').success(function() {
            $scope.fetchCarsList();
        });*/
        $scope.resetError();

        $http.delete('cars/removeAll').success(function() {
            $scope.fetchCarsList();
        }).error(function() {
            $scope.setError('Could not remove all Cars');
        });
    };

    $scope.resetCarForm = function() {
        $scope.resetError();
        $scope.car = {};
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchCarsList();

    $scope.predicate = 'id';
};