angular.module('reembolsoModule').controller('DashboardUsuarioController', function($scope){
  $scope.perfil = {nome: "Felipe Fuerback", email: "fuerback@gmail.com"};

  $scope.reembolsos = [
    {descricao:'Visita3', status:'waiting', valor:'312,00', categoria:{id: '4', nome:'Outros'}, usuario:'Felipe', data:'10/10/2008'},
    {descricao:'Almoço', status:'approved', valor:'215,00', categoria:{id: '2', nome:'Alimentação'}, usuario:'Willian', data:'10/10/2008'},
    {descricao:'Hotel', status:'canceled', valor:'312,00', categoria:{id: '1', nome:'Hospedagem'}, usuario:'Kauan', data:'10/10/2008'},
    {descricao:'Uber', status:'canceled', valor:'40,00', categoria:{id: '3', nome:'Transporte'}, usuario:'Bruno', data:'10/10/2008'}
  ];

  $scope.categorias = [
    {id: '1', nome:'Hospedagem'},
    {id: '2', nome:'Alimentação'}, 
    {id: '3', nome:'Transporte'},
    {id: '4', nome:'Outros'}
  ];

  var input = $("#valor").maskMoney({
    prefix: "R$ ",
    decimal: ",",
    thousands: "."
  });

  $scope.salvaReembolsoUser = function(reembolso) {
    $scope.reembolsos.push(
      angular.copy({descricao: reembolso.nome, status: 'waiting', valor: input.val().replace('R$', ''), categoria: reembolso.categoria , usuario: 'Felipe', data: reembolso.data}
    ));
    $scope.limparModal();
    delete $scope.reembolso;
  }

  $scope.limparModal = function(){
    $('#formulario')[0].reset();
    console.log('salvar');
  }

});