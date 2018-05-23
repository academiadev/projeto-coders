angular.module('reembolsoModule').controller('GastosController', function($scope){
  $scope.perfil = {nome: "Felipe Fuerback", email: "fuerback@gmail.com"};

  $scope.gastosTotalUsuario = [
    {valor:'312,00', email:'fuerback@gmail.com', usuario:'Felipe'},
    {valor:'215,00', email:'willian@gmail.com', usuario:'Willian'},
    {valor:'315,00', email:'kauan@gmail.com', usuario:'Kauan'},
    {valor:'415,00', email:'bruno@gmail.com', usuario:'Bruno'}
  ];

  var ctx = document.getElementById("myChart").getContext('2d');
      var myChart = new Chart(ctx, {
          type: 'line',
          data: {
              labels: ["Mai/18", "Jun/18", "Jul/18", "Ago/18", "Set/18", "Out/18", "Nov/18", "Dez/18", "Jan/19"],
              datasets: [{
                  label: 'Hospedagem',
                  data: [126, 191, 152, 260, 390],
                  backgroundColor: [
                      'rgba(38, 135, 233, 0.2)'
                  ],
                  borderColor: [
                      'rgba(38, 135, 233,1)'
                  ],
                  borderWidth: 3,
                  fill: false,
                  lineTension: 0
              },
              {
                  label: 'Transporte',
                  data: [156, 185, 120, 160, 157],
                  backgroundColor: [
                      'rgba(255, 0, 255, 0.2)'
                  ],
                  borderColor: [
                      'rgba(255, 0, 255,1)'
                  ],
                  borderWidth: 3,
                  fill: false,
                  lineTension: 0
              },
              {
                  label: 'Alimentação',
                  data: [132, 122.36, 269, 410, 201],
                  backgroundColor: [
                      'rgba(255, 125, 0, 0.2)'
                  ],
                  borderColor: [
                      'rgba(255, 125, 0, 1)'
                  ],
                  borderWidth: 3,
                  fill: false,
                  lineTension: 0
              },
              {
                  label: 'Outros',
                  data: [169, 258, 360, 198, 340],
                  backgroundColor: [
                      'rgba(0, 255, 0, 0.2)'
                  ],
                  borderColor: [
                      'rgba(0, 255, 0, 1)'
                  ],
                  borderWidth: 3,
                  fill: false,
                  lineTension: 0
              }]

          },
          options: {
            responsive: true,
            scales: {
              yAxes: [{
                display: true,
                ticks: {
                    beginAtZero:true,
                    callback: function(value, index, values) {
                      return 'R$ ' + value;
                    }
                }
              }]
            }
          }
      });
});