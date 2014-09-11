angular.module('ru.yandex.qatools.camelot.yandexer.Collector', ['camelotUtil'])
    .controller('AppCtrl', ['$scope', '$http', 'subscribe', 'baseUrl', 'pluginId', function ($scope, $http, subscribe, baseUrl, pluginId) {
        'use strict';
        $scope.results = {};
        $scope.doSearch = function () {
            $http.get(baseUrl + '/search', {
                params: {
                    key: $scope.searchKey
                }
            }).success(function (launch) {
                    $scope.searchKey = '';
                });
        };
        subscribe(pluginId, function (message) {
            $scope.results[message.key] = message;
        });
    }]);
