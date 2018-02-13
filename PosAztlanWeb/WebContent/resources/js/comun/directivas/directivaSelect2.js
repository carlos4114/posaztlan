'use strict';


angular.module('indexModule').directive('directivaSelect2', function () {
    return {
        restrict: 'A',
        scope: {
                'selectWidth': '@',
                'ngModel': '='
        },
        link: function (scope, element, attrs) {
            scope.selectWidth = scope.selectWidth || 200;
            element.select2({
                width: scope.selectWidth,
            });
            
            
        }
    };
});