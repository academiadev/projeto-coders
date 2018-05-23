angular.module('reembolsoModule').controller('PerfilController', function($scope){
  $scope.perfil = {nome: "Felipe Fuerback", email: "fuerback@gmail.com"};

  $scope.atualizarPerfil = function(){
    console.log('teste');
    Materialize.toast('Perfil atualizado!', 2000, 'rounded');
  }
});