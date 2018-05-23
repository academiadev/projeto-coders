angular.module('reembolsoModule').controller('DashboardAdminController', function($scope){

  $scope.reembolsos = [
    {descricao:'Visita 3', status:'waiting', valor:'312,00', categoria:{id: '4', nome:'Outros'}, usuario:'Felipe', data:'10/10/2008'},
    {descricao:'Almoço', status:'approved', valor:'215,00', categoria:{id: '2', nome:'Alimentação'}, usuario:'Willian', data:'10/10/2008'},
    {descricao:'Hotel', status:'canceled', valor:'312,00', categoria:{id: '1', nome:'Hospedagem'}, usuario:'Kauan', data:'10/10/2008'},
    {descricao:'Uber', status:'canceled', valor:'40,00', categoria:{id: '3', nome:'Transporte'}, usuario:'Bruno', data:'10/10/2008'}
  ];

  $scope.selecionaReembolso = function(reembolsoSelecionado) {
    $scope.reembolsoAtual = reembolsoSelecionado;
  }

  $scope.perfil = {nome: "Felipe Fuerback", email: "fuerback@gmail.com"};

  new ClipboardJS('.btn');

  $scope.codigoEmpresa = {codigo: '10203'};

  $scope.copiarCodigoEmpresa = function() {
    Materialize.toast('Código da empresa copiado!', 2000, 'rounded');
  }

  $scope.setStatusReembolso = function(reembolso, status) {
    reembolso.status = status;
  }

  var input = $("#valor").maskMoney({
    prefix: "R$ ",
    decimal: ",",
    thousands: "."
  });
  
});