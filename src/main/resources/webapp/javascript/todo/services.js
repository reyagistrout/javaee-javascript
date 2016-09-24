'use strict';

var todoServices = angular.module('todoServices', ['ngResource']);

todoServices.factory('ToDo', ['$resource',
    function($resource) {
        return $resource(
                'http://localhost:12345/resources/todo/:userId/:itemId',
                {userId: principal, itemId: '@id'}, {'update': {method: 'PUT'}});
    }]);