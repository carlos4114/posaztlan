angular.module('indexModule').controller('modalControllerPrintTicket', function($scope, taquillaService) {
 
	
	$scope.generaArchivo = function(nombre, archivo, extension) {
		 
	 	var blob = new base64toBlob(archivo, extension);
		 var url = window.URL || window.webkitURL;
		 var blobUrl = url.createObjectURL(blob);
		 printJS(blobUrl);
 

	}

	function base64toBlob(base64Data, contentType) {
	    contentType = contentType || '';
	    var sliceSize = 1024;
	    var byteCharacters = atob(base64Data);
	    var bytesLength = byteCharacters.length;
	    var slicesCount = Math.ceil(bytesLength / sliceSize);
	    var byteArrays = new Array(slicesCount);

	    for (var sliceIndex = 0; sliceIndex < slicesCount; ++sliceIndex) {
	        var begin = sliceIndex * sliceSize;
	        var end = Math.min(begin + sliceSize, bytesLength);

	        var bytes = new Array(end - begin);
	        for (var offset = begin, i = 0 ; offset < end; ++i, ++offset) {
	            bytes[i] = byteCharacters[offset].charCodeAt(0);
	        }
	        byteArrays[sliceIndex] = new Uint8Array(bytes);
	    }

	    var blob = new Blob(byteArrays, {type: contentType});
	    return blob;
	}
	
	
});