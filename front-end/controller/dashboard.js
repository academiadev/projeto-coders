var dashboardModulo = angular.module('dashboardModulo', []);

dashboardModulo.controller('dashboardController', function ($scope){
  $scope.reembolsos = [
    {descricao:'Visita', status:'waiting', valor:'312,00', categoria:{nome:'Outros', codigo: 4}, usuario:'Felipe', data:'', selecionado: false},
    {descricao:'Almoço', status:'approved', valor:'215,00', categoria:{nome:'Alimentação', codigo: 2}, usuario:'Willian', data:'', selecionado: false},
    {descricao:'Hotel', status:'canceled', valor:'312,00', categoria:{nome:'Hospedagem', codigo: 1}, usuario:'Kauan', data:'', selecionado: false},
    {descricao:'Uber', status:'canceled', valor:'40,00', categoria:{nome:'Transporte', codigo: 3}, usuario:'Bruno', data:'', selecionado: false}
  ];
  $scope.gastosTotalUsuario = [
    {valor:'312,00', email:'fuerback@gmail.com', usuario:'Felipe'},
    {valor:'215,00', email:'willian@gmail.com', usuario:'Willian'},
    {valor:'315,00', email:'kauan@gmail.com', usuario:'Kauan'},
    {valor:'415,00', email:'bruno@gmail.com', usuario:'Bruno'}
  ];
    
  $scope.categorias = [
    {nome:'Hospedagem', codigo: 1},
    {nome:'Alimentação', codigo: 2}, 
    {nome:'Transporte', codigo: 3},
    {nome:'Outros', codigo: 4}
  ];

  $scope.codigoEmpresa = {codigo: '10203'};

  $scope.perfilLogado = {email: 'felipefuerback@hotmail.com', nome: 'Felipe C Fuerback'}

  $scope.setStatusReembolso = function(reembolsos, status) {
    var selecionados = reembolsos.filter(reembolso => reembolso.selecionado == true);
    selecionados.forEach(elemento => {
      elemento.status = status;
      elemento.selecionado = false;
    });
  }

  $scope.isReembolsoSelecionado = function(reembolsos){
    return !reembolsos.some(reembolso => reembolso.selecionado);
  }

  $scope.salvaReembolso = function(reembolso) {
    $scope.reembolsos.push(
      angular.copy({descricao: reembolso.nome, status: 'waiting', valor: input.val().replace('R$', ''), categoria: reembolso.categoria , usuario: 'Felipe', data: reembolso.data}
    ));
    $scope.limparModal();
    delete $scope.reembolso;
  }

  $scope.limparModal = function(){
    $('#formulario')[0].reset();
  }

  $scope.copiarCodigoEmpresa = function() {
    Materialize.toast('Código da empresa copiado!', 2000, 'rounded');
  }

  var input = $("#valor").maskMoney({
    prefix: "R$ ",
    decimal: ",",
    thousands: "."
  });
  
  $("#checkAll").click(function () {
    var selecionados = $scope.reembolsos.filter(reembolso => reembolso.selecionado == false);
    selecionados.forEach(elemento => {
      console.log('teste');
      elemento.selecionado = true;
    });
  });
})

$(document).ready(function(){
  $('select').material_select();

  $('.datepicker').pickadate({
    selectMonths: true,
    selectYears: 15,
    today: 'Hoje',
    clear: 'Limpar',
    close: 'Ok',
    closeOnSelect: false
  });

  $('.modal').modal({
    dismissible: false
  });

  $(".menu-button").sideNav();
});

