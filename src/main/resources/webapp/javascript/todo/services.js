'use strict';

var todoServices = angular.module('todoServices', ['ngResource']);

todoServices.factory('ToDo', ['$resource',
    function($resource) {
        return $resource(
                'http://localhost:12345/api1/todo/:userId/:itemId',
                {userId: 'nicole', itemId: '@id'}, {'update': {method: 'PUT'}});
    }]);