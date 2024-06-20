document.addEventListener('DOMContentLoaded', function() {
            const ctxLine = document.getElementById('myChart').getContext('2d');
            new Chart(ctxLine, {
                type: 'line',
                data: {
                    labels: ['Jan/Fev', 'Mar/Abr', 'Mai/Jun', 'Jul/Ago', 'Set/Out', 'Nov/Dez'],
                    datasets: [{
                        label: 'Value of Bitcoin',
                        data: [12, 19, 3, 5, 2, 3],
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: false
                        }
                    }
                }
            });
        });

        document.addEventListener('DOMContentLoaded', function() {
            const ctxDoughnut = document.getElementById('myDoughnutChart').getContext('2d');
            const data = {
                labels: ['cript', 'fiis', 'cdb'],
                datasets: [{
                    label: 'My First Dataset',
                    data: [300, 50, 100],
                    backgroundColor: [
                        'rgb(255, 99, 132)',
                        'rgb(54, 162, 235)',
                        'rgb(255, 205, 86)'
                    ],
                    hoverOffset: 4
                }]
            };

            const config = {
                type: 'doughnut',
                data: data,
            };

            new Chart(ctxDoughnut, config);
        });