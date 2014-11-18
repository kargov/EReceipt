angular.module('starter.services', [])

.factory('ApiService',function($http){
    var serverAddress = 'http://2.110.61.48:8083';
    return {

        doOcr: function(file,onSuccess,onError) {
            var formData = new FormData();
            formData.append('file',file);
            $http.post(serverAddress+'/doOcr', formData, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
            .success(function(data, status) {
                onSuccess(data.content);
            })
            .error(function(data, status) {
                onError(data)
            });
        }
    }
})

.service('UtilityService', function($ionicLoading){
     this.showLoading = function() {
         $ionicLoading.show({
             content: 'Loading Data',
             animation: 'fade-in',
             showBackdrop: false,
             maxWidth: 200,
             showDelay: 500
         });
     };

     this.hideLoading = function() {
         $ionicLoading.hide();
     };
})

.service('RedirectService', function($state){
    this.redirectTo = function(destination) {
        $state.go(destination);
    }
})

.service('HolderService', function(){
    var data;

    this.addReceiptData = function(rawData) {
        data = rawData;
    };

    this.getReceiptData = function() {
        return data;
    };
});