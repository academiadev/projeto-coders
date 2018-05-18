var dashboardModulo = angular.module('dashboardModulo', []);

dashboardModulo.controller('dashboardController', function ($scope){
  $scope.reembolsos = [
    {descricao:'Visita', status:'waiting', valor:'312,00', categoria:{id: '4', nome:'Outros'}, usuario:'Felipe', data:'10/10/2008'},
    {descricao:'Almoço', status:'approved', valor:'215,00', categoria:{id: '2', nome:'Alimentação'}, usuario:'Willian', data:'10/10/2008'},
    {descricao:'Hotel', status:'canceled', valor:'312,00', categoria:{id: '1', nome:'Hospedagem'}, usuario:'Kauan', data:'10/10/2008'},
    {descricao:'Uber', status:'canceled', valor:'40,00', categoria:{id: '3', nome:'Transporte'}, usuario:'Bruno', data:'10/10/2008'}
  ];
  $scope.gastosTotalUsuario = [
    {valor:'312,00', email:'fuerback@gmail.com', usuario:'Felipe'},
    {valor:'215,00', email:'willian@gmail.com', usuario:'Willian'},
    {valor:'315,00', email:'kauan@gmail.com', usuario:'Kauan'},
    {valor:'415,00', email:'bruno@gmail.com', usuario:'Bruno'}
  ];
    
  $scope.categorias = [
    {id: '1', nome:'Hospedagem'},
    {id: '2', nome:'Alimentação'}, 
    {id: '3', nome:'Transporte'},
    {id: '4', nome:'Outros'}
  ];

  $scope.codigoEmpresa = {codigo: '10203'};

  $scope.perfilLogado = {email: 'felipefuerback@hotmail.com', nome: 'Felipe C Fuerback'}

  $scope.atualizarPerfil = function(){
    Materialize.toast('Perfil atualizado!', 2000, 'rounded');
  }

  $scope.selecionaReembolso = function(reembolsoSelecionado){
    $scope.reembolsoAtual = reembolsoSelecionado;
    $scope.reembolsoAtual.categoria.nome = reembolsoSelecionado.categoria.nome;
    console.log(reembolsoSelecionado.categoria.nome);
  }

  $scope.setStatusReembolso = function(reembolso, status) {
    reembolso.status = status;
    reembolso.selecionado = false;
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

  Materialize.updateTextFields();
});

