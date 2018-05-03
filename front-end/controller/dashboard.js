var dashboardModulo = angular.module('dashboardModulo', []);

dashboardModulo.controller('dashboardController', function ($scope){
  $scope.reembolsos = [
    {descricao:'Visita', status:'waiting', valor:'312,00', categoria:'Outros', usuario:'Felipe', data:'', selecionado: false},
    {descricao:'Almoço', status:'approved', valor:'215,00', categoria:'Alimentação', usuario:'Willian', data:'', selecionado: false},
    {descricao:'Hotel', status:'canceled', valor:'312,00', categoria:'Hospedagem', usuario:'Kauan', data:'', selecionado: false},
    {descricao:'Uber', status:'canceled', valor:'40,00', categoria:'Transporte', usuario:'Bruno', data:'', selecionado: false}
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

  $scope.setStatusReembolso = function(reembolsos, status) {
    var selecionados = reembolsos.filter(reembolso => reembolso.selecionado == true);
    selecionados.forEach(elemento => {
      for(var i = 0; i < $scope.reembolsos.length; i++){
        if($scope.reembolsos[i].id === elemento.id){
          $scope.reembolsos[i].status = status;
        }
      }
    });
  }

  $scope.isReembolsoSelecionado = function(reembolsos){
    return !reembolsos.some(reembolso => reembolso.selecionado);
  }

  $scope.showSideNav = function() {
    $('.sidenav').sidenav();
  }

  $scope.salvaReembolso = function(reembolso) {
    $scope.reembolsos.push(
      angular.copy({descricao: reembolso.nome, status: 'waiting', valor: input.val().replace('R$', ''), categoria: reembolso.categoria.nome, usuario: 'Felipe', data: reembolso.data}
    ));
    delete $scope.reembolso;
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
  
  $("#checkAll").click(function () {
    console.log('1');
    for(var i = 0; i < $scope.reembolsos.length; i++){
      console.log(this.checked);
      $scope.reembolsos[i].selecionado = this.checked;
    }
    console.log('3');
    $('input:checkbox').not(this).prop('checked', this.checked);
  });
})

$(document).ready(function(){
  $('select').formSelect();
  $('.datepicker').datepicker({
    dateFormat: 'dd/mm/yy'
  });
  $('.modal').modal();
});

