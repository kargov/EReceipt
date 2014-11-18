angular.module('starter.controllers', [])

.controller('DashCtrl', function($scope) {
})

.controller('UploadCtrl', function($scope, $state, ApiService, UtilityService, RedirectService, HolderService) {
    var file;

    $scope.openFileDialog = function() {
        ionic.trigger('click', { target: document.getElementById('file') });
    };

    angular.element('#file').on('change',function(event) {
        file = event.target.files[0];
        $scope.fileName = file.name;
        $scope.$apply();
    });

    $scope.submitForm = function(){
        UtilityService.showLoading();
        ApiService.doOcr(file,onSuccess,onError);
    };

    function onSuccess(data) {
        UtilityService.hideLoading();
        HolderService.addReceiptData(data);
        RedirectService.redirectTo('tab.receipt');
    }

    function onError(data) {

    }
})

.controller('ReceiptCtrl', function($scope,HolderService) {
    $scope.receipt = HolderService.getReceiptData();
});
