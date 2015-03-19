cordova.define("com.butterflyeffect.plugins.gpsDetector", function(require, exports, module) { cordova.define('cordova/plugin/gpsDetectionPlugin', function(require, exports, module) {

    var exec = require('cordova/exec');

    var gpsDetect = function() {};

    gpsDetect.prototype.checkGPS = function(successCallback, failureCallback) {
    	exec(successCallback, failureCallback, 'GpsDetectionPlugin', 'gpsDetection', []);
    };
	
	gpsDetect.prototype.checkNetwork = function(successCallback, failureCallback) {
    	exec(successCallback, failureCallback, 'GpsDetectionPlugin', 'npDetection', []);
    };
	
	gpsDetect.prototype.openGPSSettingDialog = function(successCallback, failureCallback) {
    	exec(successCallback, failureCallback, 'GpsDetectionPlugin', 'gpsSettingDialog', []);
    };
	
	gpsDetect.prototype.serviceLocationAction = function(successCallback, failureCallback) {
    	exec(successCallback, failureCallback, 'GpsDetectionPlugin', 'serviceLocationAction', []);
    };
    	
    var gpsDetect = new gpsDetect();
    module.exports = gpsDetect;
});
});
