angular.module('reembolsoModule', []);

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