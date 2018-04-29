var dashboardModulo = angular.module('dashboardModulo', []);

dashboardModulo.controller('dashboardController', function ($scope){
  $scope.gastosUsuario = [
    {descricao:'Visita', status:'waiting', valor:'312.00', categoria:'Outros', usuario:'Felipe'},
    {descricao:'Almoço', status:'approved', valor:'215.00', categoria:'Alimentação', usuario:'Willian'},
    {descricao:'Hotel', status:'canceled', valor:'312.00', categoria:'Hospedagem', usuario:'Kauan'},
    {descricao:'Uber', status:'canceled', valor:'40.00', categoria:'Transporte', usuario:'Bruno'}
  ];
  $scope.gastosTotalUsuario = [
    {valor:'312.00', email:'fuerback@gmail.com', usuario:'Felipe'},
    {valor:'215.00', email:'willian@gmail.com', usuario:'Willian'},
    {valor:'315.00', email:'kauan@gmail.com', usuario:'Kauan'},
    {valor:'415.00', email:'bruno@gmail.com', usuario:'Bruno'},
  ];

  $scope.showModal = function() {
    $('.modal').modal();
  }

  $scope.showSideNav = function() {
    $('.sidenav').sidenav();
  }

  $scope.fechaModal = function() {
    $('.modal').modal().close();
  }

  $scope.copiarCodigoEmpresa = function() {
    //var codigoEmpresa = document.getElementById("codigoEmpresa");
    //pegar texto do botao e copiar pro clipboard
    M.toast({html: 'Código da empresa copiado!', classes: 'rounded'});
  }
})

$(document).ready(function(){
  $('select').formSelect();
  $('.datepicker').datepicker({
    dateFormat: 'dd/mm/yy'
  });

  $("#valor").maskMoney({
    prefix: "R$ ",
    decimal: ",",
    thousands: "."
	});
});

