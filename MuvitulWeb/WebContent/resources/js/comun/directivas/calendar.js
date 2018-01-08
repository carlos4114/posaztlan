angular.module('indexModule').directive('calendar', function() {
    return {
        require: 'ngModel',
        link: function(scope, el, attr, ngModel) {
            $(el).datepicker({
                format: 'dd/mm/yyyy',
                autoclose: true,
                calender_style: "picker_2",
                startDate: new Date(),
                todayHighlight: true,
                todayBtn: "linked" 
            });
        }
    }
});



angular.module('indexModule').directive('dateRangePickerDos', function() {
    return {
        require: 'ngModel',
        link: function(scope, el, attr, ngModel) {
            $(el).daterangepicker({
                    singleDatePicker: true,
                    format: 'DD/M/YYYY',
                    autoclose: true,
                    calender_style: "picker_2",
                    startDate: moment(new Date(), "dd/mm/yyyy"),
                    todayHighlight: true,
                    todayBtn: "linked"
                },
                function(start, end, label) {
                    scope.$apply(function() {
                        ngModel.$setViewValue( moment(start, "dd/mm/yyyy"));
                    });
                });
        }
    }
});



angular.module('indexModule').directive('dateRangePickerTres', function() {
    return {
        require: 'ngModel',
        link: function(scope, el, attr, ngModel) {
            $(el).daterangepicker({
                    singleDatePicker: true,
                    format: 'DD/M/YYYY',
                    autoclose: true,
                    calender_style: "picker_3",
                    startDate:  moment(new Date(), "dd/mm/yyyy"),
                    todayHighlight: true,
                    todayBtn: "linked"
                },
                function(start, end, label) {
                    scope.$apply(function() {
                        ngModel.$setViewValue( moment(start, "dd/mm/yyyy"));
                    });
                });
        }
    }
});

angular.module('indexModule').directive('fecha', function() {
    return {
        require: 'ngModel',
        scope: {
        	mindate: '=',
        	maxdate: '=',
        	elemento: '=' 
         },
        link: function(scope, el, attr, ngModel) {
            $(el).datepicker({
                format: 'dd/mm/yyyy',
                autoclose: true,
                todayHighlight: true,
                todayBtn: "linked" 
            }).on('changeDate', function (selected) {
            	
            	if(scope.maxdate != undefined){
    	        	$('#'+scope.elemento).datepicker('setEndDate', scope.maxdate);
            	}
            	
            	if(scope.mindate != undefined){
    	        	$('#'+scope.elemento).datepicker('setStartDate', scope.mindate);
            	}
	        	
	    	});
        }
    }
});
 
angular.module('indexModule').directive('calendarMonth', function() {
    return {
        require: 'ngModel',
        link: function(scope, el, attr, ngModel) {
            $(el).datepicker({
            	format: "mm/yyyy",
            	 startView: "months", 
            	minViewMode: "months",
                autoclose: true,
                calender_style: "picker_2",
                todayHighlight: true,
                todayBtn: "linked" 
            });
        }
    }
});


angular.module('indexModule').directive('calendarDiasActivos', function() {
    return {
        require: 'ngModel',
        scope: {
        	mindate: '=',
        	maxdate: '=',
        	elemento: '=' 
         },
        link: function(scope, el, attr, ngModel) {
            $(el).datepicker({
                format: 'dd/mm/yyyy',
           	    daysOfWeekDisabled: [0,1,2,3,4,6],
                autoclose: true,
                todayHighlight: true,
                todayBtn: "linked" 
            }).on('changeDate', function (selected) {
            	
            	if(scope.maxdate != undefined){
    	        	$('#'+scope.elemento).datepicker('setEndDate', scope.maxdate);
            	}
            	
            	if(scope.mindate != undefined){
    	        	$('#'+scope.elemento).datepicker('setStartDate', scope.mindate);
            	}
	        	
	    	});
        }
    }
});
 

//
//angular.module('indexModule').directive('test', function() {
//    return {
//        require: 'ngModel',
//        scope: {
//        	mindate: '=',
//        	maxdate: '=',
//        	elemento: '=' 
//         },
//        link: function(scope, el, attr, ngModel) {
//            $(el).datepicker({
//                format: 'dd/mm/yyyy',
//           	    daysOfWeekDisabled: [0,1,2,3,4,6],
//                autoclose: true,
//                todayHighlight: true,
//                todayBtn: "linked" 
//            }).on('changeDate', function (selected) {
//            	
//            	var value = $("#weeklyDatePicker").val();
//                var firstDate = moment(value, "MM-DD-YYYY").day(1).format("MM-DD-YYYY");
//                var lastDate =  moment(value, "MM-DD-YYYY").day(7).format("MM-DD-YYYY");
//                $("#weeklyDatePicker").val(firstDate + " - " + lastDate);
//            });
//	        	
//	    	});
//        }
//    }
//});
 