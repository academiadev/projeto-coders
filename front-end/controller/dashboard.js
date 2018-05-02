var dashboardModulo = angular.module('dashboardModulo', []);

dashboardModulo.controller('dashboardController', function ($scope){
  $scope.gastosUsuario = [
    {descricao:'Visita', status:'waiting', valor:'312,00', categoria:'Outros', usuario:'Felipe', data:''},
    {descricao:'Almoço', status:'approved', valor:'215,00', categoria:'Alimentação', usuario:'Willian', data:''},
    {descricao:'Hotel', status:'canceled', valor:'312,00', categoria:'Hospedagem', usuario:'Kauan', data:''},
    {descricao:'Uber', status:'canceled', valor:'40,00', categoria:'Transporte', usuario:'Bruno', data:''}
  ];
  $scope.gastosTotalUsuario = [
    {valor:'312,00', email:'fuerback@gmail.com', usuario:'Felipe'},
    {valor:'215,00', email:'willian@gmail.com', usuario:'Willian'},
    {valor:'315,00', email:'kauan@gmail.com', usuario:'Kauan'},
    {valor:'415,00', email:'bruno@gmail.com', usuario:'Bruno'}
  ];
    
  $scope.gastosCategoria = [
    {nome:'Hospedagem', codigo: 1},
    {nome:'Alimentação', codigo: 2}, 
    {nome:'Transporte', codigo: 3},
    {nome:'Outros', codigo: 4}
  ];

  $scope.showModal = function() {
    $('.modal').modal();
  }

  $scope.showSideNav = function() {
    $('.sidenav').sidenav();
  }

  $scope.salvaReembolso = function(reembolso) {
    $scope.gastosUsuario.push({descricao: reembolso.nome, status: 'waiting', valor: input.val().replace('R$', ''), categoria: reembolso.categoria.nome, usuario: 'Felipe', data: reembolso.data});
  }

  $scope.copiarCodigoEmpresa = function() {
    //var codigoEmpresa = document.getElementById("codigoEmpresa");
    //pegar texto do botao e copiar pro clipboard
    M.toast({html: 'Código da empresa copiado!', classes: 'rounded'});
  }

  var input = $("#valor").maskMoney({
    prefix: "R$ ",
    decimal: ",",
    thousands: "."
	});
})

$(document).ready(function(){
  $('select').formSelect();
  $('.datepicker').datepicker({
    dateFormat: 'dd/mm/yy'
  });
});

